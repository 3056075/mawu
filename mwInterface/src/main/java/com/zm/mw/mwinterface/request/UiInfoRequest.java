package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.UiInfoResponse;

public class UiInfoRequest extends BaseRequest<UiInfoResponse> {
	public static final String CODE = "F5020";
	@Override
	public String faceCode() {
		
		return CODE;
	}
}
