package com.zm.mw.action.face.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.zm.common.action.face.IProcessBase;
import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.mw.mwinterface.request.UiInfoRequest;
import com.zm.mw.mwinterface.response.UiInfoResponse;
@Service(value = UiInfoRequest.CODE)
public class ProcessUiInfo extends IProcessBase {

	@Override
	public BaseResponse process(String data, HttpServletRequest request)
			throws ZmException {
		UiInfoRequest uiInfoRequest = convertData(data, UiInfoRequest.class);
		UiInfoResponse response = new UiInfoResponse();
		return response;
	}

}
