package com.zm.mw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.common.constant.StringConstant;
import com.zm.common.exception.ZmException;
import com.zm.common.pagination.BasePagination;
import com.zm.common.utils.StringUtils;
import com.zm.mw.dao.SuggestionDao;
import com.zm.mw.entity.Suggestion;
import com.zm.mw.service.SuggestionService;
@Service
public class SuggestionServiceImpl implements SuggestionService {
	@Autowired
	private SuggestionDao suggestionDao;
	@Override
	public void searchSuggestion(BasePagination<Suggestion> page)
			throws ZmException {
		if (StringUtils.isBlank(page.getSort())) {
			page.setSort("createTime");
			page.setDir(StringConstant.DESC);
		}
		if (page.isNeedSetTotal()) {
			Long count = suggestionDao.searchSuggestionCount(page);
			page.setTotal(count.intValue());
		}
		List<Suggestion> result = suggestionDao.searchSuggestion(page);
		page.setResult(result);
		
	}

	@Override
	public void readSuggestion(Integer suggestionId) throws ZmException {
		Suggestion suggestion = suggestionDao.get(suggestionId);
		if(null!=suggestion){
			suggestion.setReaded(Suggestion.READED_YES);
			suggestionDao.update(suggestion);
		}
	}

}
