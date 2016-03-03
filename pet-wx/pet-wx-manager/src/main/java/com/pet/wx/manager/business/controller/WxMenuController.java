package com.pet.wx.manager.business.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pet.wx.common.enums.ErrorCode;
import com.pet.wx.db.dto.BaseResponseDto;
import com.pet.wx.db.model.WxMenuInfo;
import com.pet.wx.manager.business.service.WxMenuService;

@Controller
@RequestMapping("/bus/menu")
public class WxMenuController {
	@Autowired
	WxMenuService wxMenuService;

	private Logger logger = LoggerFactory.getLogger(WxMenuController.class);

	private final String WX_MENU_MANA_PAGE = "bus/menu/wxMenuMana"; // 微信菜单管理界面
	private final String WX_SUB_MENU_MANA_PAGE = "bus/menu/wxSubMenuMana"; // 微信子菜单管理界面
	private final String WX_MENU_INFO_PAGE = "bus/menu/wxMenuInfo"; // 微信菜单详情界面
	private final String ADD_WX_MENU__PAGE = "bus/menu/addWxMenu"; // 添加微信菜单界面
	private final String MODIFY_WX_MENU__PAGE = "bus/menu/modifyWxMenu"; // 修改微信菜单界面

	/**
	 * 跳转到微信菜单管理界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "wxMenuManaPage.do", method = RequestMethod.GET)
	public String wxMenuManaPage() {
		return WX_MENU_MANA_PAGE;
	}

	/**
	 * 跳转到微信子菜单管理界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "wxSubMenuManaPage.do", method = RequestMethod.GET)
	public String wxSubMenuManaPage(HttpServletRequest request,Long fid) {
		request.setAttribute("fid", fid);
		return WX_SUB_MENU_MANA_PAGE;
	}

	/**
	 * 跳转到添加微信菜单界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "addWxMenuPage.do", method = RequestMethod.GET)
	public String addWxMenuPage(HttpServletRequest request,Long fid) {
		request.setAttribute("fid", fid);
		return ADD_WX_MENU__PAGE;
	}

	/**
	 * 查询微信一级菜单列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "queryOneLevelWxMenu.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> queryOneLevelWxMenu() {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxMenuService.queryOneLevelWxMenu();
		} catch (Exception e) {
			logger.error("WxMenuController.queryOneLevelWxMenu", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}

	/**
	 * 查询微信二级菜单列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "querySecondLevelWxMenu.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> querySecondLevelWxMenu(Long fid) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxMenuService.querySecondLevelWxMenu(fid);
		} catch (Exception e) {
			logger.error("WxMenuController.querySecondLevelWxMenu", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}

	/**
	 * 跳转微信用户详细信息页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "wxMenuInfoPage.do", method = RequestMethod.GET)
	public String wxMenuInfoPage(HttpServletRequest request, String id) {
		try {
			WxMenuInfo wxMenuInfo = wxMenuService.getWxMenuInfoById(id);
			request.setAttribute("wxMenuInfo", wxMenuInfo);
		} catch (Exception e) {
			logger.error("wxMenuService.wxMenuInfoPage", e);
		}
		return WX_MENU_INFO_PAGE;
	}

	/**
	 * 跳转到修改微信菜单界面
	 * 
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "modifyWxMenuPage.do", method = RequestMethod.GET)
	public String modifyWxMenuPage(HttpServletRequest request, String id) {
		try {
			WxMenuInfo wxMenuInfo = wxMenuService.getWxMenuInfoById(id);
			request.setAttribute("wxMenuInfo", wxMenuInfo);
		} catch (Exception e) {
			logger.error("wxMenuService.modifyWxMenuPage", e);
		}
		return MODIFY_WX_MENU__PAGE;
	}

	/**
	 * 删除微信菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "deleteWxMenu.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> deleteWxMenu(String id) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			wxMenuService.deleteWxMenu(id);
		} catch (Exception e) {
			logger.error("WxMenuController.deleteWxMenu", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}

	/**
	 * 新增微信菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "insertWxMenu.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> insertWxMenu(WxMenuInfo wxMenuInfo) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			boolean flag = wxMenuService.insertWxMenu(wxMenuInfo);
			if(!flag){
				br.setErrorCode(ErrorCode.menu_exceed_num.getCode());
				br.setContent(ErrorCode.menu_exceed_num.getDes());
			}
		} catch (Exception e) {
			logger.error("WxMenuController.insertWxMenu", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}
	
	/**
	 * 修改微信菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "updateWxMenu.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> updateWxMenu(WxMenuInfo wxMenuInfo) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			wxMenuService.updateWxMenu(wxMenuInfo);
		} catch (Exception e) {
			logger.error("WxMenuController.updateWxMenu", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}
	
	/**
	 * 同步微信菜单
	 * 
	 * @return
	 */
	@RequestMapping(value = "syncWxMenu.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> syncWxMenu() {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxMenuService.syncWxMenu();
		} catch (Exception e) {
			logger.error("WxMenuController.syncWxMenu", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}
}
