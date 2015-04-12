package com.zm.mw.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.mw.dao.FavoriteDao;
import com.zm.mw.service.FavoriteService;

@Service
public class FavoriteServiceImpl implements FavoriteService {
	@Autowired
	private FavoriteDao favoriteDao;

	@Override
	public Map<Integer, Integer> getFavoriteCount(List<Integer> userIds) {
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		if (null != userIds) {
			for (Integer userId : userIds) {
				Long count = favoriteDao.findCountByUserId(userId);
				result.put(userId, count.intValue());
			}
		}
		return result;
	}

	@Override
	public Long findCount() {
		return favoriteDao.findCount();
	}

}
