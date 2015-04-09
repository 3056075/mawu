package com.zm.mw.mwinterface.request;

import com.zm.common.face.BaseRequest;
import com.zm.mw.mwinterface.response.UiInfoResponse;

public class UiInfoRequest extends BaseRequest<UiInfoResponse> {
	public static final String CODE = "F5020";

	@Override
	public String faceCode() {
		return CODE;
	}
	
	private Integer uiId;//搜索结果里面的uiId。从搜索结果里面获取到，搜索结果里面如果是第0页第1个，则没有上一张。
	//划动下一张时，如果本页已经显示完，则搜索下一页进行继续显示，如果下一页结果为空，则划动不变。
	//移动端记录下本次搜索结果也页数。便于搜索

	public Integer getUiId() {
		return uiId;
	}

	public void setUiId(Integer uiId) {
		this.uiId = uiId;
	}
	
	
}
