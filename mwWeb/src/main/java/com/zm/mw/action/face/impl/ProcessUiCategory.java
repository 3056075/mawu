package com.zm.mw.action.face.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.mw.entity.UiCategory;
import com.zm.mw.mwinterface.request.UiCategoryRequest;
import com.zm.mw.mwinterface.response.UiCategoryResponse;
import com.zm.mw.mwinterface.response.UiCategoryResponse.IUiCategory;
import com.zm.mw.service.UiCategoryService;
import com.zm.user.service.UserService;
@Service(value=UiCategoryRequest.CODE)
public class ProcessUiCategory extends BaseProcess {
	protected static Logger logger = LoggerFactory
			.getLogger(ProcessUiCategory.class);
	@Autowired
	private UserService userService;
	@Autowired
	private UiCategoryService uiCategoryService;
	public BaseResponse useProcess(String data, HttpServletRequest request)
			throws ZmException {
		convertData(data,
				UiCategoryRequest.class);
		UiCategoryResponse response = new UiCategoryResponse();
		List<UiCategory> uiCategorys = uiCategoryService.findAllByRank();
		List<IUiCategory> result = new ArrayList<IUiCategory>();
		for(UiCategory uiCategory:uiCategorys){
			IUiCategory iUiCategory = new IUiCategory();
			iUiCategory.setName(uiCategory.getName());
			iUiCategory.setUiCategoryId(uiCategory.getUiCategoryId());
			result.add(iUiCategory);
		}
		response.setUiCategorys(result);
		return response;
	}
}
