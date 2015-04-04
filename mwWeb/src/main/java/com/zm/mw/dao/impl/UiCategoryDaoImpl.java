package com.zm.mw.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zm.common.dao.impl.BaseDaoImpl;
import com.zm.mw.dao.UiCategoryDao;
import com.zm.mw.entity.UiCategory;
@Repository
public class UiCategoryDaoImpl extends BaseDaoImpl<UiCategory> implements UiCategoryDao {

	@Override
	public List<UiCategory> findAllByRank() {		
		return find(" from " + getPersistentClass().getName()
				+ " order by rank asc");
	}

	@Override
	public Integer findMaxRank() {
		List<Object> result = commonfind("select max(u.rank) from UiCategory u");
		if(null==result || result.isEmpty()){
			return null;
		}else{
			return new Integer(result.get(0).toString()) ;
		}
	}

	@Override
	public UiCategory findNext(Integer rank, Boolean isNext) {
		StringBuilder hql = new StringBuilder("select u from UiCategory u");
		hql.append(" where 1=1");
		if(isNext){
			hql.append(" and u.rank > :rank");
			hql.append(" order by s.rank asc");
		}else{
			hql.append(" and u.rank < :rank");
			hql.append(" order by s.rank desc");
		}		
		Map<String, Object> params = new HashMap<String,Object>();
		params.put("rank", rank);
		return this.get(hql.toString(), params);
	}

	



}
