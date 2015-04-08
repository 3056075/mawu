package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.UiAddResponse;

public class UiAddRequest extends BaseRequest<UiAddResponse> {
	public static final String CODE = "F6030";
	@Override
	public String faceCode() {		
		return CODE;
	}
}
