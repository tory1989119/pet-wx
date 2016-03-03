package com.pet.wx.db.model;

/**
 * 客服对象
 * 
 * @author wuxj
 *
 */
public class WxKfInfo{
	private Long id;
	private String kfId;
	private String kfAccount;
	private String nickname;
	private String password;
	private String kfHeadimgurl;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKfId() {
		return kfId;
	}
	public void setKfId(String kfId) {
		this.kfId = kfId;
	}
	public String getKfAccount() {
		return kfAccount;
	}
	public void setKfAccount(String kfAccount) {
		this.kfAccount = kfAccount;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getKfHeadimgurl() {
		return kfHeadimgurl;
	}
	public void setKfHeadimgurl(String kfHeadimgurl) {
		this.kfHeadimgurl = kfHeadimgurl;
	}
}
