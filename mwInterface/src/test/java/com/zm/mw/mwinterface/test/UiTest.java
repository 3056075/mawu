package com.zm.mw.mwinterface.test;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.google.gson.Gson;
import com.zm.mw.mwinterface.request.UiAddRequest;
import com.zm.mw.mwinterface.request.UiInfoRequest;
import com.zm.mw.mwinterface.request.UiSearchRequest;
import com.zm.mw.mwinterface.request.UiSystemRequest;
import com.zm.mw.mwinterface.response.UiAddResponse;
import com.zm.mw.mwinterface.response.UiInfoResponse;
import com.zm.mw.mwinterface.response.UiSearchResponse;
import com.zm.mw.mwinterface.response.UiSystemResponse;

public class UiTest extends TestCase {
	@Test
	public void testAdd() throws IOException {
		UiAddRequest request = new UiAddRequest();
		String file = "D:\\devzm\\workspace\\mw\\mawu\\mwInterface\\src\\test\\resources\\1.jpg";
		String picBase641 = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(new File(file)));	
		request.setBase64Img(picBase641);
		request.setKeywords("关键词 关键词");
		request.setPageName("页面名称");
		request.setProductName("产品名称");
		request.setSystem(10);
		request.setUiCategoryId(17);
		UiAddResponse response = new HttpExcute().execute(request);
		System.out.println(new Gson().toJson(response));
	}

	@Test
	public void testInfo() throws IOException {
		UiInfoRequest request = new UiInfoRequest();
		request.setUiId(4);
		UiInfoResponse response = new HttpExcute().execute(request);
		System.out.println(new Gson().toJson(response));
	}

	@Test
	public void testSearch() throws IOException {
		UiSearchRequest request = new UiSearchRequest();
		request.setKeywords("产");;
		UiSearchResponse response = new HttpExcute().execute(request);
		System.out.println(new Gson().toJson(response));
	}

	@Test
	public void testUiSystemOption() throws IOException {
		UiSystemRequest request = new UiSystemRequest();
		UiSystemResponse response = new HttpExcute().execute(request);
		System.out.println(new Gson().toJson(response));
	}
}
