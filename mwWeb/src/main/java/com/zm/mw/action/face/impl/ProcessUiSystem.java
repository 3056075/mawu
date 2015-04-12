package com.zm.mw.action.face.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.common.utils.MessageUtils;
import com.zm.mw.entity.Ui;
import com.zm.mw.mwinterface.request.UiSystemRequest;
import com.zm.mw.mwinterface.response.UiSystemResponse;
import com.zm.mw.mwinterface.response.UiSystemResponse.IUiSystem;
@Service(value = UiSystemRequest.CODE)
public class ProcessUiSystem extends BaseProcess {

	@Override
	public BaseResponse useProcess(String data, HttpServletRequest request)
			throws ZmException {
		UiSystemRequest uiSystemRequest = convertData(data, UiSystemRequest.class);		
		UiSystemResponse response = new UiSystemResponse();
		List<IUiSystem> uiSystems= new ArrayList<IUiSystem>();
		for(Integer system:Ui.SYSTEMS){
			IUiSystem iUiSystem = new IUiSystem();
			iUiSystem.setUiSystemId(system);
			String name = MessageUtils.getMessage("Ui.system."+system, null);
			iUiSystem.setName(name);
			uiSystems.add(iUiSystem);
		}
		response.setUiSystems(uiSystems);
		return response;
	}

}
