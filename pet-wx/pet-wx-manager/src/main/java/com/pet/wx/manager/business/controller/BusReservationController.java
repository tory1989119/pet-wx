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
import com.pet.wx.manager.business.service.BusReservationService;

@Controller
@RequestMapping("/bus/reservation")
public class BusReservationController {
	@Autowired
	BusReservationService busReservationService;

	private Logger logger = LoggerFactory.getLogger(BusReservationController.class);

	private final String WX_GROUP_MANA_PAGE = "bus/reservation/busReservationMana"; // 微信用户组管理界面

	/**
	 * 跳转到微信用户预约界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "busReservationManaPage.do", method = RequestMethod.GET)
	public String busReservationManaPage() {
		return WX_GROUP_MANA_PAGE;
	}

	/**
	 * 查询微信用户预约列表
	 * 
	 * @param searchDto
	 * @return
	 */
	@RequestMapping(value = "queryBusReservation.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> queryBusReservation(SysSearchDto searchDto) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			return busReservationService.queryBusReservation(searchDto);
		} catch (Exception e) {
			logger.error("BusReservationController.queryBusReservation", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}
}
