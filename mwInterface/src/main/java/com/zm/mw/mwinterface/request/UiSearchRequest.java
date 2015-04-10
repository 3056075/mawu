package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.UiSearchResponse;

public class UiSearchRequest extends BaseRequest<UiSearchResponse> {
	public static final String CODE = "F_5010";

	@Override
	public String faceCode() {
		return CODE;
	}
	private Integer categoryId;//搜索分类的id，
	private String keywords;//搜索关键词,和搜索分类的id只要一个即可，如果两个都有，则报错
	private Integer pageNum;//第几页，从第0页开始，不传则默认为0页

	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
}
