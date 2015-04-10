package com.zm.mw.mwinterface.request;

import java.util.List;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.SuggestionResponse;

public class SuggestionRequest extends BaseRequest<SuggestionResponse>{
	public static final String CODE = "F_6040";
	@Override
	public String faceCode() {		
		return CODE;
	}
	private String contents;//内容
	private List<String> base64Imgs;//图片的base64编码
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public List<String> getBase64Imgs() {
		return base64Imgs;
	}
	public void setBase64Imgs(List<String> base64Imgs) {
		this.base64Imgs = base64Imgs;
	}
	
	
}
