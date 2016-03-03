package com.pet.wx.common.enums;

public interface WxConsts {

	/** 获取token的URL路径 */
	public static final String TOKEN_QUERY_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=%s&appid=%s&secret=%s";
	
	/** 获取网页token的URL路径 */
	public static final String WY_TOKEN_QUERY_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=%s";

	/** 用户管理-分组管理-新增分组 */
	public static final String GROUP_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=%s";
	
	/** 用户管理-分组管理-删除分组 */
	public static final String GROUP_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=%s";
	
	/** 用户管理-分组管理-更新分组 */
	public static final String GROUP_UPDATE_URL = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=%s";

	/** 用户管理-分组管理-查询分组 */
	public static final String GROUP_QUERY_URL = "https://api.weixin.qq.com/cgi-bin/groups/get?access_token=%s";

	/** 用户管理-分组管理-查询用户所在分组 */
	public static final String GROUP_QUERY_USER_URL = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=%s";

	/** 用户管理-设置用户备注名 */
	public static final String USER_UPDATE_REMARK_URL = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=%s";

	/** 用户管理-获取用户基本信息 */
	public static final String USER_INFO_URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=%s";

	/** 用户管理-批量获取用户信息 */
	public static final String USER_QUERY_URL = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=%s";

	/** 用户管理-获取用户列表 */
	public static final String USER_QUERY_ALL_URL = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=%s&next_openid=%s";

	/** 菜单管理 - 查询菜单 */
	public static final String MENU_QUERY_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=%s";

	/** 菜单管理 - 创建菜单 */
	public static final String MENU_CREATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
	
	/** 菜单管理 - 删除菜单 */
	public static final String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=%s";
	
	/** 素材管理 - 查询素材 */
	public static final String METARIAL_QUERY_URL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=%s";
	
	/** 客服管理 - 查询客服 */
	public static final String KF_QUERY_URL = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=%s";
	
	/** 客服管理 - 新增客服 */
	public static final String KF_CREATE_URL = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=%s";
	
	/** 客服管理 - 更新客服 */
	public static final String KF_UPDATE_URL = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=%s";
	
	/** 客服管理 - 删除客服 */
	public static final String KF_DELETE_URL = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=%s&kf_account=%s";

	/** 不弹出授权页面，直接跳转，只能获取用户openid */
	public static final String OAUTH2_SCOPE_BASE = "snsapi_base";
	/** 弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息 */
	public static final String OAUTH2_SCOPE_USER_INFO = "snsapi_userinfo";
	
	/** 配置多客服情况下返回类型 */
	public static final String DKF_TYPE= "transfer_customer_service";
	
	/** 获取access_token填写client_credential*/
	public static final String TOKEN_GRANT_TYPE = "client_credential";
	/** 获取access_token填写client_credential*/
	public static final String WY_GRANT_TYPE = "authorization_code";

}
