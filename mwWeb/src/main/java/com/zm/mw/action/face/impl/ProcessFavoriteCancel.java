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
import com.zm.mw.mwinterface.request.FavoriteCancelRequest;
import com.zm.mw.mwinterface.response.FavoriteCancelResponse;
import com.zm.user.entity.User;

@Service(value = FavoriteCancelRequest.CODE)
public class ProcessFavoriteCancel extends BaseProcess {
	@Autowired
	private UiDao uiDao;
	@Autowired
	private FavoriteDao favoriteDao;

	@Override
	public BaseResponse useProcess(String data, HttpServletRequest request)
			throws ZmException {
		FavoriteCancelRequest favoriteCancelRequest = convertData(data,
				FavoriteCancelRequest.class);

		User currentUser = getCurrentUser();
		Integer uiId = favoriteCancelRequest.getUiId();
		Ui ui = uiDao.get(uiId);
		if (null == ui) {
			throw new ZmException(FavoriteCancelResponse.CODE_ERR_UIID);
		}
		List<Favorite> hased = favoriteDao.findByUserIdUiId(
				currentUser.getUserId(), ui.getUiId());
		if (null != hased&&hased.size()>0) {
			for (Favorite favorite : hased) {
				favoriteDao.delete(favorite);
			}
			ui.setFavoriteCount(ui.getFavoriteCount() == null ? 0 : ui
					.getFavoriteCount() - 1);
			uiDao.update(ui);
		}

		FavoriteCancelResponse response = new FavoriteCancelResponse();
		return response;
	}

}
