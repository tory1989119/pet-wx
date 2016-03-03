package com.pet.wx.manager.init;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gson.JsonObject;
import com.pet.wx.common.enums.WxConsts;
import com.pet.wx.common.utils.Configuration;
import com.pet.wx.db.dto.AccessTokenDto;
import com.pet.wx.db.inf.WxClient;
  
public class InitServlet extends HttpServlet {  
	private static Logger logger = Logger.getLogger(InitServlet.class);
      
    private static final long serialVersionUID = -7718302829857998640L;
    private static String contextPath;
    private static String classPath;
    
    @Override  
    public void init(ServletConfig config) throws ServletException {  
        super.init(config);
          
        String prefix = config.getServletContext().getRealPath("/");
        InitServlet.contextPath = prefix;
        InitServlet.classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        
        String grant_type = WxConsts.GRANT_TYPE;
		String appid = Configuration.getGlobalMsg("appid");
		String secret = Configuration.getGlobalMsg("secret");
		ServletContext servletContext = this.getServletContext();
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        WxClient wxClient = (WxClient) context.getBean("wxClient");
		JsonObject jo = wxClient.tokenQuery(grant_type, appid, secret);
		AccessTokenDto.setAccess_token(jo.get("access_token").getAsString());
		AccessTokenDto.setExpires_in(jo.get("expires_in").getAsInt());
		logger.info("access_token = " + jo.get("access_token").getAsString());
    }
      
    @Override  
    public void destroy() {  
    }  
      
    public static final String getContextPath() {  
        return InitServlet.contextPath;
    }  
      
    public static final String getClassPath() {  
        return classPath;
    }  
      
}
