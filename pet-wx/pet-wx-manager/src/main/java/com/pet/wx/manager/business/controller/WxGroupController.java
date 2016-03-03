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
import com.pet.wx.db.model.WxGroupInfo;
import com.pet.wx.manager.business.service.WxGroupService;

@Controller
@RequestMapping("/bus/group")
public class WxGroupController {
	@Autowired
	WxGroupService wxGroupService;

	private Logger logger = LoggerFactory.getLogger(WxGroupController.class);

	private final String WX_GROUP_MANA_PAGE = "bus/group/wxGroupMana"; // 微信用户组管理界面
	private final String ADD_WX_GROUP_PAGE = "bus/group/addWxGroup"; // 增加微信用户组
	private final String MODIFY_WX_GROUP_PAGE = "bus/group/modifyWxGroup"; // 修改微信用户组

	/**
	 * 跳转到微信用户组管理界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "wxGroupManaPage.do", method = RequestMethod.GET)
	public String wxGroupManaPage() {
		return WX_GROUP_MANA_PAGE;
	}

	/**
	 * 跳转到增加微信用户分组
	 * 
	 * @return
	 */
	@RequestMapping(value = "addWxGroupPage.do", method = RequestMethod.GET)
	public String addWxGroupPage() {
		return ADD_WX_GROUP_PAGE;
	}
	
	/**
	 * 跳转到修改微信用户分组
	 * 
	 * @return
	 */
	@RequestMapping(value = "modifyWxGroupPage.do", method = RequestMethod.GET)
	public String modifyWxGroupPage(HttpServletRequest request, String id) {
		try{
			WxGroupInfo wxGroupInfo = wxGroupService.getWxGroupInfo(id);
			request.setAttribute("wxGroupInfo", wxGroupInfo);
		} catch (Exception e) {
			logger.error("WxGroupController.modifyWxGroupPage", e);
		}
		return MODIFY_WX_GROUP_PAGE;
	}

	/**
	 * 查询微信用户分组列表
	 * 
	 * @param searchDto
	 * @return
	 */
	@RequestMapping(value = "queryWxGroup.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> queryWxGroup(SysSearchDto searchDto) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxGroupService.queryWxGroup(searchDto);
		} catch (Exception e) {
			logger.error("WxGroupController.queryWxGroup", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}

	/**
	 * 同步微信用户分组
	 * 
	 * @return
	 */
	@RequestMapping(value = "syncWxGroup.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> syncWxGroup() {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxGroupService.syncWxGroup();
		} catch (Exception e) {
			logger.error("WxGroupController.syncWxGroup", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}

	/**
	 * 新增微信用户分组
	 * 
	 * @return
	 */
	@RequestMapping(value = "insertWxGroup.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> insertWxGroup(WxGroupInfo wxGroupInfo) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxGroupService.insertWxGroup(wxGroupInfo);
		} catch (Exception e) {
			logger.error("WxGroupController.insertWxGroup", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}

	/**
	 * 删除微信用户分组
	 * 
	 * @return
	 */
	@RequestMapping(value = "deleteWxGroup.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> deleteWxGroup(WxGroupInfo wxGroupInfo) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxGroupService.deleteWxGroup(wxGroupInfo);
		} catch (Exception e) {
			logger.error("WxGroupController.deleteWxGroup", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}
	
	/**
	 * 更新微信用户分组
	 * 
	 * @return
	 */
	@RequestMapping(value = "updateWxGroup.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> updateWxGroup(WxGroupInfo wxGroupInfo) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxGroupService.updateWxGroup(wxGroupInfo);
		} catch (Exception e) {
			logger.error("WxGroupController.updateWxGroup", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}
}
