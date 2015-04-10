package com.zm.mw.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.zm.common.dao.impl.BaseDaoImpl;
import com.zm.mw.dao.FavoriteDao;
import com.zm.mw.entity.Favorite;

@Repository
public class FavoriteDaoImpl extends BaseDaoImpl<Favorite> implements
		FavoriteDao {

	@Override
	public List<Favorite> findByUiId(Integer uiId) {
		String hql = " from Favorite f where f.ui.uiId=?";
		return this.find(hql, uiId);
	}

	@Override
	public Long findCountByUiId(Integer uiId) {
		String hql = "select count(*) from Favorite f where f.ui.uiId=?";
		return this.count(hql, uiId);
	}

	@Override
	public List<Favorite> findByUserId(Integer userId) {
		String hql = " from Favorite f where f.user.userId=?";
		return this.find(hql, userId);
	}

	@Override
	public Long findCountByUserId(Integer userId) {
		String hql = "select count(*) from Favorite f where f.user.userId=?";
		return this.count(hql, userId);
	}

	@Override
	public List<Favorite> findByUserIdUiId(Integer userId, Integer uiId) {
		String hql = " from Favorite f where f.ui.uiId= :uiId and f.user.userId= :userId";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("uiId", uiId);
		return this.find(hql, params);
	}

}
