package com.zm.mw.dao;

import java.util.List;

import com.zm.common.dao.BaseDao;
import com.zm.mw.entity.Favorite;

public interface FavoriteDao extends BaseDao<Favorite>{
	public List<Favorite> findByUiId(Integer uiId);
	public Long findCountByUiId(Integer uiId);
	public List<Favorite> findByUserId(Integer userId);
	public Long findCountByUserId(Integer userId);
}
