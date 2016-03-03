package com.pet.wx.db.dto;

import com.pet.wx.common.enums.ErrorCode;
import com.pet.wx.common.enums.GlobConstants;



/**
 * 消息体
 * @author wuxj
 *
 * @param <E>
 */
public class BaseResponseDto<E>{

    protected int flag = GlobConstants.REQUEST_RESULT_FLAG_SUCCESSED;//调用结果标志位 0:失败 1:成功
    
    protected String errorCode = ErrorCode.sucessed.getCode();//错误编码
    
    protected int pageCount;//分页数据的总数
    
    protected E content;//返回的内容

    public int getFlag() {
    	if(!ErrorCode.sucessed.getCode().equals(errorCode)){
    		flag = 0;
    	}
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public E getContent() {
        return content;
    }

    public void setContent(E content) {
        this.content = content;
    }

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}
