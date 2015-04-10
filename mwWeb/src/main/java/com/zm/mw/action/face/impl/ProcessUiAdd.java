package com.zm.mw.action.face.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.zm.common.action.face.IProcessBase;
import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.mw.mwinterface.request.UiAddRequest;
import com.zm.mw.mwinterface.response.UiAddResponse;

@Service(value = UiAddRequest.CODE)
public class ProcessUiAdd extends IProcessBase {

	@Override
	public BaseResponse useProcess(String data, HttpServletRequest request)
			throws ZmException {
		UiAddRequest uiAddRequest = convertData(data, UiAddRequest.class);
		UiAddResponse response = new UiAddResponse();
		return response;
	}

}
