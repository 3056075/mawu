package com.zm.mw.action.face.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.zm.common.action.face.IProcessBase;
import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.mw.mwinterface.request.UiSystemRequest;
import com.zm.mw.mwinterface.response.UiSystemResponse;
@Service(value = UiSystemRequest.CODE)
public class ProcessUiSystem extends IProcessBase {

	@Override
	public BaseResponse useProcess(String data, HttpServletRequest request)
			throws ZmException {
		UiSystemRequest uiSystemRequest = convertData(data, UiSystemRequest.class);
		UiSystemResponse response = new UiSystemResponse();
		return response;
	}

}
