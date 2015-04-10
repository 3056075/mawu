package com.zm.mw.action.face.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.zm.common.action.face.IProcessBase;
import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.mw.mwinterface.request.FavoriteAddRequest;
import com.zm.mw.mwinterface.response.FavoriteAddResponse;
@Service(value = FavoriteAddRequest.CODE)
public class ProcessFavoriteAdd extends IProcessBase {

	@Override
	public BaseResponse process(String data, HttpServletRequest request)
			throws ZmException {
		FavoriteAddRequest favoriteAddRequest = convertData(data, FavoriteAddRequest.class);
		FavoriteAddResponse response = new FavoriteAddResponse();
		return response;
	}

}
