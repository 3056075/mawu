package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.SuggestionResponse;

public class SuggestionRequest extends BaseRequest<SuggestionResponse>{
	public static final String CODE = "F6040";
	@Override
	public String faceCode() {
		
		return CODE;
	}

}
