package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.FavoriteAddResponse;

public class FavoriteAddRequest extends BaseRequest<FavoriteAddResponse> {
	public static final String CODE = "F6021";
	@Override
	public String faceCode() {	
		return CODE;
	}
}
