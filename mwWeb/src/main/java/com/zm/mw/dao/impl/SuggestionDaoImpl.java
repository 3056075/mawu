package com.zm.mw.dao.impl;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Repository;

import com.zm.common.dao.impl.BaseDaoImpl;
import com.zm.common.pagination.BasePagination;
import com.zm.common.utils.StringUtils;
import com.zm.mw.dao.SuggestionDao;
import com.zm.mw.entity.Suggestion;

@Repository
public class SuggestionDaoImpl extends BaseDaoImpl<Suggestion> implements
		SuggestionDao {

	@Override
	public Long searchSuggestionCount(BasePagination<Suggestion> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder hql = new StringBuilder("select count(*)");
		searchSuggestionBase(hql, params, page);
		return this.count(hql.toString(), params);
	}

	@Override
	public List<Suggestion> searchSuggestion(BasePagination<Suggestion> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder hql = new StringBuilder("select s");
		searchSuggestionBase(hql, params, page);
		this.appendSort(hql, "s", page);
		return this.find(hql.toString(), params, page.getCurrentPage(),
				page.getLimit());
	}

	private void searchSuggestionBase(StringBuilder hql,
			Map<String, Object> params, BasePagination<Suggestion> page) {
		hql.append(" from Suggestion s");
		hql.append(" where 1=1");
		String word = null;
		String readed = null;
		String from = null;
		String to = null;
		if (null != page && null != page.getParams()) {
			word = page.getParams().get("word");
			readed = page.getParams().get("readed");
			from = page.getParams().get("from");
			to = page.getParams().get("to");
		}
		if (StringUtils.isNotBlank(readed)) {
			hql.append(" and s.readed = :readed");
			params.put("readed", new Short(readed));
		}
		if (StringUtils.isNotBlank(word)) {
			hql.append(" and s.contents like :word");
			params.put("word", "%" + word + "%");
		}
		try {
			if (StringUtils.isNotBlank(from)) {
				hql.append(" and s.createTime >= :from");
				params.put("from", DateUtils.parseDate(from,
						new String[] { "yyyy-MM-dd HH:mm:ss" }));

			}
		} catch (ParseException e) {
		}
		try {
			if (StringUtils.isNotBlank(to)) {
				hql.append(" and s.createTime < :to");
				params.put("to", DateUtils.parseDate(to,
						new String[] { "yyyy-MM-dd HH:mm:ss" }));
			}
		} catch (ParseException e) {
		}
	}

}
