package com.zm.mw.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zm.common.dao.impl.BaseDaoImpl;
import com.zm.common.pagination.BasePagination;
import com.zm.common.utils.StringUtils;
import com.zm.mw.dao.UiDao;
import com.zm.mw.entity.Ui;
@Repository
public class UiDaoImpl extends BaseDaoImpl<Ui> implements UiDao {

	@Override
	public Long searchUiCount(BasePagination<Ui> page) {
		Map<String, Object> params = new HashMap<String,Object>();
		StringBuilder hql = new StringBuilder("select count(*)");
		searchUiBase(hql,params,page);
		return this.count(hql.toString(), params);
	}

	@Override
	public List<Ui> searchUi(BasePagination<Ui> page) {
		Map<String, Object> params = new HashMap<String,Object>();
		StringBuilder hql = new StringBuilder("select u");
		searchUiBase(hql,params,page);
		this.appendSort(hql, "u", page);
		return this.find(hql.toString(),params,page.getCurrentPage(),page.getLimit());	
	}
	private void searchUiBase(StringBuilder hql,Map<String, Object> params,BasePagination<Ui> page){
		hql.append(" from Ui u");
		hql.append(" where 1=1");
		String uiCategoryId=null;	
		String searchWord = null;
		String userId=null;	
		String system=null;
		String status=null;		
		String source=null;
		if(null != page && null != page.getParams()){
			uiCategoryId = page.getParams().get("uiCategoryId");
			searchWord = page.getParams().get("searchWord");
			userId = page.getParams().get("userId");
			system = page.getParams().get("system");
			status = page.getParams().get("status");
			source = page.getParams().get("source");
		}
		if(StringUtils.isNotBlank(uiCategoryId)){
			hql.append(" and u.uiCategory.uiCategoryId = :uiCategoryId");	
			params.put("uiCategoryId", new Integer(uiCategoryId));
		}
		if(StringUtils.isNotBlank(userId)){
			hql.append(" and u.user.userId = :userId");	
			params.put("userId", new Integer(userId));
		}
		if(StringUtils.isNotBlank(system)){
			hql.append(" and u.system = :system");	
			params.put("system", new Short(system));
		}
		if(StringUtils.isNotBlank(status)){
			hql.append(" and u.status = :status");	
			params.put("status", new Short(status));
		}
		if(StringUtils.isNotBlank(source)){
			hql.append(" and u.source = :source");	
			params.put("source", new Short(source));
		}
		if(StringUtils.isNotBlank(searchWord)){
			hql.append(" and (u.productName like :searchWord or u.pageName like :searchWord or u.keywords like :searchWord)");	
			params.put("searchWord", "%"+searchWord+"%");
		}
	}





}
