package com.pet.wx.db.dto;

/**
 * 获取token的响应结果对象
 * 
 * @author wuxj
 *
 */
public class AccessTokenDto{

	/**
	 * 获取到的凭证
	 */
	private static String access_token;

	/**
	 * 凭证有效时间，单位：秒
	 */
	private static Integer expires_in;

	/**
	 * 防止实例化
	 */
	private AccessTokenDto() {
		
	}

	public static String getAccess_token() {
		return access_token;
	}

	public static void setAccess_token(String access_token) {
		AccessTokenDto.access_token = access_token;
	}

	public static Integer getExpires_in() {
		return expires_in;
	}

	public static void setExpires_in(Integer expires_in) {
		AccessTokenDto.expires_in = expires_in;
	}
	
}
