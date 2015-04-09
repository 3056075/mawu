package com.zm.mw.mwinterface.response;

import java.util.List;

import com.zm.common.face.BaseResponse;

public class UiSearchResponse extends BaseResponse {
	private Integer categoryId;//分类id，输入的分类id
	private String categoryName;//分类名称,输入的分类id对应的名称
	private String keywords;//搜索关键词,输入的关键词
	private Integer pageNum;//第几页,输入的页数
	private List<IUi> uis;//搜索结果
	
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public List<IUi> getUis() {
		return uis;
	}

	public void setUis(List<IUi> uis) {
		this.uis = uis;
	}

	public static class IUi {
		private Integer uiId;//ui的系统id，用于显示详情或者收藏的时候使用
		private String productName;//产品名称，第一个名称
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
}
