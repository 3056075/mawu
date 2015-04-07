package com.zm.mw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.common.constant.StringConstant;
import com.zm.common.exception.ZmException;
import com.zm.common.pagination.BasePagination;
import com.zm.common.utils.StringUtils;
import com.zm.mw.dao.FavoriteDao;
import com.zm.mw.dao.UiDao;
import com.zm.mw.entity.Favorite;
import com.zm.mw.entity.Ui;
import com.zm.mw.service.UiService;
import com.zm.user.entity.Role;
import com.zm.user.entity.User;
import com.zm.user.service.UserService;
@Service
public class UiServiceImpl implements UiService {
	@Autowired
	private UiDao uiDao;
	@Autowired
	private FavoriteDao favoriteDao;
	@Autowired
	private UserService userService;
	
	@Override
	public void searchUi(BasePagination<Ui> page) throws ZmException {
		if (StringUtils.isBlank(page.getSort())) {
			page.setSort("createTime");
			page.setDir(StringConstant.DESC);
		}
		if (page.isNeedSetTotal()) {
			Long count = uiDao.searchUiCount(page);
			page.setTotal(count.intValue());
		}
		List<Ui> result = uiDao.searchUi(page);
		page.setResult(result);
	}

	@Override
	public Ui findByUiId(Integer uiId) throws ZmException {
		return uiDao.get(uiId);
	}

	@Override
	public void saveOrUpdate(Ui ui) throws ZmException {
		if(null==ui.getUser()||null==ui.getSource()){
			User currentUser = userService.getCurrentUser();
			ui.setUser(currentUser);
			boolean isAdmin = false;
			for(Role role:currentUser.getRoles()){
				if(Role.ROLEID_ADMIN.equals(role.getRoleId())){
					isAdmin = true;
					break;
				}
			}
			ui.setSource(isAdmin?Ui.SOURCE_ADMIN:Ui.SOURCE_USER);
		}
		uiDao.saveOrUpdate(ui);
	}

	@Override
	public void delete(Integer uiId) throws ZmException {
		List<Favorite> favorites = favoriteDao.findByUiId(uiId);
		if(null!= favorites&&favorites.size()>0){
			for(Favorite favorite:favorites){
				favoriteDao.delete(favorite);
			}
		}
		Ui ui = uiDao.get(uiId);
		if(null!= ui){
			uiDao.delete(ui);
		}
	}

}
