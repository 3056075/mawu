package com.zm.mw.action.face.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.zm.common.action.face.IProcessBase;
import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.mw.mwinterface.request.SuggestionRequest;
import com.zm.mw.mwinterface.response.SuggestionResponse;
@Service(value = SuggestionRequest.CODE)
public class ProcessSuggestion extends IProcessBase {

	@Override
	public BaseResponse process(String data, HttpServletRequest request)
			throws ZmException {
		SuggestionRequest suggestionRequest = convertData(data, SuggestionRequest.class);
		SuggestionResponse response = new SuggestionResponse();
		return response;
	}

}
