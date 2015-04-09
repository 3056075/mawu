package com.zm.mw.mwinterface.response;

import com.zm.common.face.BaseResponse;

public class UiInfoResponse extends BaseResponse {
	private Integer uiId;//ui的系统id，用于显示详情或者收藏的时候使用
	private String productName;//产品名称，第一个名称	
	private String pageName;//产品名称，第一个名称
	private String uiCategoryName;//分类名称
	private String imgUrl;//产品图片地址
	private Boolean favorited;//是否已经收藏，如果是未登陆状态，则一直是未收藏，如果是已经登陆状态，则显示是否已经收藏
	
	public Integer getUiId() {
		return uiId;
	}
	public void setUiId(Integer uiId) {
		this.uiId = uiId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getUiCategoryName() {
		return uiCategoryName;
	}
	public void setUiCategoryName(String uiCategoryName) {
		this.uiCategoryName = uiCategoryName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public Boolean getFavorited() {
		return favorited;
	}
	public void setFavorited(Boolean favorited) {
		this.favorited = favorited;
	}
	
}
