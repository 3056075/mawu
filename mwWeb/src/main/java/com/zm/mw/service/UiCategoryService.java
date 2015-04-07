package com.zm.mw.service;

import java.util.List;

import com.zm.common.exception.ZmException;
import com.zm.mw.entity.UiCategory;

public interface UiCategoryService {
	public List<UiCategory> findAllByRank() throws ZmException;
	public UiCategory findByUiCategoryId(Integer uiCategoryId) throws ZmException;
	public void saveOrUpdate(UiCategory uiCategory) throws ZmException;
	public void delete(Integer uiCategoryId) throws ZmException;
	public void saveExchangeUiCategory(Integer uiCategoryId, Boolean isNext) throws ZmException;
}
