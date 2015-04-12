package com.zm.mw.action.face.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.mw.dao.FavoriteDao;
import com.zm.mw.dao.UiDao;
import com.zm.mw.entity.Favorite;
import com.zm.mw.entity.Ui;
import com.zm.mw.mwinterface.request.UiInfoRequest;
import com.zm.mw.mwinterface.response.UiInfoResponse;
import com.zm.user.entity.User;

@Service(value = UiInfoRequest.CODE)
public class ProcessUiInfo extends BaseProcess {
	@Autowired
	private UiDao uiDao;
	@Autowired
	private FavoriteDao favoriteDao;

	@Override
	public BaseResponse useProcess(String data, HttpServletRequest request)
			throws ZmException {
		UiInfoRequest uiInfoRequest = convertData(data, UiInfoRequest.class);
		Integer uiId = uiInfoRequest.getUiId();
		if (null == uiId) {
			throw new ZmException(UiInfoResponse.CODE_NULL_UIId);
		}
		Ui ui = uiDao.get(uiId);
		if (null == ui) {
			throw new ZmException(UiInfoResponse.CODE_NULL_UIId);
		}

		UiInfoResponse response = new UiInfoResponse();
		response.setPageName(ui.getPageName());
		response.setProductName(ui.getProductName());
		response.setUiCategoryName(ui.getUiCategory().getName());
		response.setUiId(ui.getUiId());
		response.setImgUrl(ui.getImgUrl());
		response.setFavorited(Boolean.FALSE);
		User user = null;
		try {
			user = getCurrentUser();
		} catch (Exception e) {
		}
		if (user != null) {
			List<Favorite> favs = favoriteDao.findByUserIdUiId(
					user.getUserId(), uiId);
			if (null != favs && !favs.isEmpty()) {
				response.setFavorited(Boolean.TRUE);
			}
		}
		return response;
	}

}
