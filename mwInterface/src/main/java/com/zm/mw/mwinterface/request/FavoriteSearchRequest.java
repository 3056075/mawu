package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.FavoriteSearchResponse;

public class FavoriteSearchRequest extends BaseRequest<FavoriteSearchResponse> {
	public static final String CODE = "F6020";
	@Override
	public String faceCode() {
		
		return CODE;
	}
}
