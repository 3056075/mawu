package com.zm.mw.mwinterface.test;

import java.io.IOException;

import junit.framework.TestCase;

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
		UiAddResponse response = new HttpExcute().execute(request);
		System.out.println(new Gson().toJson(response));
	}

	@Test
	public void testInfo() throws IOException {
		UiInfoRequest request = new UiInfoRequest();
		UiInfoResponse response = new HttpExcute().execute(request);
		System.out.println(new Gson().toJson(response));
	}

	@Test
	public void testSearch() throws IOException {
		UiSearchRequest request = new UiSearchRequest();
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
