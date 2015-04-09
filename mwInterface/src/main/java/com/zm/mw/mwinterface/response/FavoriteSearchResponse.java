package com.zm.mw.mwinterface.response;

import java.util.List;

import com.zm.common.face.BaseResponse;

public class FavoriteSearchResponse extends BaseResponse {
	private List<IUi> uis;// 收藏的搜索结果

	public List<IUi> getUis() {
		return uis;
	}

	public void setUis(List<IUi> uis) {
		this.uis = uis;
	}

	public static class IUi {
		private Integer uiId;// ui的系统id，用于显示详情或者收藏的时候使用
		private String productName;// 产品名称，第一个名称
		private String imgUrl;// 产品图片地址
		private Boolean favorited;// 都为true

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
