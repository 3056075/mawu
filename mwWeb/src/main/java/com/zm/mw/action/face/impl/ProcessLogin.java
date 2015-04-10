package com.zm.mw.action.face.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import com.zm.common.action.face.IProcessBase;
import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseResponse;
import com.zm.common.utils.StringUtils;
import com.zm.mw.mwinterface.request.LoginRequest;
import com.zm.mw.mwinterface.response.LoginResponse;
import com.zm.user.entity.Oauth;
import com.zm.user.entity.User;
import com.zm.user.service.OauthService;

@Service(value = LoginRequest.CODE)
public class ProcessLogin extends IProcessBase {
	@Autowired
	private OauthService oauthService;
	@Autowired
	private AuthenticationManager autheticationManager;
	
	public BaseResponse process(String data, HttpServletRequest request)
			throws ZmException {
		LoginRequest loginRequest = convertData(data, LoginRequest.class);
		if (loginRequest == null || loginRequest.getType() == null
				|| StringUtils.isBlank(loginRequest.getCode())) {			
			throw new ZmException(LoginResponse.CODE_ERR_PARAMS);
		}
		User user=null;
		if(Oauth.TYPE_WEIXIN.equals(loginRequest.getType())){
			//wx 登陆
			try {
				 user=oauthService.wxOauth(loginRequest.getCode());
			} catch (Exception e) {
				throw new ZmException(LoginResponse.CODE_ERR_WXLOGIN);
			}
		}else if(Oauth.TYPE_QQ.equals(loginRequest.getType())){
			//TODO qq
			
			
		}else{
			throw new ZmException(LoginResponse.CODE_ERR_PARAMS);
		}		
		authenticateUserAndSetSession(user.getUsername(),oauthService.getDefaultPassword(),request);
		LoginResponse response = new LoginResponse();
		response.setNickName(user.getName());
		response.setHeadImgurl(user.getHeadImgurl());
		return response;
	}
	
	private Authentication authenticateUserAndSetSession(String username,
			String password, HttpServletRequest request) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				username, password);

		// generate session if one doesn't exist
		request.getSession();
		token.setDetails(new WebAuthenticationDetails(request));
		Authentication authenticatedUser = autheticationManager
				.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
		return authenticatedUser;
	}
}
