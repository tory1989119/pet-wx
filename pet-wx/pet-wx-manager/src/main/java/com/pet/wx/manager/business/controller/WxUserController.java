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
import com.pet.wx.db.dto.SysSearchDto;
import com.pet.wx.db.model.WxUserInfo;
import com.pet.wx.manager.business.service.WxUserService;

@Controller
@RequestMapping("/bus/user")
public class WxUserController {
	@Autowired
	WxUserService wxUserService;
	
	private Logger logger = LoggerFactory.getLogger(WxUserController.class);

	private final String WX_USER_MANA_PAGE = "bus/user/wxUserMana"; // 微信用户管理界面
	private final String WX_USER_INFO_PAGE = "bus/user/wxUserInfo"; // 微信用户详情

	/**
	 * 跳转到微信用户管理界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "wxUserManaPage.do", method = RequestMethod.GET)
	public String wxUserManaPage() {
		return WX_USER_MANA_PAGE;
	}

	/**
	 * 查询微信用户列表
	 * 
	 * @param searchDto
	 * @return
	 */
	@RequestMapping(value = "queryWxUser.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> queryWxUser(SysSearchDto searchDto) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxUserService.queryWxUser(searchDto);
		} catch (Exception e) {
			logger.error("WxUserManagerController.queryWxUser", e);
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
	@RequestMapping(value = "wxUserInfoPage.do", method = RequestMethod.GET)
	public String wxUserInfoPage(HttpServletRequest request, String id) {
		try {
			WxUserInfo wxUserInfo = wxUserService.getWxUserById(id);
			request.setAttribute("wxUserInfo", wxUserInfo);
		} catch (Exception e) {
			logger.error("WxUserManagerController.wxUserInfoPage", e);
		}
		return WX_USER_INFO_PAGE;
	}
	
	/**
	 * 同步微信用户
	 * 
	 * @return
	 */
	@RequestMapping(value = "syncWxUser.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> syncWxUser() {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxUserService.syncWxUser();
		} catch (Exception e) {
			logger.error("WxUserManagerController.syncWxUser", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}
}
