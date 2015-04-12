package com.zm.mw.action.face.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.common.service.UploadService;
import com.zm.common.utils.StringUtils;
import com.zm.mw.dao.UiCategoryDao;
import com.zm.mw.dao.UiDao;
import com.zm.mw.entity.Ui;
import com.zm.mw.entity.UiCategory;
import com.zm.mw.mwinterface.request.UiAddRequest;
import com.zm.mw.mwinterface.response.UiAddResponse;
import com.zm.user.entity.Role;
import com.zm.user.entity.User;

@Service(value = UiAddRequest.CODE)
public class ProcessUiAdd extends BaseProcess {
	@Autowired
	private UiDao uiDao;
	@Autowired
	private UiCategoryDao uiCategoryDao;
	@Autowired
	private UploadService uploadService;
	
	@Override
	public BaseResponse useProcess(String data, HttpServletRequest request)
			throws ZmException {
		UiAddRequest uiAddRequest = convertData(data, UiAddRequest.class);
		User user = getCurrentUser();
		if(StringUtils.isEmpty(uiAddRequest.getProductName())){
			throw new ZmException(UiAddResponse.CODE_NULL_PRODUCTNAME);
		}
		if(StringUtils.isEmpty(uiAddRequest.getPageName())){
			throw new ZmException(UiAddResponse.CODE_NULL_PAGENAME);
		}
		if (null == uiAddRequest.getSystem()
				|| !ArrayUtils.contains(Ui.SYSTEMS, uiAddRequest.getSystem())) {
			throw new ZmException(UiAddResponse.CODE_NULL_SYSTEM);
		}
		UiCategory uiCategory = uiCategoryDao.get(uiAddRequest.getUiCategoryId());
		if(null == uiCategory){
			throw new ZmException(UiAddResponse.CODE_NULL_CATID);
		}
		if(null==uiAddRequest.getBase64Img()){
			throw new ZmException(UiAddResponse.CODE_NULL_IMG);
		}
		String imgUrl = uploadService.saveFileBase64(uiAddRequest.getBase64Img());
		//
		Ui ui = new Ui();
		ui.setFavoriteCount(0);
		ui.setImgUrl(imgUrl);
		ui.setKeywords(uiAddRequest.getKeywords());
		ui.setPageName(uiAddRequest.getPageName());
		ui.setProductName(uiAddRequest.getProductName());
		
		boolean isAdmin = false;
		for(Role role:user.getRoles()){
			if(Role.ROLEID_ADMIN.equals(role.getRoleId())){
				isAdmin = true;
				break;
			}
		}
		ui.setSource(isAdmin ? Ui.SOURCE_ADMIN : Ui.SOURCE_USER);
		ui.setStatus(isAdmin ? Ui.STATUS_SHOW : Ui.STATUS_HIDDEN);
		ui.setSystem(uiAddRequest.getSystem());
		ui.setUiCategory(uiCategory);
		ui.setUser(user);
		uiDao.save(ui);
		UiAddResponse response = new UiAddResponse();
		return response;
	}

}
