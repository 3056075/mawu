package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.UiAddResponse;

public class UiAddRequest extends BaseRequest<UiAddResponse> {
	public static final String CODE = "F6030";
	@Override
	public String faceCode() {		
		return CODE;
	}
	private String productName;//产品名称
	private Integer uiCategoryId;//分类id
	private String pageName;//页面名称
	private String keywords;//关键词
	private Integer system;//系统id
	private String base64Img;//图片base64
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getUiCategoryId() {
		return uiCategoryId;
	}
	public void setUiCategoryId(Integer uiCategoryId) {
		this.uiCategoryId = uiCategoryId;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public Integer getSystem() {
		return system;
	}
	public void setSystem(Integer system) {
		this.system = system;
	}
	public String getBase64Img() {
		return base64Img;
	}
	public void setBase64Img(String base64Img) {
		this.base64Img = base64Img;
	}
	
	
	
}
