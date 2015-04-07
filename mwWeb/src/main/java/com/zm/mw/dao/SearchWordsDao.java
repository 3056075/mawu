package com.zm.mw.dao;

import java.util.List;

import com.zm.common.dao.BaseDao;
import com.zm.common.pagination.BasePagination;
import com.zm.mw.entity.SearchWords;

public interface SearchWordsDao extends BaseDao<SearchWords>{
	public Long searchSearchWordsCount(BasePagination<SearchWords> page);
	public List<SearchWords> searchSearchWords(BasePagination<SearchWords> page);
}
