package com.zm.mw.action.face.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.zm.common.action.face.IProcessBase;
import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.mw.mwinterface.request.FavoriteSearchRequest;
import com.zm.mw.mwinterface.response.FavoriteSearchResponse;
@Service(value = FavoriteSearchRequest.CODE)
public class ProcessFavoriteSearch extends IProcessBase {

	@Override
	public BaseResponse useProcess(String data, HttpServletRequest request)
			throws ZmException {
		FavoriteSearchRequest favoriteSearchRequest = convertData(data, FavoriteSearchRequest.class);
		FavoriteSearchResponse response = new FavoriteSearchResponse();
		return response;
	}

}
