package com.pet.wx.db.dao;

import java.util.List;

import com.pet.wx.db.model.WxMenuInfo;

public interface WxMenuDao {

	/**
	 * 插入微信菜单
	 * 
	 * @param wxMenu
	 */
	public void insertWxMenu(WxMenuInfo wxMenu);

	/**
	 * 根据ID获取微信菜单信息
	 * 
	 * @param id
	 * @return
	 */
	public WxMenuInfo getWxMenuInfoById(String id);

	/**
	 * 查询微信一级菜单
	 * 
	 * @return
	 */
	public List<WxMenuInfo> queryOneLevelWxMenu();

	/**
	 * 查询微信一级菜单数
	 * 
	 * @return
	 */
	public int countOneLevelWxMenu();

	/**
	 * 查询微信二级菜单
	 * 
	 * @param fid
	 * @return
	 */
	public List<WxMenuInfo> querySecondLevelWxMenu(Long fid);

	/**
	 * 查询微信二级菜单数
	 * 
	 * @param fid
	 * @return
	 */
	public int countSecondLevelWxMenu(Long fid);

	/**
	 * 删除菜单
	 * 
	 * @param id
	 */
	public void deleteWxMenu(String id);

	/**
	 * 修改菜单
	 * @param wxMenu
	 */
	public void updateWxMenu(WxMenuInfo wxMenu);
}
