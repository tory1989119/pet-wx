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
import com.pet.wx.db.model.SysUserInfo;
import com.pet.wx.manager.system.service.LoginService;

/**
 * 物流后台管理端登录Controller
 * 所有关于登录登出等操作
 * 
 * @author wuxiaojian
 * @version $Id: LoginController.java, v 0.1 2015年12月18日 上午10:28:20  Exp $
 */
@Controller
@RequestMapping("/")
public class LoginController {
    private Logger       logger               = LoggerFactory.getLogger(LoginController.class);

    private final String LOGIN_PAGE           = "login";
    private final String MAIN_PAGE            = "main";

    @Resource
    private LoginService loginService;

    /**
     * 跳转到登录页面
     * 
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.GET)
    public String login() {
        return LOGIN_PAGE;
    }

    /**
     * 登录操作
     * 
     * @param request
     * @param sysUserInfo
     * @return
     */
    @RequestMapping(value = "doLogin.do", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public BaseResponseDto<Object> doLogin(HttpServletRequest request, SysUserInfo sysUserInfo) {
        BaseResponseDto<Object> br = new BaseResponseDto<Object>();
        try {
            sysUserInfo = loginService.doLogin(sysUserInfo);
            if (sysUserInfo == null) {
                br.setErrorCode(ErrorCode.login_error.getCode());
                br.setContent(ErrorCode.login_error.getDes());
            } else {
                //保存登录信息到session
                request.getSession().setAttribute("sysUserInfo", sysUserInfo);
            }
        } catch (Exception e) {
            logger.error("LoginController.doLogin", e);
            br.setErrorCode(ErrorCode.sys_error.getCode());
            br.setContent(ErrorCode.sys_error.getDes());
        }
        return br;
    }

    /**
     * 登出操作
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "loginOut.do", method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request) {
        //登出 去除登录信息
        request.getSession().removeAttribute("sysUserInfo");
        return LOGIN_PAGE;
    }

    /**
     * 登陆后跳转到首页
     * 
     * @return
     */
    @RequestMapping(value = "main.do", method = RequestMethod.GET)
    public String main(HttpServletRequest request) {
        //拼装菜单列表 首页显示
        String menuStr = loginService.getMenuStr();
        request.setAttribute("menuStr", menuStr);
        request.setAttribute("sysUserInfo", request.getSession().getAttribute("sysUserInfo"));
        return MAIN_PAGE;
    }
}
