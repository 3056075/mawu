package com.zm.mw.dao;

import java.util.List;

import com.zm.common.dao.BaseDao;
import com.zm.common.pagination.BasePagination;
import com.zm.mw.entity.Suggestion;

public interface SuggestionDao extends BaseDao<Suggestion>{
	public Long searchSuggestionCount(BasePagination<Suggestion> page);
	public List<Suggestion> searchSuggestion(BasePagination<Suggestion> page);
}
