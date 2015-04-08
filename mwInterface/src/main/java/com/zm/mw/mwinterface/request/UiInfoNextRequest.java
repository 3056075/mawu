package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.UiInfoNextResponse;

public class UiInfoNextRequest extends BaseRequest<UiInfoNextResponse> {
	public static final String CODE = "F5021";
	@Override
	public String faceCode() {
		
		return CODE;
	}
}
