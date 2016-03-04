package com.pet.wx.db.model;

public class WxMetarialInfo {
	private Long id;
	/**
	 * 图文素材id
	 */
	private String mediaId;
	/**
	 * 图文消息的标题
	 */
	private String title;
	/**
	 * 图文消息的封面图片素材id（必须是永久mediaID）
	 */
	private String thumbMediaId;
	/**
	 * 图文消息的封面图片的地址
	 */
	private String thumbUrl;
	/**
	 * 是否显示封面，0为false，即不显示，1为true，即显示
	 */
	private String showCoverPic;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 图文消息的摘要
	 */
	private String digest;
	/**
	 * 
	 */
	private String content;
	/**
	 * 图文页的URL
	 */
	private String url;
	/**
	 * 图文消息的原文地址
	 */
	private String contentSourceUrl;
	/**
	 * 这篇图文消息素材的最后更新时间
	 */
	private String updateTime;
	/**
	 * 文件名称
	 */
	private String name;
	/**
	 * 类型
	 */
	private String type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbMediaId() {
		return thumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}
	public String getThumbUrl() {
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
	public String getShowCoverPic() {
		return showCoverPic;
	}
	public void setShowCoverPic(String showCoverPic) {
		this.showCoverPic = showCoverPic;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDigest() {
		return digest;
	}
	public void setDigest(String digest) {
		this.digest = digest;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContentSourceUrl() {
		return contentSourceUrl;
	}
	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
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
}
