package com.pet.wx.db.dto;

/**
 * 微信消息响应对象
 * @author wuxj
 *
 */
public class WxMessageDto{
	
	/** 开发者微信号 */
	private String ToUserName;
	/** 发送方帐号（一个OpenID） */
	private String FromUserName;
	/** 消息创建时间(整形) */
	private Long CreateTime;
	/**消息类型 */
	private String MsgType;
	/** 消息id, 消息排重 */
	private Long MsgId;
	/** 文本消息内容 */
	private String Content;
	/** 图片链接 */
	private String PicUrl;
	/** 消息媒体id，可以调用多媒体文件下载接口拉取数据 */
	private String MediaId;
	/** 语音格式，如amr，speex等 */
	private String Format;
	/** 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据 */
	private String ThumbMediaId;
	/** 地理位置维度 */
	private Double Location_X;
	/** 地理位置经度 */
	private Double Location_Y;
	/** 地图缩放大小 */
	private Double Scale;
	/** 地理位置信息 */
	private String Label;
	/** 消息标题 */
	private String Title;
	/** 消息描述 */
	private String Description;
	/** 链接URL */
	private String Url;
	/** 事件类型, 有ENTER(进入会话)和LOCATION(地理位置) */
	private String Event;
	/** 地理位置维度，事件类型为LOCATION的时存在 */
	private Double Latitude;
	/** 地理位置经度，事件类型为LOCATION的时存在 */
	private Double Longitude;
	/** 地理位置精度，事件类型为LOCATION的时存在 */
	private Double Precision;
	/** 事件KEY值 */
	private String EventKey;
	/** 二维码的ticket，可用来换取二维码图片 */
	private String Ticket;
	/** 菜单编号 */
	private String MenuId;
	/** 客服账号 */
	private String KfAccount;
	/** 语音消息附带 */
	private String Recognition;
	public String getToUserName() {
		return ToUserName;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}
	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}
	public Long getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}
	public String getMsgType() {
		return MsgType;
	}
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
	public Long getMsgId() {
		return MsgId;
	}
	public void setMsgId(Long msgId) {
		MsgId = msgId;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	public Double getLocation_X() {
		return Location_X;
	}
	public void setLocation_X(Double location_X) {
		Location_X = location_X;
	}
	public Double getLocation_Y() {
		return Location_Y;
	}
	public void setLocation_Y(Double location_Y) {
		Location_Y = location_Y;
	}
	public Double getScale() {
		return Scale;
	}
	public void setScale(Double scale) {
		Scale = scale;
	}
	public String getLabel() {
		return Label;
	}
	public void setLabel(String label) {
		Label = label;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getUrl() {
		return Url;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	public Double getLatitude() {
		return Latitude;
	}
	public void setLatitude(Double latitude) {
		Latitude = latitude;
	}
	public Double getLongitude() {
		return Longitude;
	}
	public void setLongitude(Double longitude) {
		Longitude = longitude;
	}
	public Double getPrecision() {
		return Precision;
	}
	public void setPrecision(Double precision) {
		Precision = precision;
	}
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	public String getTicket() {
		return Ticket;
	}
	public void setTicket(String ticket) {
		Ticket = ticket;
	}
	public String getMenuId() {
		return MenuId;
	}
	public void setMenuId(String menuId) {
		MenuId = menuId;
	}
	public String getKfAccount() {
		return KfAccount;
	}
	public void setKfAccount(String kfAccount) {
		KfAccount = kfAccount;
	}
	public String getRecognition() {
		return Recognition;
	}
	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
}
