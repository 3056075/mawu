package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.FavoriteSearchResponse;

public class FavoriteSearchRequest extends BaseRequest<FavoriteSearchResponse> {
	public static final String CODE = "F_6020";
	@Override
	public String faceCode() {		
		return CODE;
	}
	private Integer pageNum;//第几页，从第0页开始，不传则默认为0页
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
	
}
