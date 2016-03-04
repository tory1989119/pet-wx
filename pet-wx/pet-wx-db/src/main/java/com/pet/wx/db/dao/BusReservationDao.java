package com.pet.wx.db.dao;

import java.util.List;

import com.pet.wx.db.dto.SysSearchDto;
import com.pet.wx.db.model.BusReservationInfo;

public interface BusReservationDao {
	/**
	 * 插入信息
	 * @param busReservation
	 */
	public void insertBusReservation(BusReservationInfo busReservation);
	
	/**
	 * 根据id获取预约信息
	 * @param id
	 * @return
	 */
	public BusReservationInfo getBusReservationInfo(String id);
	
	/**
	 * 查询微信用户预约列表 
	 * @param sysSearchDto
	 * @return
	 */
	public List<BusReservationInfo> queryBusReservation(SysSearchDto sysSearchDto);
	
	/**
	 * 查询微信用户预约列表数
	 * @param sysSearchDto
	 * @return
	 */
	public int countBusReservation(SysSearchDto sysSearchDto);
}
