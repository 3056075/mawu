package com.zm.mw.action.face.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.zm.common.action.face.IProcessBase;
import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.mw.mwinterface.request.FavoriteCancelRequest;
import com.zm.mw.mwinterface.response.FavoriteCancelResponse;
@Service(value = FavoriteCancelRequest.CODE)
public class ProcessFavoriteCancel extends IProcessBase {

	@Override
	public BaseResponse process(String data, HttpServletRequest request)
			throws ZmException {
		FavoriteCancelRequest favoriteCancelRequest = convertData(data, FavoriteCancelRequest.class);
		FavoriteCancelResponse response = new FavoriteCancelResponse();
		return response;
	}

}
