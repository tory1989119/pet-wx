package com.pet.wx.db.dto;

/**
 * 公用查询对象
 * 
 * @author wuxj
 *
 */
public class SysSearchDto {
	/**
	 * 开始日期
	 */
	private String startDate;
	/**
	 * 结束日期
	 */
	private String endDate;
	/**
	 * 姓名
	 */
	private String nickName;
	/**
	 * 手机号码
	 */
	private String phoneNumber;
	/**
	 * 用户的标识，对当前公众号唯一
	 */
	private String openid;
	/**
	 * 页数
	 */
	private Integer begin;
	/**
	 * 每页记录数
	 */
	private Integer rows;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

}
