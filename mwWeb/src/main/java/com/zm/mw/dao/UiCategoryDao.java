package com.zm.mw.dao;

import java.util.List;

import com.zm.common.dao.BaseDao;
import com.zm.mw.entity.UiCategory;

public interface UiCategoryDao extends BaseDao<UiCategory>{
	public List<UiCategory> findAllByRank();
	public Integer findMaxRank();
	public UiCategory findNext(Integer rank,Boolean isNext);
}
