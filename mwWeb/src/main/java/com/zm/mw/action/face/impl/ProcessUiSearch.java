package com.zm.mw.action.face.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.zm.common.action.face.IProcessBase;
import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.mw.mwinterface.request.UiSearchRequest;
import com.zm.mw.mwinterface.response.UiSearchResponse;
@Service(value = UiSearchRequest.CODE)
public class ProcessUiSearch extends IProcessBase {

	@Override
	public BaseResponse useProcess(String data, HttpServletRequest request)
			throws ZmException {
		UiSearchRequest uiSearchRequest = convertData(data, UiSearchRequest.class);
		UiSearchResponse response = new UiSearchResponse();
		return response;
	}

}
