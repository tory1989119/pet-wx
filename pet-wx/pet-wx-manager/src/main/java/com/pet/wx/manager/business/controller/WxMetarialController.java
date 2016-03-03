package com.pet.wx.manager.business.controller;

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
import com.pet.wx.manager.business.service.WxMetarialService;

@Controller
@RequestMapping("/bus/metarial")
public class WxMetarialController {
	@Autowired
	WxMetarialService wxMetarialService;

	private Logger logger = LoggerFactory.getLogger(WxMetarialController.class);

	private final String WX_METARIAL_MANA_PAGE = "bus/metarial/wxMetarialMana"; // 素材管理界面

	/**
	 * 跳转到素材管理界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "wxMetarialManaPage.do", method = RequestMethod.GET)
	public String wxMetarialManaPage() {
		return WX_METARIAL_MANA_PAGE;
	}

	

	/**
	 * 查询素材列表
	 * @param searchDto
	 * @return
	 */
	@RequestMapping(value = "queryWxMetarial.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> queryWxMetarial(SysSearchDto searchDto) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxMetarialService.queryWxMetarial(searchDto);
		} catch (Exception e) {
			logger.error("WxMetarialController.queryWxMetarial", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}
	
	/**
	 * 同步素材
	 * 
	 * @return
	 */
	@RequestMapping(value = "syncWxMetarial.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> syncWxMetarial() {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return wxMetarialService.syncWxMetarial();
		} catch (Exception e) {
			logger.error("WxMetarialController.syncWxMetarial", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}
}
