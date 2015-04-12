package com.zm.mw.action.face.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.common.pagination.BasePagination;
import com.zm.mw.dao.FavoriteDao;
import com.zm.mw.entity.Favorite;
import com.zm.mw.mwinterface.request.FavoriteSearchRequest;
import com.zm.mw.mwinterface.response.FavoriteSearchResponse;
import com.zm.mw.mwinterface.response.FavoriteSearchResponse.IUi;
import com.zm.user.entity.User;
@Service(value = FavoriteSearchRequest.CODE)
public class ProcessFavoriteSearch extends BaseProcess {
	@Autowired
	private FavoriteDao favoriteDao;
	@Override
	public BaseResponse useProcess(String data, HttpServletRequest request)
			throws ZmException {
		FavoriteSearchRequest favoriteSearchRequest = convertData(data, FavoriteSearchRequest.class);
		FavoriteSearchResponse response = new FavoriteSearchResponse();
		List<IUi> iUis = new ArrayList<IUi>();
		response.setUis(iUis);
		//
		BasePagination<Favorite> page = new BasePagination<Favorite>();
		page.setLimit(10);
		page.setCurrentPage(favoriteSearchRequest.getPageNum());
		Map<String, String> params = new HashMap<String, String>();
		User currentUser = this.getCurrentUser();
		params.put("userId", String.valueOf(currentUser.getUserId()));
		page.setParams(params);
		List<Favorite> result = favoriteDao.searchFavorite(page);
		if(result!=null&&result.size()>0){
			for(Favorite favorite:result){
				IUi iUi = new IUi();
				iUi.setUiId(favorite.getUi().getUiId());
				iUi.setProductName(favorite.getUi().getProductName());
				iUi.setImgUrl(favorite.getUi().getImgUrl());
				iUi.setFavorited(Boolean.TRUE);
				iUis.add(iUi);
			}
		}	
		return response;
	}

}
