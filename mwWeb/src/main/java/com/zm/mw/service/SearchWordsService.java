package com.zm.mw.service;

import com.zm.common.exception.ZmException;
import com.zm.common.pagination.BasePagination;
import com.zm.mw.entity.SearchWords;

public interface SearchWordsService {
	public void searchSearchWords(BasePagination<SearchWords> page) throws ZmException;
}
