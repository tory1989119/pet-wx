package com.pet.wx.db.dao;

import java.util.List;

import com.pet.wx.db.dto.SysSearchDto;
import com.pet.wx.db.model.WxUserInfo;

public interface WxUserDao {

	/**
	 * 插入微信用户
	 * 
	 * @param wxUser
	 */
	public void insertWxUser(WxUserInfo wxUser);

	/**
	 * 修改关注状态
	 * 
	 * @param wxUser
	 */
	public void subscribe(WxUserInfo wxUser);
	
	/**
	 * 修改用户分组
	 * 
	 * @param wxUser
	 */
	public void updateWxUserGroup(WxUserInfo wxUser);
	
	/**
	 * 根据OPENID获取微信用户信息
	 * 
	 * @param openid
	 * @return
	 */
	public WxUserInfo getWxUserByOpenid(String openid);

	/**
	 * 根据ID获取微信用户信息
	 * 
	 * @param id
	 * @return
	 */
	public WxUserInfo getWxUserById(String id);

	/**
	 * 查询微信用户列表
	 * 
	 * @param searchDto
	 * @return
	 */
	public List<WxUserInfo> queryWxUser(SysSearchDto searchDto);

	/**
	 * 查询微信用户列表数
	 * 
	 * @param searchDto
	 * @return
	 */
	public int countWxUser(SysSearchDto searchDto);
	
	/**
	 * 清空表数据
	 */
	public void truncateWxUser();
}
