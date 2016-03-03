package com.pet.wx.manager.system.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pet.wx.common.enums.ErrorCode;
import com.pet.wx.db.dto.BaseResponseDto;
import com.pet.wx.db.dto.SysSearchDto;
import com.pet.wx.db.model.SysUserInfo;
import com.pet.wx.manager.system.service.SysManagerService;

/**
 * 物流后台管理员Controller类
 * 关于物流后台管理员操作
 * 
 * @author wuxiaojian
 * @version $Id: SysManagerController.java, v 0.1 2015年12月18日 上午10:26:11  Exp $
 */
@Controller
@RequestMapping("/sys")
public class SysManagerController {
    private Logger            logger     = LoggerFactory.getLogger(SysManagerController.class);

    private final String      SYS_USER_MANA_PAGE = "sys/sysUserMana";						  //管理员管理页面
    private final String      SYS_USER_INFO_PAGE = "sys/sysUserInfo";			  //管理员详情页面
    private final String      ADD_SYS_USER_PAGE = "sys/addSysUser";                //新增管理员页面
    private final String      MODIFY_SYS_USER__PAGE = "sys/modifySysUser";             //修改管理员信息页面
    

    @Resource
    private SysManagerService sysManagerService;

    /**
     * 跳转到管理员管理界面
     * 
     * @return
     */
    @RequestMapping(value = "sysUserManaPage.do", method = RequestMethod.GET)
    public String sysUserManaPage() {
        return SYS_USER_MANA_PAGE;
    }
    
    /**
     * 跳转到新增管理员界面
     * 
     * @return
     */
    @RequestMapping(value = "addSysUserPage.do", method = RequestMethod.GET)
    public String addSysUserPage() {
    	return ADD_SYS_USER_PAGE;
    }

    /**
     * 查询管理员列表
     * 
     * @param searchDto
     * @return
     */
    @RequestMapping(value = "querySysUser.do", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public BaseResponseDto<Object> querySysUser(SysSearchDto searchDto) {
        BaseResponseDto<Object> br = new BaseResponseDto<Object>();
        try {
            return sysManagerService.querySysUser(searchDto);
        } catch (Exception e) {
            logger.error("SysManagerController.querySysUser", e);
            br.setErrorCode(ErrorCode.sys_error.getCode());
            br.setContent(ErrorCode.sys_error.getDes());
        }
        return br;
    }

    /**
     * 跳转管理员详细信息页面
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "sysUserInfoPage.do", method = RequestMethod.GET)
    public String sysUserInfoPage(HttpServletRequest request,String id) {
        try {
            SysUserInfo sysUserInfo = sysManagerService.getSysUserById(id);
            request.setAttribute("sysUserInfo", sysUserInfo);
        } catch (Exception e) {
            logger.error("SysManagerController.sysUserInfoPage", e);
        }
        return SYS_USER_INFO_PAGE;
    }
    
    /**
     * 跳转修改管理员信息页面
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "modifySysUserPage.do", method = RequestMethod.GET)
    public String modifySysUserPage(HttpServletRequest request,String id) {
    	try {
    		SysUserInfo sysUserInfo = sysManagerService.getSysUserById(id);
    		request.setAttribute("sysUserInfo", sysUserInfo);
    	} catch (Exception e) {
    		logger.error("SysManagerController.modifySysUserPage", e);
    	}
    	return MODIFY_SYS_USER__PAGE;
    }

    /**
     * 增加管理员
     * 
     * @param request
     * @param sysUserInfo
     * @return
     */
    @RequestMapping(value = "insertSysUser.do", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public BaseResponseDto<Object> insertSysUser(SysUserInfo sysUserInfo) {
        BaseResponseDto<Object> br = new BaseResponseDto<Object>();
        try {
            sysManagerService.insertSysUser(sysUserInfo);
        } catch (Exception e) {
            logger.error("SysManagerController.insertSysUser", e);
            br.setErrorCode(ErrorCode.sys_error.getCode());
            br.setContent(ErrorCode.sys_error.getDes());
        }
        return br;
    }

    /**
     * 修改管理员
     * 
     * @param request
     * @param sysUserInfo
     * @return
     */
    @RequestMapping(value = "updateSysUser.do", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody BaseResponseDto<Object> updateSysUser(SysUserInfo sysUserInfo) {
        BaseResponseDto<Object> br = new BaseResponseDto<Object>();
        try {
            sysManagerService.updateSysUser(sysUserInfo);
        } catch (Exception e) {
            logger.error("SysManagerController.updateSysUser", e);
            br.setErrorCode(ErrorCode.sys_error.getCode());
            br.setContent(ErrorCode.sys_error.getDes());
        }
        return br;
    }
}
