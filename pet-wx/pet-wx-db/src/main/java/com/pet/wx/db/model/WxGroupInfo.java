package com.pet.wx.db.model;

/**
 * 用户分组对象
 * 
 * @author wuxj
 *
 */
public class WxGroupInfo{
	/**
	 * id
	 */
	private Long id;
	/**
	 * 组id
	 */
	private Long groupId;
	/**
	 * 组名称
	 */
	private String name;
	/**
	 * 该组用户数
	 */
	private Integer count;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
