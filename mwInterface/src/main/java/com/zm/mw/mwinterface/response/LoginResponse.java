package com.zm.mw.mwinterface.response;

import com.zm.common.face.BaseResponse;

public class LoginResponse extends BaseResponse {
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
