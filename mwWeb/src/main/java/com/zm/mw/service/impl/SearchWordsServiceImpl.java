package com.zm.mw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.common.constant.StringConstant;
import com.zm.common.exception.ZmException;
import com.zm.common.pagination.BasePagination;
import com.zm.common.utils.StringUtils;
import com.zm.mw.dao.SearchWordsDao;
import com.zm.mw.entity.SearchWords;
import com.zm.mw.service.SearchWordsService;
@Service
public class SearchWordsServiceImpl implements SearchWordsService {
	@Autowired
	private SearchWordsDao searchWordsDao;
	@Override
	public void searchSearchWords(BasePagination<SearchWords> page)
			throws ZmException {
		if (StringUtils.isBlank(page.getSort())) {
			page.setSort("times");
			page.setDir(StringConstant.DESC);
		}
		if (page.isNeedSetTotal()) {
			Long count = searchWordsDao.searchSearchWordsCount(page);
			page.setTotal(count.intValue());
		}
		List<SearchWords> result = searchWordsDao.searchSearchWords(page);
		page.setResult(result);
		
	}
	
}
