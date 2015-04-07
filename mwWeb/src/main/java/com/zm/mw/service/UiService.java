package com.zm.mw.service;

import java.util.List;

import com.zm.common.exception.ZmException;
import com.zm.common.pagination.BasePagination;
import com.zm.mw.entity.Ui;

public interface UiService {
	public List<Ui> searchUi(BasePagination<Ui> page) throws ZmException;
	public Ui findByUiId(Integer uiId) throws ZmException;
	public void saveOrUpdate(Ui ui) throws ZmException;
	public void delete(Integer uiId) throws ZmException;
}
