package com.zm.mw.service;

import com.zm.common.exception.ZmException;
import com.zm.common.pagination.BasePagination;
import com.zm.mw.entity.Suggestion;

public interface SuggestionService {
	public void searchSuggestion(BasePagination<Suggestion> page) throws ZmException;
	public void saveReadSuggestion(Integer suggestionId) throws ZmException;
}
