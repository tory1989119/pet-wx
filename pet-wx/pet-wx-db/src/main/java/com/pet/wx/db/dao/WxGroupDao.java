package com.pet.wx.db.dao;

import java.util.List;

import com.pet.wx.db.dto.SysSearchDto;
import com.pet.wx.db.model.WxGroupInfo;

public interface WxGroupDao {
	
	/**
	 * 插入信息
	 * @param wxGroup
	 */
	public void insertWxGroup(WxGroupInfo wxGroup);
	
	/**
	 * 根据id获取分组信息
	 * @param id
	 * @return
	 */
	public WxGroupInfo getWxGroupInfo(String id);
	
	/**
	 * 查询微信用户分组列表 
	 * @param sysSearchDto
	 * @return
	 */
	public List<WxGroupInfo> queryWxGroup(SysSearchDto sysSearchDto);
	
	/**
	 * 查询微信用户分组列表数
	 * @param sysSearchDto
	 * @return
	 */
	public int countWxGroup(SysSearchDto sysSearchDto);
	
	/**
	 * 清空表数据
	 */
	public void truncateWxGroup();
	
	/**
	 * 删除分组
	 * @param id
	 */
	public void deleteWxGroup(Long id);
	
	/**
	 * 更新分组信息
	 * @param wxGroup
	 */
	public void updateWxGroup(WxGroupInfo wxGroup);
}
