package com.zm.mw.mwinterface.response;

import java.util.List;

import com.zm.common.face.BaseResponse;

public class UiCategoryResponse extends BaseResponse {
	private List<IUiCategory> uiCategorys; 
	
	public List<IUiCategory> getUiCategorys() {
		return uiCategorys;
	}

	public void setUiCategorys(List<IUiCategory> uiCategorys) {
		this.uiCategorys = uiCategorys;
	}

	public static class IUiCategory {
		private Integer uiCategoryId;
		private String name;

		public Integer getUiCategoryId() {
			return uiCategoryId;
		}

		public void setUiCategoryId(Integer uiCategoryId) {
			this.uiCategoryId = uiCategoryId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

}
