package com.pet.wx.db.model;

public class BusReservationInfo {
	
	private Long id;
	/**
	 * 微信openid
	 */
	private String openid;
	/**
	 * 手机号码
	 */
	private String phoneNumber;
	/**
	 * 预约时间
	 */
	private String reservationTime;
	/**
	 * 病症
	 */
	private String disease;
	/**
	 * 创建时间
	 */
	private String createTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getReservationTime() {
		return reservationTime;
	}
	public void setReservationTime(String reservationTime) {
		this.reservationTime = reservationTime;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
