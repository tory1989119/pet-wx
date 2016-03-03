package com.pet.wx.db.inf;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.pet.wx.common.enums.WxConsts;
import com.pet.wx.common.http.HttpClientUtils;
import com.pet.wx.common.utils.GsonUtils;
import com.pet.wx.common.utils.MD5Utils;
import com.pet.wx.db.dto.AccessTokenDto;
import com.pet.wx.db.dto.WxMenuDto;
import com.pet.wx.db.model.WxKfInfo;

@Component
public class WxClient {
	
	/**
	 * 获取token
	 * @param grant_type
	 * @param appid
	 * @param secret
	 * @return
	 */
	public JsonObject tokenQuery(String grant_type,String appid,String secret){
		String url = String.format( WxConsts.TOKEN_QUERY_URL, grant_type, appid, secret);
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.get(url,"UTF-8"), JsonObject.class,true);
		return jo;
	}
	
	/**
	 * 网页授权
	 * @param grant_type
	 * @param appid
	 * @param secret
	 * @param code
	 * @return
	 */
	public JsonObject authorize(String grant_type,String appid,String secret,String code){
		String url = String.format( WxConsts.WY_TOKEN_QUERY_URL, appid,secret,code,grant_type);
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.get(url,"UTF-8"), JsonObject.class,true);
		return jo;
	}
	/**
	 * 获取用户基本信息
	 * @param openid
	 * @return
	 */
	public JsonObject userInfo(String openid){
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.USER_INFO_URL, access_token,openid,"zh_CN");
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.get(url,"UTF-8"), JsonObject.class,true);
		return jo;
	}
	
	/**
	 * 新增分组
	 * @param name
	 * @return
	 */
	public JsonObject groupCreate(String name){
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.GROUP_CREATE_URL, access_token);
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.post(url, "{\"group\":{\"name\":\"" + name + "\"}}", "UTF-8"), JsonObject.class,true);
		return jo;
	}
	
	/**
	 * 查询分组
	 * @return
	 */
	public JsonObject groupQuery(){
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.GROUP_QUERY_URL, access_token);
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.get(url,"UTF-8"), JsonObject.class,true);
		return jo;
	}
	
	/**
	 * 删除分组
	 * @param groupId
	 * @return
	 */
	public JsonObject groupDelete(Long groupId){
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.GROUP_DELETE_URL, access_token);
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.post(url, "{\"group\":{\"id\":" + groupId + "}}", "UTF-8"), JsonObject.class,true);
		return jo;
	}
	
	/**
	 * 更新分组
	 * @param groupId
	 * @param name
	 * @return
	 */
	public JsonObject groupUpdate(Long groupId,String name){
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.GROUP_UPDATE_URL, access_token);
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.post(url, "{\"group\":{\"id\":" + groupId + ",\"name\":\"" + name + "\"}}", "UTF-8"), JsonObject.class,true);
		return jo;
	}
	
	/**
	 * 新增客服
	 * @param wxKf
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public JsonObject kfCreate(WxKfInfo wxKf) throws UnsupportedEncodingException{
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.KF_CREATE_URL, access_token);
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.post(url, "{\"kf_account\" : \"" + wxKf.getKfAccount() + "\",\"nickname\" : \"" + wxKf.getNickname() + "\",\"password\" : \"" + MD5Utils.getMD5String(wxKf.getPassword()) + "\"}", "UTF-8"), JsonObject.class,true);
		return jo;
	}
	
	/**
	 * 查询客服
	 * @return
	 */
	public JsonObject kfQuery(){
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.KF_QUERY_URL, access_token);
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.get(url,"UTF-8"), JsonObject.class,true);
		return jo;
	}
	
	/**
	 * 删除客服
	 * @return
	 */
	public JsonObject kfDelete(String kfAccount){
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.KF_DELETE_URL, access_token,kfAccount);
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.get(url, "UTF-8"), JsonObject.class,true);
		return jo;
	}
	
	/**
	 * 更新客服
	 * @param wxKf
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public JsonObject kfUpdate(WxKfInfo wxKf) throws UnsupportedEncodingException{
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.KF_UPDATE_URL, access_token);
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.post(url, "{\"kf_account\" : \"" + wxKf.getKfAccount() + "\",\"nickname\" : \"" + wxKf.getNickname() + "\",\"password\" : \"" + MD5Utils.getMD5String(wxKf.getPassword()) + "\"}", "UTF-8"), JsonObject.class,true);
		return jo;
	}
	
	/**
	 * 删除菜单
	 * @return
	 */
	public JsonObject menuDelete(){
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.MENU_DELETE_URL, access_token);
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.get(url,"UTF-8"), JsonObject.class,true);
		return jo;
	}
	
	/**
	 * 创建菜单
	 * @param menuList
	 * @return
	 */
	public JsonObject menuCreate(List<WxMenuDto> menuList){
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.MENU_CREATE_URL, access_token);
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.post(url, "{\"button\": " + GsonUtils.toJson(menuList, menuList.getClass(),false) + "}","UTF-8"), JsonObject.class,true);
		return jo;
	}
	
	/**
	 * 查询素材
	 * @param begin
	 * @return
	 */
	public JsonObject metarialQuery(Integer begin){
		String url = String.format(WxConsts.METARIAL_QUERY_URL, AccessTokenDto.getAccess_token());
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.post(url,"{\"type\":\"news\",\"offset\":" + begin + ",\"count\":20}", "UTF-8"), JsonObject.class,true);
		return jo;
	}
	
	/**
	 * 获取用户列表
	 * @param next_openid
	 * @return
	 */
	public JsonObject userQueryAll(String next_openid){
		String access_token = AccessTokenDto.getAccess_token();
		String url = String.format( WxConsts.USER_QUERY_ALL_URL, access_token, next_openid);
		JsonObject jo = GsonUtils.fromJson(HttpClientUtils.get(url,"UTF-8"), JsonObject.class,true);
		return jo;
	}
}
