package com.zm.mw.action.face.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.zm.common.action.face.IProcessBase;
import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.user.entity.User;
import com.zm.user.service.UserService;

public abstract class BaseProcess extends IProcessBase {
	@Autowired
	private UserService userService;

	protected User getCurrentUser() throws ZmException {
		try {
			return userService.getCurrentUser();
		} catch (ZmException e) {
			throw new ZmException(BaseResponse.CODE_LOGIN);
		}
	}
}
