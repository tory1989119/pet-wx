package com.pet.wx.manager.business.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pet.wx.common.enums.ErrorCode;
import com.pet.wx.db.dao.WxMetarialDao;
import com.pet.wx.db.dto.BaseResponseDto;
import com.pet.wx.db.dto.SysSearchDto;
import com.pet.wx.db.inf.WxClient;
import com.pet.wx.db.model.WxMetarialInfo;

@Service
public class WxMetarialService {
	@Autowired
	private WxMetarialDao wxMetarialDao;
	@Autowired
	private WxClient wxClient;

	/**
	 * 查询素材列表
	 * 
	 * @param searchDto
	 * @return
	 */
	public BaseResponseDto<Object> queryWxMetarial(SysSearchDto searchDto) {
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		br.setContent(wxMetarialDao.queryWxMetarial(searchDto));
		br.setPageCount(wxMetarialDao.countWxMetarial(searchDto));
		return br;
	}
	
	public BaseResponseDto<Object> syncWxMetarial(){
		wxMetarialDao.truncateWxMetarial();
		BaseResponseDto<Object> br = syncNews();
		if(br.getErrorCode().equals(ErrorCode.sucessed.getCode())){
			br = syncImage();
		}
		return br;
	}
	
	
	/**
	 * 同步图文素材
	 * @return
	 */
	private BaseResponseDto<Object> syncNews(){
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		Integer begin = 0;
		boolean flag = true;
		while (flag) {
			JsonObject jo = wxClient.metarialQuery("news",begin);
			if(jo.get("errcode") == null){
				begin = begin +20;
				Integer item_count = jo.get("item_count").getAsInt();
				if(item_count > 0){
					JsonArray ja = jo.get("item").getAsJsonArray();
					for (int i = 0; i < ja.size(); i++) {
						JsonObject metarialJo = ja.get(i).getAsJsonObject();
						String media_id = metarialJo.get("media_id").getAsString();
						Long update_time = metarialJo.get("update_time").getAsLong();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						String date = sdf.format(new Date(update_time*1000));
						JsonArray metarualJa = metarialJo.get("content").getAsJsonObject().get("news_item").getAsJsonArray();
						for (int j = 0; j < metarualJa.size(); j++) {
							JsonObject mediaJo = metarualJa.get(j).getAsJsonObject();
							WxMetarialInfo wxMetarial = new WxMetarialInfo();
							wxMetarial.setType("news");
							wxMetarial.setMediaId(media_id);
							wxMetarial.setUpdateTime(date);
							wxMetarial.setTitle(mediaJo.get("title").getAsString());
							wxMetarial.setThumbMediaId(mediaJo.get("thumb_media_id").getAsString());
							wxMetarial.setThumbUrl(mediaJo.get("thumb_url").getAsString());
							wxMetarial.setShowCoverPic(mediaJo.get("show_cover_pic").getAsString());
							wxMetarial.setAuthor(mediaJo.get("author").getAsString());
							wxMetarial.setDigest(mediaJo.get("digest").getAsString());
							wxMetarial.setContent(mediaJo.get("content").getAsString());
							wxMetarial.setUrl(mediaJo.get("url").getAsString());
							wxMetarial.setContentSourceUrl(mediaJo.get("content_source_url").getAsString());
							wxMetarialDao.insertWxMetarial(wxMetarial);
						}
					}
				}else{
					flag = false;
				}
			}else{
				br.setErrorCode(ErrorCode.wx_error.getCode());
				br.setContent(jo.get("errcode").getAsString() + "--" + jo.get("errmsg").getAsString());
			}
		}
		return br;
	}
	
	/**
	 * 同步图片素材
	 * @return
	 */
	private BaseResponseDto<Object> syncImage(){
		BaseResponseDto<Object> br = new BaseResponseDto<Object>();
		Integer begin = 0;
		boolean flag = true;
		while (flag) {
			JsonObject jo = wxClient.metarialQuery("image",begin);
			if(jo.get("errcode") == null){
				begin = begin +20;
				Integer item_count = jo.get("item_count").getAsInt();
				if(item_count > 0){
					JsonArray ja = jo.get("item").getAsJsonArray();
					for (int i = 0; i < ja.size(); i++) {
						JsonObject metarialJo = ja.get(i).getAsJsonObject();
						String media_id = metarialJo.get("media_id").getAsString();
						Long update_time = metarialJo.get("update_time").getAsLong();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
						String date = sdf.format(new Date(update_time*1000));
						WxMetarialInfo wxMetarial = new WxMetarialInfo();
						wxMetarial.setMediaId(media_id);
						wxMetarial.setUpdateTime(date);
						wxMetarial.setUrl(metarialJo.get("url").getAsString());
						wxMetarial.setName(metarialJo.get("name").getAsString());
						wxMetarial.setTitle(metarialJo.get("name").getAsString());
						wxMetarial.setType("image");
						wxMetarialDao.insertWxMetarial(wxMetarial);
					}
				}else{
					flag = false;
				}
			}else{
				br.setErrorCode(ErrorCode.wx_error.getCode());
				br.setContent(jo.get("errcode").getAsString() + "--" + jo.get("errmsg").getAsString());
			}
		}
		return br;
	}
}
