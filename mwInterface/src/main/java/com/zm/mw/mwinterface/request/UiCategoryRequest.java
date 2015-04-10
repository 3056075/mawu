package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.UiCategoryResponse;

public class UiCategoryRequest extends BaseRequest<UiCategoryResponse> {
	public static final String CODE = "F_5001";

	@Override
	public String faceCode() {		
		return CODE;
	}

}
