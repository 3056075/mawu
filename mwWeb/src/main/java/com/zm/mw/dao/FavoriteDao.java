package com.zm.mw.dao;

import java.util.List;

import com.zm.common.dao.BaseDao;
import com.zm.common.pagination.BasePagination;
import com.zm.mw.entity.Favorite;

public interface FavoriteDao extends BaseDao<Favorite>{
	public Long findCount();
	public List<Favorite> findByUiId(Integer uiId);
	public Long findCountByUiId(Integer uiId);
	public List<Favorite> findByUserId(Integer userId);
	public Long findCountByUserId(Integer userId);
	
	public List<Favorite> findByUserIdUiId(Integer userId,Integer uiId);
	
	
	public Long searchFavoriteCount(BasePagination<Favorite> page) ;
	public List<Favorite> searchFavorite(BasePagination<Favorite> page) ;	
	
}
