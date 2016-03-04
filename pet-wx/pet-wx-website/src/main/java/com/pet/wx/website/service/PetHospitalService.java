package com.pet.wx.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.pet.wx.common.enums.WxConsts;
import com.pet.wx.common.utils.Configuration;
import com.pet.wx.db.dao.BusReservationDao;
import com.pet.wx.db.dao.WxMetarialDao;
import com.pet.wx.db.dao.WxUserDao;
import com.pet.wx.db.inf.WxClient;
import com.pet.wx.db.model.BusReservationInfo;
import com.pet.wx.db.model.WxMetarialInfo;
import com.pet.wx.db.model.WxUserInfo;

@Service
public class PetHospitalService {
	@Autowired
	private WxMetarialDao wxMetarialDao;
	@Autowired
	private WxClient wxClient;
	@Autowired
	private WxUserDao wxUserDao;
	@Autowired
	BusReservationDao busReservationDao;
	
	
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
	
	/**
	 * 获取微信用户信息
	 * @param openid
	 * @return
	 */
	public WxUserInfo getWxUserByOpenid (String openid){
		return wxUserDao.getWxUserByOpenid(openid);
	}
	
	/**
	 * 插入信息
	 * @param busReservation
	 */
	public void insertBusReservation(BusReservationInfo busReservation){
		busReservationDao.insertBusReservation(busReservation);
	}
}
