package com.zm.mw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.common.exception.ZmException;
import com.zm.mw.dao.UiCategoryDao;
import com.zm.mw.entity.UiCategory;
import com.zm.mw.service.UiCategoryService;

@Service
public class UiCategoryServiceImpl implements UiCategoryService {
	@Autowired
	private UiCategoryDao uiCategoryDao;

	@Override
	public List<UiCategory> findAllByRank() throws ZmException {
		return uiCategoryDao.findAllByRank();
	}
	@Override
	public UiCategory findByUiCategoryId(Integer uiCategoryId)
			throws ZmException {		
		return uiCategoryDao.get(uiCategoryId);
	}
	@Override
	public void saveOrUpdate(UiCategory uiCategory) throws ZmException {
		Integer rank = uiCategory.getRank();
		if (null == rank) {
			rank = uiCategoryDao.findMaxRank();
			if (null == rank) {
				rank = 0;
			} else {
				rank = rank + 1;
			}
			uiCategory.setRank(rank);
		}
		uiCategoryDao.saveOrUpdate(uiCategory);
	}

	@Override
	public void delete(Integer uiCategoryId) throws ZmException {
		UiCategory uiCategory =uiCategoryDao.get(uiCategoryId);
		if(uiCategory.getUis()!=null&&uiCategory.getUis().size()>0){
			throw new ZmException("分类下有内容，不能删除");
		}else{
			uiCategoryDao.delete(uiCategory);
		}

	}

	@Override
	public void saveExchangeUiCategory(Integer uiCategoryId, Boolean isNext)
			throws ZmException {
		UiCategory current = uiCategoryDao.get(uiCategoryId);
		if(current==null){
			throw new ZmException("找不到对应的分类");
		}
		UiCategory exchangeOne = uiCategoryDao.findNext(current.getRank(),  isNext==null?true:isNext);
		if(exchangeOne==null){
			throw new ZmException("找不到相邻的产品/服务");
		}
		Integer tmpRank = current.getRank();
		current.setRank(exchangeOne.getRank());
		exchangeOne.setRank(tmpRank);
		uiCategoryDao.saveOrUpdate(current);
		uiCategoryDao.saveOrUpdate(exchangeOne);
	}





}
