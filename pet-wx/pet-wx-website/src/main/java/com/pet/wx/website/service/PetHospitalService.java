package com.pet.wx.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.pet.wx.common.enums.WxConsts;
import com.pet.wx.common.utils.Configuration;
import com.pet.wx.db.dao.WxMetarialDao;
import com.pet.wx.db.inf.WxClient;
import com.pet.wx.db.model.WxMetarialInfo;

@Service
public class PetHospitalService {
	@Autowired
	private WxMetarialDao wxMetarialDao;
	@Autowired
	private WxClient wxClient;
	
	
	/**
	 * 查询最新的素材记录
	 * @return
	 */
	public List<WxMetarialInfo> queryWxMetarialForSchool(Integer rows){
		return wxMetarialDao.queryWxMetarialForSchool(rows);
	}
	
	/**
	 * 获取授权信息
	 * @param code
	 * @return
	 */
	public JsonObject authorize(String code){
		String grant_type = WxConsts.WY_GRANT_TYPE;
		String appid = Configuration.getGlobalMsg("appid");
		String secret = Configuration.getGlobalMsg("secret");
		return wxClient.authorize(grant_type, appid, secret, code);
	}
}
