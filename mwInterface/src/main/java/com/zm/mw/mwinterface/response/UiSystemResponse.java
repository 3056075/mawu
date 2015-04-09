package com.zm.mw.mwinterface.response;

import java.util.List;

import com.zm.common.face.BaseResponse;

public class UiSystemResponse extends BaseResponse {
	private List<IUiSystem> uiSystems;

	public List<IUiSystem> getUiSystems() {
		return uiSystems;
	}

	public void setUiSystems(List<IUiSystem> uiSystems) {
		this.uiSystems = uiSystems;
	}

	public static class IUiSystem {
		private Integer uiSystemId;
		private String name;

		public Integer getUiSystemId() {
			return uiSystemId;
		}

		public void setUiSystemId(Integer uiSystemId) {
			this.uiSystemId = uiSystemId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
