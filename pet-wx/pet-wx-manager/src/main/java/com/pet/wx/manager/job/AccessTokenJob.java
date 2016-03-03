package com.pet.wx.manager.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import com.google.gson.JsonObject;
import com.pet.wx.common.enums.WxConsts;
import com.pet.wx.common.utils.Configuration;
import com.pet.wx.db.dto.AccessTokenDto;
import com.pet.wx.db.inf.WxClient;
/**
 * 获取access_Token
 * @author Administrator
 *
 */
@Configurable
public class AccessTokenJob {
	
	@Autowired
	private WxClient wxClient;

	private Logger logger = LoggerFactory.getLogger(AccessTokenJob.class);
	
	//轮询过期的订单
	public void execute() {
		String grant_type = WxConsts.TOKEN_GRANT_TYPE;
		String appid = Configuration.getGlobalMsg("appid");
		String secret = Configuration.getGlobalMsg("secret");
		JsonObject jo = wxClient.tokenQuery(grant_type, appid, secret);
		AccessTokenDto.setAccess_token(jo.get("access_token").getAsString());
		AccessTokenDto.setExpires_in(jo.get("expires_in").getAsInt());
		logger.info("access_token = " + jo.get("access_token").getAsString());
	}
}
