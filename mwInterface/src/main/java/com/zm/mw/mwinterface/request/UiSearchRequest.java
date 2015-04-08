package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.UiSearchResponse;

public class UiSearchRequest extends BaseRequest<UiSearchResponse> {
	public static final String CODE = "F5010 ";

	@Override
	public String faceCode() {
		return CODE;
	}
}
