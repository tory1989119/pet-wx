package com.pet.wx.manager.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pet.wx.db.dao.BusReservationDao;
import com.pet.wx.db.dto.BaseResponseDto;
import com.pet.wx.db.dto.SysSearchDto;
import com.pet.wx.db.model.BusReservationInfo;

@Service
public class BusReservationService {
	@Autowired
	private BusReservationDao busReservationDao;
	/**
	 * 根据id获取预约信息
	 * @param id
	 * @return
	 */
	public BusReservationInfo getBusReservationInfo(String id){
		return busReservationDao.getBusReservationInfo(id);
	}
	
	/**
	 * 查询微信用户预约列表 
	 * @param sysSearchDto
	 * @return
	 */
	public BaseResponseDto<Object> queryBusReservation(SysSearchDto SearchDto){
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		br.setContent(busReservationDao.queryBusReservation(SearchDto));
		br.setPageCount(busReservationDao.countBusReservation(SearchDto));
		return br;
	}
}
