package com.zm.mw.mwinterface.response;

import com.zm.common.face.BaseResponse;
import com.zm.mw.mwinterface.request.LoginRequest;

public class LoginResponse extends BaseResponse {
	
	public static String CODE_ERR_PARAMS = LoginRequest.CODE+"01";//参数不能为空
	public static String CODE_ERR_WXLOGIN=LoginRequest.CODE+"02";//微信登陆失败
	
	private String nickName;//昵称
	private String headImgurl;//头像url
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadImgurl() {
		return headImgurl;
	}
	public void setHeadImgurl(String headImgurl) {
		this.headImgurl = headImgurl;
	}
	
	
}
