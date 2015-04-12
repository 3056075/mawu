package com.zm.mw.service;

import java.util.List;
import java.util.Map;

public interface FavoriteService {
	public Map<Integer,Integer> getFavoriteCount(List<Integer> userIds);
	public Long findCount();
}
