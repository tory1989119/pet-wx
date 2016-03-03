package com.pet.wx.manager.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pet.wx.common.enums.ErrorCode;
import com.pet.wx.common.enums.GlobConstants;
import com.pet.wx.db.dao.WxGroupDao;
import com.pet.wx.db.dto.BaseResponseDto;
import com.pet.wx.db.dto.SysSearchDto;
import com.pet.wx.db.inf.WxClient;
import com.pet.wx.db.model.WxGroupInfo;

@Service
public class WxGroupService {
	@Autowired
	private WxGroupDao wxGroupDao;
	
	@Autowired
	private WxClient wxClient;
	/**
	 *新增用户分组
	 * 
	 * @param wxGroup
	 * @return
	 */
	public BaseResponseDto<Object> insertWxGroup(WxGroupInfo wxGroup) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		JsonObject jo = wxClient.groupCreate(wxGroup.getName());
		if(jo.get("errcode") == null || jo.get("errcode").getAsInt() == GlobConstants.WX_RESULT_FLAG_SUCCESSED){
			wxGroup.setGroupId(jo.get("group").getAsJsonObject().get("id").getAsLong());
			wxGroup.setCount(0);
			wxGroupDao.insertWxGroup(wxGroup);
		}else{
			br.setErrorCode(ErrorCode.wx_error.getCode());
			br.setContent(jo.get("errcode").getAsString() + "--" + jo.get("errmsg").getAsString());
		}
		
		return br;
	}
	
	/**
	 * 根据id获取分组信息
	 * @param id
	 * @return
	 */
	public WxGroupInfo getWxGroupInfo(String id){
		return wxGroupDao.getWxGroupInfo(id);
	}

	/**
	 * 查询微信用户分组列表
	 * 
	 * @param searchDto
	 * @return
	 */
	public BaseResponseDto<Object> queryWxGroup(SysSearchDto searchDto) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		br.setContent(wxGroupDao.queryWxGroup(searchDto));
		br.setPageCount(wxGroupDao.countWxGroup(searchDto));
		return br;
	}
	
	/**
	 * 同步微信用户分组数据
	 */
	public BaseResponseDto<Object> syncWxGroup(){
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		JsonObject jo = wxClient.groupQuery();
		if(jo.get("errcode") == null || jo.get("errcode").getAsInt() == GlobConstants.WX_RESULT_FLAG_SUCCESSED){
			wxGroupDao.truncateWxGroup();//清空微信用户组表
			JsonArray ja = jo.get("groups").getAsJsonArray();
			for (int i = 0; i < ja.size(); i++) {
				WxGroupInfo wxGroupInfo = new WxGroupInfo();
				wxGroupInfo.setGroupId(ja.get(i).getAsJsonObject().get("id").getAsLong());
				wxGroupInfo.setName(ja.get(i).getAsJsonObject().get("name").getAsString());
				wxGroupInfo.setCount(ja.get(i).getAsJsonObject().get("count").getAsInt());
				wxGroupDao.insertWxGroup(wxGroupInfo);
			}
		}else{
			br.setErrorCode(ErrorCode.wx_error.getCode());
			br.setContent(jo.get("errcode").getAsString() + "--" + jo.get("errmsg").getAsString());
		}
		return br;
	}
	
	/**
	 *删除分组
	 * 
	 * @param wxGroup
	 * @return
	 */
	public BaseResponseDto<Object> deleteWxGroup(WxGroupInfo wxGroup) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		JsonObject jo = wxClient.groupDelete(wxGroup.getGroupId());
		if(jo.get("errcode") == null || jo.get("errcode").getAsInt() == GlobConstants.WX_RESULT_FLAG_SUCCESSED){
			wxGroupDao.deleteWxGroup(wxGroup.getId());
		}else{
			br.setErrorCode(ErrorCode.wx_error.getCode());
			br.setContent(jo.get("errcode").getAsString() + "--" + jo.get("errmsg").getAsString());
		}
		return br;
	}
	
	/**
	 *更新分组
	 * 
	 * @param wxGroup
	 * @return
	 */
	public BaseResponseDto<Object> updateWxGroup(WxGroupInfo wxGroup) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		JsonObject jo = wxClient.groupUpdate(wxGroup.getGroupId(), wxGroup.getName());
		if(jo.get("errcode") == null || jo.get("errcode").getAsInt() == GlobConstants.WX_RESULT_FLAG_SUCCESSED){
			wxGroupDao.updateWxGroup(wxGroup);
		}else{
			br.setErrorCode(ErrorCode.wx_error.getCode());
			br.setContent(jo.get("errcode").getAsString() + "--" + jo.get("errmsg").getAsString());
		}
		return br;
	}
}
