package com.pet.wx.common.enums;
/**
 * 消息类型枚举
 * @author wuxj
 *
 */
public enum MsgTypeEnum {
	TEXT("text"),
	IMAGE("image"),
	VOICE("voice"),
	VIDEO("video"),
	LOCATION("location"),
	LINK("link"),
	EVENT("event"),
	SHORTVIDEO("shortvideo");
	
	private String type;
	
	private MsgTypeEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
