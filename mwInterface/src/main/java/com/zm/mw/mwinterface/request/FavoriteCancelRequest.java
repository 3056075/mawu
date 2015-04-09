package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.FavoriteCancelResponse;

public class FavoriteCancelRequest extends BaseRequest<FavoriteCancelResponse> {
	public static final String CODE = "F6022";
	@Override
	public String faceCode() {
		return CODE;
	}
	private Integer uiId;//取消收藏的ui的系统id
	public Integer getUiId() {
		return uiId;
	}
	public void setUiId(Integer uiId) {
		this.uiId = uiId;
	}
}
