package com.zm.mw.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.zm.common.dao.impl.BaseDaoImpl;
import com.zm.mw.dao.FavoriteDao;
import com.zm.mw.entity.Favorite;
@Repository
public class FavoriteDaoImpl extends BaseDaoImpl<Favorite> implements FavoriteDao {

	@Override
	public List<Favorite> findByUiId(Integer uiId) {
		String hql=" from Favorite f where f.ui.uiId=?";
		return this.find(hql,uiId);
	}

	@Override
	public Long findCountByUiId(Integer uiId) {
		String hql="select count(*) from Favorite f where f.ui.uiId=?";
		return this.count(hql,uiId);
	}

	@Override
	public List<Favorite> findByUserId(Integer userId) {
		String hql=" from Favorite f where f.user.userId=?";
		return this.find(hql,userId);
	}

	@Override
	public Long findCountByUserId(Integer userId) {
		String hql="select count(*) from Favorite f where f.user.userId=?";
		return this.count(hql,userId);
	}

}
