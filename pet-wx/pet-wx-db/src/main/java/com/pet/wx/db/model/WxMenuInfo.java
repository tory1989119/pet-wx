package com.pet.wx.db.model;

import java.util.Date;

/**
 * 微信菜单对象
 * 
 * @author wuxj
 *
 */
public class WxMenuInfo {
	/**
	 * id
	 */
	private Long id;
	/**
	 * 菜单标题
	 */
	private String name;
	/**
	 * 菜单类型
	 */
	private String type;
	/**
	 * 菜单KEY值
	 */
	private String menuKey;
	/**
	 * 网页链接
	 */
	private String url;
	/**
	 * 调用新增永久素材接口返回的合法media_id
	 */
	private String mediaId;
	/**
	 * 上级菜单id
	 */
	private Long fid;
	/**
	 * 创建时间
	 */
	private Date createTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMenuKey() {
		return menuKey;
	}
	public void setMenuKey(String menuKey) {
		this.menuKey = menuKey;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public Long getFid() {
		return fid;
	}
	public void setFid(Long fid) {
		this.fid = fid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
