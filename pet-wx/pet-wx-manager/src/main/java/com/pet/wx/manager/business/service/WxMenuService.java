package com.pet.wx.manager.business.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.wx.common.enums.ErrorCode;
import com.pet.wx.common.enums.GlobConstants;
import com.pet.wx.common.utils.GsonUtils;
import com.pet.wx.db.dao.WxMenuDao;
import com.pet.wx.db.dto.BaseResponseDto;
import com.pet.wx.db.dto.WxErrorDto;
import com.pet.wx.db.dto.WxMenuDto;
import com.pet.wx.db.inf.WxClient;
import com.pet.wx.db.model.WxMenuInfo;

@Service
public class WxMenuService {
	@Autowired
	private WxMenuDao wxMenuDao;
	@Autowired
	private WxClient wxClient;

	/**
	 * 插入微信菜单
	 * 
	 * @param wxMenu
	 */
	public boolean insertWxMenu(WxMenuInfo wxMenu) {
		if(wxMenu.getFid() == null){
			if(wxMenuDao.countOneLevelWxMenu() >=3){
				return false;
			}
		}else{
			if(wxMenuDao.countSecondLevelWxMenu(wxMenu.getFid()) >= 5){
				return false;
			}
		}
		
		try {
			wxMenuDao.insertWxMenu(wxMenu);
		} catch (Exception e) {
			try {
				throw new Exception(e.toString());
			} catch (Exception e1) {
				
			}
		}
		return true;
	}

	/**
	 * 根据ID获取微信菜单信息
	 * 
	 * @param id
	 * @return
	 */
	public WxMenuInfo getWxMenuInfoById(String id) {
		return wxMenuDao.getWxMenuInfoById(id);
	}

	/**
	 * 查询微信一级菜单
	 * 
	 * @return
	 */
	public BaseResponseDto<Object> queryOneLevelWxMenu() {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		br.setContent(wxMenuDao.queryOneLevelWxMenu());
		br.setPageCount(wxMenuDao.countOneLevelWxMenu());
		return br;
	}

	/**
	 * 查询微信二级菜单
	 * 
	 * @param fid
	 * @return
	 */
	public BaseResponseDto<Object> querySecondLevelWxMenu(Long fid) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		br.setContent(wxMenuDao.querySecondLevelWxMenu(fid));
		br.setPageCount(wxMenuDao.countSecondLevelWxMenu(fid));
		return br;
	}

	/**
	 * 删除菜单
	 * 
	 * @param id
	 */
	public void deleteWxMenu(String id) {
		wxMenuDao.deleteWxMenu(id);
	}
	
	/**
	 * 修改微信菜单
	 * 
	 * @param wxMenu
	 */
	public void updateWxMenu(WxMenuInfo wxMenu) {
		wxMenuDao.updateWxMenu(wxMenu);
	}

	/**
	 * 同步微信用户数据
	 */
	public BaseResponseDto<Object> syncWxMenu(){
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		WxErrorDto we = GsonUtils.fromJson(wxClient.menuDelete().toString(), WxErrorDto.class,true);
		if(we.getErrcode() == GlobConstants.WX_RESULT_FLAG_SUCCESSED){
			List<WxMenuInfo> oneLevelList = wxMenuDao.queryOneLevelWxMenu();
			List<WxMenuDto> menuList = new ArrayList<WxMenuDto>();
			for (int i = 0; i < oneLevelList.size(); i++) {
				WxMenuInfo oneLevelWmi = oneLevelList.get(i);
				WxMenuDto oneLevelWmd = new WxMenuDto();
				oneLevelWmd.setName(oneLevelWmi.getName());
				if(!oneLevelWmi.getType().equals("") && oneLevelWmi.getType() !=null){
					oneLevelWmd.setType(oneLevelWmi.getType());
				}
				if(!oneLevelWmi.getMenuKey().equals("") && oneLevelWmi.getMenuKey() !=null){
					oneLevelWmd.setKey(oneLevelWmi.getMenuKey());
				}
				if(!oneLevelWmi.getMediaId().equals("") && oneLevelWmi.getMediaId() !=null){
					oneLevelWmd.setMedia_id(oneLevelWmi.getMediaId());
				}
				if(!oneLevelWmi.getUrl().equals("") && oneLevelWmi.getUrl() !=null){
					oneLevelWmd.setUrl(oneLevelWmi.getUrl());
				}
				
				List<WxMenuInfo> secondLevelList = wxMenuDao.querySecondLevelWxMenu(oneLevelWmi.getId());
				List<WxMenuDto> subMenuList = new ArrayList<WxMenuDto>();
				for (int j = 0; j < secondLevelList.size(); j++) {
					WxMenuInfo secondLevelWmi = secondLevelList.get(j);
					WxMenuDto secondLevelWmd = new WxMenuDto();
					secondLevelWmd.setName(secondLevelWmi.getName());
					if(!secondLevelWmi.getType().equals("") && secondLevelWmi.getType() !=null){
						secondLevelWmd.setType(secondLevelWmi.getType());
					}
					if(!secondLevelWmi.getMenuKey().equals("") && secondLevelWmi.getMenuKey() !=null){
						secondLevelWmd.setKey(secondLevelWmi.getMenuKey());
					}
					if(!secondLevelWmi.getMediaId().equals("") && secondLevelWmi.getMediaId() !=null){
						secondLevelWmd.setMedia_id(secondLevelWmi.getMediaId());
					}
					if(!secondLevelWmi.getUrl().equals("") && secondLevelWmi.getUrl() !=null){
						secondLevelWmd.setUrl(secondLevelWmi.getUrl());
					}
					subMenuList.add(secondLevelWmd);
				}
				if(subMenuList.size() > 0){
					oneLevelWmd.setSub_button(subMenuList);
				}
				menuList.add(oneLevelWmd);
			}
			
			if(menuList.size() > 0){
				we = GsonUtils.fromJson(wxClient.menuCreate(menuList).toString(), WxErrorDto.class, true);
				if(we.getErrcode() != GlobConstants.WX_RESULT_FLAG_SUCCESSED){
					br.setErrorCode(ErrorCode.wx_error.getCode());
					br.setContent(we.getErrcode() + "--" + we.getErrmsg());
				}
			}
		}else{
			br.setErrorCode(ErrorCode.wx_error.getCode());
			br.setContent(we.getErrcode() + "--" + we.getErrmsg());
		}
		return br;
	}
}
