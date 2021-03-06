package com.zm.mw.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zm.common.dao.impl.BaseDaoImpl;
import com.zm.common.pagination.BasePagination;
import com.zm.common.utils.StringUtils;
import com.zm.mw.dao.SearchWordsDao;
import com.zm.mw.entity.SearchWords;

@Repository
public class SearchWordsDaoImpl extends BaseDaoImpl<SearchWords> implements
		SearchWordsDao {

	@Override
	public Long searchSearchWordsCount(BasePagination<SearchWords> page) {
		Map<String, Object> params = new HashMap<String,Object>();
		StringBuilder hql = new StringBuilder("select count(*)");
		searchSearchWordsBase(hql,params,page);
		return this.count(hql.toString(), params);
	}

	@Override
	public List<SearchWords> searchSearchWords(BasePagination<SearchWords> page) {
		Map<String, Object> params = new HashMap<String,Object>();
		StringBuilder hql = new StringBuilder("select s");
		searchSearchWordsBase(hql,params,page);
		this.appendSort(hql, "s", page);
		return this.find(hql.toString(),params,page.getCurrentPage(),page.getLimit());	
	}

	private void searchSearchWordsBase(StringBuilder hql,
			Map<String, Object> params, BasePagination<SearchWords> page) {
		hql.append(" from SearchWords s");
		hql.append(" where 1=1");
		String word=null;
		String minCount = null;
		String maxCount=null;
		if(null != page && null != page.getParams()){
			word = page.getParams().get("word");			
			minCount = page.getParams().get("minCount");
			maxCount = page.getParams().get("maxCount");
		}
		
		if(StringUtils.isNotBlank(minCount)){
			hql.append(" and s.times >= :minCount");	
			params.put("minCount", new Integer(minCount));
		}
		if(StringUtils.isNotBlank(maxCount)){
			hql.append(" and s.times <= :maxCount");	
			params.put("maxCount", new Integer(maxCount));
		}
		if(StringUtils.isNotBlank(word)){
			hql.append(" and (s.word like :word or s.uiCategory.name like :word)");	
			params.put("word", "%"+word+"%");
		}
	}

	@Override
	public SearchWords getByWord(String word) {
		String hql = "select s from SearchWords s where s.word=? and s.type="
				+ SearchWords.TYPE_WORD;
		List<SearchWords> result = this.find(hql, word);
		return result != null && result.size() > 0 ? result.get(0) : null;
	}

	@Override
	public SearchWords getByUiCategoryId(Integer uiCategoryId) {
		String hql="select s from SearchWords s where s.uiCategory.uiCategoryId=? and s.type="+SearchWords.TYPE_UICATEGORY;
		List<SearchWords> result = this.find(hql, uiCategoryId);
		return result != null && result.size() > 0 ? result.get(0) : null;
	}

}
