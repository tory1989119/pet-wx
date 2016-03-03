package com.pet.wx.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.wx.db.dao.WxMetarialDao;
import com.pet.wx.db.model.WxMetarialInfo;

@Service
public class PetHospitalService {
	@Autowired
	private WxMetarialDao wxMetarialDao;
	
	/**
	 * 查询最新的素材记录
	 * @return
	 */
	public List<WxMetarialInfo> queryWxMetarialForSchool(Integer rows){
		return wxMetarialDao.queryWxMetarialForSchool(rows);
	}
}
