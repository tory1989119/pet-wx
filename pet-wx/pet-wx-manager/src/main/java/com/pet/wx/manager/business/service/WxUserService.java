package com.pet.wx.manager.business.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pet.wx.common.enums.ErrorCode;
import com.pet.wx.common.utils.GsonUtils;
import com.pet.wx.db.dao.WxUserDao;
import com.pet.wx.db.dto.BaseResponseDto;
import com.pet.wx.db.dto.SysSearchDto;
import com.pet.wx.db.inf.WxClient;
import com.pet.wx.db.model.WxUserInfo;

@Service
public class WxUserService {
	@Autowired
	private WxUserDao wxUserDao;
	@Autowired
	private WxClient wxClient;

	/**
	 * 根据ID获取微信用户信息
	 * 
	 * @param id
	 * @return
	 */
	public WxUserInfo getWxUserById(String id) {
		return wxUserDao.getWxUserById(id);
	}

	/**
	 * 查询微信用户列表
	 * 
	 * @param searchDto
	 * @return
	 */
	public BaseResponseDto<Object> queryWxUser(SysSearchDto searchDto) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		br.setContent(wxUserDao.queryWxUser(searchDto));
		br.setPageCount(wxUserDao.countWxUser(searchDto));
		return br;
	}
	
	/**
	 * 同步微信用户数据
	 */
	public BaseResponseDto<Object> syncWxUser(){
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		String next_openid = "";
		boolean flag = true;
		wxUserDao.truncateWxUser();//清空微信用户表
		while (flag) {
			JsonObject jo = wxClient.userQueryAll(next_openid);
			if(jo.get("errcode") == null){
				if(jo.get("count").getAsInt() > 0){
					JsonArray ja = jo.get("data").getAsJsonObject().get("openid").getAsJsonArray();
					br = syncInsertWxUser(ja);
					if(!br.getErrorCode().equals(ErrorCode.sucessed.getCode())){
						flag = false;
					}else{
						next_openid = jo.get("next_openid").getAsString();
					}
				}else{
					flag = false;
				}
			}else{
				br.setErrorCode(ErrorCode.wx_error.getCode());
				br.setContent(jo.get("errcode").getAsString() + "--" + jo.get("errmsg").getAsString());
				flag = false;
			}
		}
		return br;
	}
	
	/**
	 * 同步插入数据
	 * @param access_token
	 * @param ja
	 */
	private BaseResponseDto<Object> syncInsertWxUser(JsonArray ja){
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		for (int i = 0; i < ja.size(); i++) {
			String openid = ja.get(i).getAsString();
			WxUserInfo wxUser = GsonUtils.fromJson(wxClient.userInfo(openid).toString(), WxUserInfo.class,true);
			if(wxUser.getErrcode() == null){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String date = sdf.format(new Date(wxUser.getSubscribe_time()*1000));
				wxUser.setSubscribeTime(date);
				wxUserDao.insertWxUser(wxUser);
			}else{
				br.setErrorCode(ErrorCode.wx_error.getCode());
				br.setContent(wxUser.getErrcode() + "--" + wxUser.getErrmsg());
				break;
			}
		}
		return br;
	}
}
