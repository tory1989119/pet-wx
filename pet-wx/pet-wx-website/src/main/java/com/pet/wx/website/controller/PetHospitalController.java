package com.pet.wx.website.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.pet.wx.common.enums.ErrorCode;
import com.pet.wx.db.dto.BaseResponseDto;
import com.pet.wx.db.model.BusReservationInfo;
import com.pet.wx.db.model.WxMetarialInfo;
import com.pet.wx.db.model.WxUserInfo;
import com.pet.wx.website.service.PetHospitalService;

@Controller
@RequestMapping("/hospital")
public class PetHospitalController {
	@Autowired
	private PetHospitalService petHospitalService;
	
	private Logger logger = LoggerFactory.getLogger(PetHospitalController.class);

	private final String MAIN_PAGE = "main"; //医院首页
	private final String INTRODUCE_PAGE = "introduce"; //医院介绍
	private final String DEPARTMENT_PAGE = "department"; //特色科室
	private final String FACILITY_PAGE = "facility"; //设备设施
	private final String SCHOOL_PAGE = "school"; //宠物学堂
	private final String TEAM_PAGE = "team"; //医疗团队
	private final String CONTACT_PAGE = "contact"; //联系我们
	private final String RESERVATION_PAGE = "reservation"; //预约
	private final String SUBSCRIBE_PAGE = "subscribe"; //关注
	
	/**
	 * 跳转到医院首页
	 * 
	 * @return
	 */
	@RequestMapping(value = "mainPage.do", method = RequestMethod.GET)
	public String mainPage(){
		return MAIN_PAGE;
	}
	
	/**
	 * 跳转到医院介绍
	 * 
	 * @return
	 */
	@RequestMapping(value = "introducePage.do", method = RequestMethod.GET)
	public String introducePage(){
		return INTRODUCE_PAGE;
	}
	
	/**
	 * 跳转到特色科室
	 * 
	 * @return
	 */
	@RequestMapping(value = "departmentPage.do", method = RequestMethod.GET)
	public String departmentPage(){
		return DEPARTMENT_PAGE;
	}
	
	/**
	 * 跳转到设备设施
	 * 
	 * @return
	 */
	@RequestMapping(value = "facilityPage.do", method = RequestMethod.GET)
	public String facilityPage(){
		return FACILITY_PAGE;
	}
	
	/**
	 * 跳转到宠物学堂
	 * 
	 * @return
	 */
	@RequestMapping(value = "schoolPage.do", method = RequestMethod.GET)
	public String schoolPage(HttpServletRequest request){
		try {
			List<WxMetarialInfo> list = petHospitalService.queryWxMetarialForSchool(5);
			request.setAttribute("list", list);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return SCHOOL_PAGE;
	}
	
	/**
	 * 跳转到医疗团队
	 * 
	 * @return
	 */
	@RequestMapping(value = "teamPage.do", method = RequestMethod.GET)
	public String teamPage(){
		return TEAM_PAGE;
	}
	
	/**
	 * 跳转到联系我们
	 * 
	 * @return
	 */
	@RequestMapping(value = "contactPage.do", method = RequestMethod.GET)
	public String contactPage(){
		return CONTACT_PAGE;
	}
	
	/**
	 * 跳转到预约
	 * 
	 * @return
	 */
	@RequestMapping(value = "reservationPage.do", method = RequestMethod.GET)
	public String reservationPage(HttpServletRequest request,String code){
		try {
			if(code == null || code.equals("")){
				return SUBSCRIBE_PAGE;
			}else{
				JsonObject jo = petHospitalService.authorize(code);
				String openid = jo.get("openid").getAsString();
				if(openid != null && !openid.equals("")){
					request.setAttribute("openid", openid);
					WxUserInfo wxUser = petHospitalService.getWxUserByOpenid(openid);
					if(wxUser != null && wxUser.getSubscribe().equals("0")){
						return SUBSCRIBE_PAGE;
					}
				}
			}
		} catch (Exception e) {
			logger.error("PetHospitalController.reservationPage", e);
			return SUBSCRIBE_PAGE;
		}
		
		return RESERVATION_PAGE;
	}
	
	/**
	 * 新增预约
	 * 
	 * @return
	 */
	@RequestMapping(value = "insertReservation.do", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public BaseResponseDto<Object> insertReservation(BusReservationInfo busReservation) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		try {
			petHospitalService.insertBusReservation(busReservation);
		} catch (Exception e) {
			logger.error("PetHospitalController.insertReservation", e);
			br.setErrorCode(ErrorCode.sys_error.getCode());
			br.setContent(ErrorCode.sys_error.getDes());
		}
		return br;
	}
}
