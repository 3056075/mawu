package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.LoginResponse;

public class LoginRequest extends BaseRequest<LoginResponse> {
	public static final String CODE = "F_6001";
	@Override
	public String faceCode() {		
		return CODE;
	}
	
	private String code;//微信是code，qq是access_token
	private Short type;//1=微信，5=qq
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Short getType() {
		return type;
	}
	public void setType(Short type) {
		this.type = type;
	}
	
	
}
