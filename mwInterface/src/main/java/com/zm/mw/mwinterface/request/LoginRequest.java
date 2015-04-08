package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.LoginResponse;

public class LoginRequest extends BaseRequest<LoginResponse> {
	public static final String CODE = "F6001";
	@Override
	public String faceCode() {		
		return CODE;
	}
}
