package com.pet.wx.manager.business.service;



import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pet.wx.common.enums.ErrorCode;
import com.pet.wx.common.enums.GlobConstants;
import com.pet.wx.db.dao.WxKfDao;
import com.pet.wx.db.dto.BaseResponseDto;
import com.pet.wx.db.dto.SysSearchDto;
import com.pet.wx.db.inf.WxClient;
import com.pet.wx.db.model.WxKfInfo;

@Service
public class WxKfService {
	@Autowired
	private WxKfDao wxKfDao;
	@Autowired
	private WxClient wxClient;
	
	/**
	 *新增客服
	 * 
	 * @param wxKf
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public BaseResponseDto<Object> insertWxKf(WxKfInfo wxKf) throws UnsupportedEncodingException {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		JsonObject jo = wxClient.kfCreate(wxKf);
		if(jo.get("errcode") == null || jo.get("errcode").getAsInt() == GlobConstants.WX_RESULT_FLAG_SUCCESSED){
			wxKfDao.insertWxKf(wxKf);
		}else{
			br.setErrorCode(ErrorCode.wx_error.getCode());
			br.setContent(jo.get("errcode").getAsString() + "--" + jo.get("errmsg").getAsString());
		}
		
		return br;
	}
	
	/**
	 * 根据id获取客服
	 * @param id
	 * @return
	 */
	public WxKfInfo getWxKfInfo(String id){
		return wxKfDao.getWxKfInfo(id);
	}

	/**
	 * 查询客服列表
	 * 
	 * @param searchDto
	 * @return
	 */
	public BaseResponseDto<Object> queryWxKf(SysSearchDto searchDto) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		br.setContent(wxKfDao.queryWxKf(searchDto));
		br.setPageCount(wxKfDao.countWxKf(searchDto));
		return br;
	}
	
	/**
	 * 同步客服数据
	 */
	public BaseResponseDto<Object> syncWxKf(){
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		JsonObject jo = wxClient.kfQuery();
		if(jo.get("errcode") == null || jo.get("errcode").getAsInt() == GlobConstants.WX_RESULT_FLAG_SUCCESSED){
			wxKfDao.truncateWxKf();//清空微信用户组表
			JsonArray ja = jo.get("kf_list").getAsJsonArray();
			for (int i = 0; i < ja.size(); i++) {
				WxKfInfo wxKfInfo = new WxKfInfo();
				wxKfInfo.setKfId(ja.get(i).getAsJsonObject().get("kf_id").getAsString());
				wxKfInfo.setKfAccount(ja.get(i).getAsJsonObject().get("kf_account").getAsString());
				wxKfInfo.setNickname(ja.get(i).getAsJsonObject().get("kf_nick").getAsString());
				wxKfInfo.setKfHeadimgurl(ja.get(i).getAsJsonObject().get("kf_headimgurl").getAsString());
				wxKfDao.insertWxKf(wxKfInfo);
			}
		}else{
			br.setErrorCode(ErrorCode.wx_error.getCode());
			br.setContent(jo.get("errcode").getAsString() + "--" + jo.get("errmsg").getAsString());
		}
		return br;
	}
	
	/**
	 *删除客服
	 * 
	 * @param wxKf
	 * @return
	 */
	public BaseResponseDto<Object> deleteWxKf(WxKfInfo wxKf) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		JsonObject jo = wxClient.kfDelete(wxKf.getKfAccount());
		if(jo.get("errcode") == null || jo.get("errcode").getAsInt() == GlobConstants.WX_RESULT_FLAG_SUCCESSED){
			wxKfDao.deleteWxKf(wxKf.getId());
		}else{
			br.setErrorCode(ErrorCode.wx_error.getCode());
			br.setContent(jo.get("errcode").getAsString() + "--" + jo.get("errmsg").getAsString());
		}
		return br;
	}
	
	/**
	 *更新客服
	 * 
	 * @param wxKf
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public BaseResponseDto<Object> updateWxKf(WxKfInfo wxKf) throws UnsupportedEncodingException {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		JsonObject jo = wxClient.kfUpdate(wxKf);
		if(jo.get("errcode") == null || jo.get("errcode").getAsInt() == GlobConstants.WX_RESULT_FLAG_SUCCESSED){
			wxKfDao.updateWxKf(wxKf);
		}else{
			br.setErrorCode(ErrorCode.wx_error.getCode());
			br.setContent(jo.get("errcode").getAsString() + "--" + jo.get("errmsg").getAsString());
		}
		return br;
	}
}
