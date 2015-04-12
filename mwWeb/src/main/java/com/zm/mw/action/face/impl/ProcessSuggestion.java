package com.zm.mw.action.face.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.common.constant.StringConstant;
import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.common.service.UploadService;
import com.zm.mw.dao.SuggestionDao;
import com.zm.mw.entity.Suggestion;
import com.zm.mw.mwinterface.request.SuggestionRequest;
import com.zm.mw.mwinterface.response.SuggestionResponse;
import com.zm.user.entity.User;
@Service(value = SuggestionRequest.CODE)
public class ProcessSuggestion extends BaseProcess {
	@Autowired
	private SuggestionDao suggestionDao;
	@Autowired
	private UploadService uploadService;
	@Override
	public BaseResponse useProcess(String data, HttpServletRequest request)
			throws ZmException {
		SuggestionRequest suggestionRequest = convertData(data, SuggestionRequest.class);
		User user = getCurrentUser();		
		StringBuilder imgurls = new StringBuilder();
		if(suggestionRequest.getBase64Imgs()!=null){
			for(String base64Img:suggestionRequest.getBase64Imgs()){
	 			String picUrl = uploadService.saveFileBase64(base64Img);
	 			if(imgurls.length()>0){
	 				imgurls.append(StringConstant.COMMA);
	 			}
	 			imgurls.append(picUrl);
			}
		}
		Suggestion suggestion = new Suggestion();
		suggestion.setUser(user);
		suggestion.setContents(suggestionRequest.getContents());
		suggestion.setImgUrls(imgurls.toString());
		suggestion.setReaded(Suggestion.READED_NO);
		suggestionDao.save(suggestion);
		SuggestionResponse response = new SuggestionResponse();
		return response;
	}

}
