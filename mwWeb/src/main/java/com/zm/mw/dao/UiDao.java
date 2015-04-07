package com.zm.mw.dao;

import java.util.List;

import com.zm.common.dao.BaseDao;
import com.zm.common.pagination.BasePagination;
import com.zm.mw.entity.Ui;

public interface UiDao extends BaseDao<Ui>{
	public Long searchUiCount(BasePagination<Ui> page);
	public List<Ui> searchUi(BasePagination<Ui> page);
}
