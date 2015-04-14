package com.zm.mw.action.face.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.common.constant.StringConstant;
import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.common.pagination.BasePagination;
import com.zm.common.utils.StringUtils;
import com.zm.mw.dao.FavoriteDao;
import com.zm.mw.dao.SearchWordsDao;
import com.zm.mw.dao.UiCategoryDao;
import com.zm.mw.entity.Favorite;
import com.zm.mw.entity.SearchWords;
import com.zm.mw.entity.Ui;
import com.zm.mw.entity.UiCategory;
import com.zm.mw.mwinterface.request.UiSearchRequest;
import com.zm.mw.mwinterface.response.UiSearchResponse;
import com.zm.mw.mwinterface.response.UiSearchResponse.IUi;
import com.zm.mw.service.UiService;
import com.zm.user.entity.User;

@Service(value = UiSearchRequest.CODE)
public class ProcessUiSearch extends BaseProcess {
	@Autowired
	private UiService uiService;
	@Autowired
	private UiCategoryDao uiCategoryDao;
	@Autowired
	private FavoriteDao favoriteDao;
	@Autowired
	private SearchWordsDao searchWordsDao;
	@Override
	public BaseResponse useProcess(String data, HttpServletRequest request)
			throws ZmException {
		UiSearchRequest uiSearchRequest = convertData(data,
				UiSearchRequest.class);
		BasePagination<Ui> page = new BasePagination<Ui>();
		
		page.putParam(
				"uiCategoryId",
				uiSearchRequest.getCategoryId() == null ? "" : String.valueOf(uiSearchRequest.getCategoryId()));
		page.putParam("searchWord", uiSearchRequest.getKeywords());
		page.putParam("status", Ui.STATUS_SHOW.toString());
		page.setCurrentPage(uiSearchRequest.getPageNum());
		page.setSort("favoriteCount");
		page.setDir(StringConstant.DESC);
		uiService.searchUi(page);
		//
		User user = null;
		try {
			user = getCurrentUser();
		} catch (Exception e) {
		}
		UiSearchResponse response = new UiSearchResponse();
		if (null != uiSearchRequest.getCategoryId()) {
			UiCategory uiCat = uiCategoryDao.get(uiSearchRequest
					.getCategoryId());
			if (null != uiCat) {
				response.setCategoryName(uiCat.getName());
				response.setCategoryId(uiCat.getUiCategoryId());
				
				//add search words
				 SearchWords searchWords = searchWordsDao.getByUiCategoryId(uiCat.getUiCategoryId());
				 if(null==searchWords){
					 searchWords = new SearchWords();
					 searchWords.setType(SearchWords.TYPE_UICATEGORY);
					 searchWords.setUiCategory(uiCat);
					 searchWords.setTimes(0);
				 }
				 searchWords.setTimes(searchWords.getTimes()+1);
				 searchWordsDao.saveOrUpdate(searchWords);
			}
		}
		response.setKeywords(uiSearchRequest.getKeywords());
		response.setPageNum(page.getCurrentPage());
		if(StringUtils.isNotBlank(uiSearchRequest.getKeywords())){
			//add search words
			 SearchWords searchWords = searchWordsDao.getByWord(uiSearchRequest.getKeywords());
			 if(null==searchWords){
				 searchWords = new SearchWords();
				 searchWords.setType(SearchWords.TYPE_WORD);
				 searchWords.setWord(uiSearchRequest.getKeywords());	
				 searchWords.setTimes(0);
			 }
			 searchWords.setTimes(searchWords.getTimes()+1);
			 searchWordsDao.saveOrUpdate(searchWords);
		}
		
		
		
		List<IUi> iuis = new ArrayList<IUi>();
		if (page.getResult() != null && !page.getResult().isEmpty()) {
			for(Ui ui:page.getResult()){				
				IUi iui = new IUi();
				iui.setUiId(ui.getUiId());
				iui.setProductName(ui.getProductName());
				iui.setImgUrl(ui.getImgUrl());
				iui.setFavorited(Boolean.FALSE);
				if (user != null) {
					List<Favorite> favs = favoriteDao.findByUserIdUiId(
							user.getUserId(), ui.getUiId());
					if (null != favs && !favs.isEmpty()) {
						iui.setFavorited(Boolean.TRUE);
					}
				}
				iuis.add(iui);
			}
		}
		response.setUis(iuis);
		return response;
	}

}
