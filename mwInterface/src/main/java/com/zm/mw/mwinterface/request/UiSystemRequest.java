package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.UiSystemResponse;

public class UiSystemRequest extends BaseRequest<UiSystemResponse> {
	public static final String CODE = "F5002";

	@Override
	public String faceCode() {		
		return CODE;
	}
	
}
