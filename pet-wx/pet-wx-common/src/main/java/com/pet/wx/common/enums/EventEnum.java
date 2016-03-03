package com.pet.wx.common.enums;
/**
 * 事件类型枚举
 * @author wuxj
 *
 */
public enum EventEnum {
	SUBSCRIBE("subscribe"),
	UNSUBSCRIBE("unsubscribe"),
	SCAN("SCAN"),
	LOCATION("LOCATION"),
	CLICK("CLICK"),
	VIEW("VIEW");
	
	private String type;
	
	private EventEnum(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
