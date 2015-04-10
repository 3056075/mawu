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
import com.zm.mw.mwinterface.request.FavoriteAddRequest;
import com.zm.mw.mwinterface.response.FavoriteAddResponse;
import com.zm.user.entity.User;

@Service(value = FavoriteAddRequest.CODE)
public class ProcessFavoriteAdd extends BaseProcess {

	@Autowired
	private UiDao uiDao;
	@Autowired
	private FavoriteDao favoriteDao;

	@Override
	public BaseResponse useProcess(String data, HttpServletRequest request)
			throws ZmException {
		FavoriteAddRequest favoriteAddRequest = convertData(data,
				FavoriteAddRequest.class);

		User currentUser = getCurrentUser();
		Integer uiId = favoriteAddRequest.getUiId();
		Ui ui = uiDao.get(uiId);
		if (null == ui) {
			throw new ZmException(FavoriteAddResponse.CODE_ERR_UIID);
		}
		List<Favorite> hased = favoriteDao.findByUserIdUiId(
				currentUser.getUserId(), ui.getUiId());
		if (null == hased || hased.isEmpty()) {
			Favorite favorite = new Favorite();
			favorite.setUi(ui);
			favorite.setUser(currentUser);
			favoriteDao.save(favorite);
			ui.setFavoriteCount(ui.getFavoriteCount() == null ? 0 : ui
					.getFavoriteCount() + 1);
			uiDao.update(ui);
		}

		FavoriteAddResponse response = new FavoriteAddResponse();
		return response;
	}
}
