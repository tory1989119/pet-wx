package com.pet.wx.db.dto;

public class WxErrorDto {
	/**
	 * 响应错误代码
	 */
	private Integer errcode;

	/**
	 * 响应错误信息
	 */
	private String errmsg;

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
}
