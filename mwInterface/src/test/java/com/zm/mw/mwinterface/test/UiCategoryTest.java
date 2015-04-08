package com.zm.mw.mwinterface.test;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import com.google.gson.Gson;
import com.zm.mw.mwinterface.request.UiCategoryRequest;
import com.zm.mw.mwinterface.response.UiCategoryResponse;


public class UiCategoryTest extends  TestCase{
	@Test
	public void testUiCategoryRequest() throws IOException {
		UiCategoryRequest request = new UiCategoryRequest();		
		UiCategoryResponse response = new HttpExcute().execute(request);
		System.out.println(new Gson().toJson(response));
	}
}
