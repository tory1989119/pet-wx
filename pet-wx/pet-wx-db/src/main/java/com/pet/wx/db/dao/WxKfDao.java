package com.pet.wx.db.dao;

import java.util.List;

import com.pet.wx.db.dto.SysSearchDto;
import com.pet.wx.db.model.WxKfInfo;

public interface WxKfDao {
	
	/**
	 * 插入客服
	 * @param wxKf
	 */
	public void insertWxKf(WxKfInfo wxKf);
	
	/**
	 * 根据id获取客服信息
	 * @param id
	 * @return
	 */
	public WxKfInfo getWxKfInfo(String id);
	
	/**
	 * 查询客服列表 
	 * @param sysSearchDto
	 * @return
	 */
	public List<WxKfInfo> queryWxKf(SysSearchDto sysSearchDto);
	
	/**
	 * 查询客服列表数
	 * @param sysSearchDto
	 * @return
	 */
	public int countWxKf(SysSearchDto sysSearchDto);
	
	/**
	 * 清空表数据
	 */
	public void truncateWxKf();
	
	/**
	 * 删除客服
	 * @param id
	 */
	public void deleteWxKf(Long id);
	
	/**
	 * 更新客服
	 * @param wxKf
	 */
	public void updateWxKf(WxKfInfo wxKf);
}
