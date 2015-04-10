package com.zm.mw.mwinterface.test;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import com.google.gson.Gson;
import com.zm.mw.mwinterface.request.FavoriteAddRequest;
import com.zm.mw.mwinterface.request.FavoriteCancelRequest;
import com.zm.mw.mwinterface.request.FavoriteSearchRequest;
import com.zm.mw.mwinterface.response.FavoriteAddResponse;
import com.zm.mw.mwinterface.response.FavoriteCancelResponse;
import com.zm.mw.mwinterface.response.FavoriteSearchResponse;

public class FavoriteTest extends TestCase {
	@Test
	public void testAdd() throws IOException {
		FavoriteAddRequest request = new FavoriteAddRequest();
		request.setUiId(4);
		FavoriteAddResponse response = new HttpExcute().execute(request);
		System.out.println(new Gson().toJson(response));
	}

	@Test
	public void testCancel() throws IOException {
		FavoriteCancelRequest request = new FavoriteCancelRequest();
		request.setUiId(2);
		FavoriteCancelResponse response = new HttpExcute().execute(request);
		System.out.println(new Gson().toJson(response));
	}

	@Test
	public void testSearch() throws IOException {
		FavoriteSearchRequest request = new FavoriteSearchRequest();
		request.setPageNum(0);
		FavoriteSearchResponse response = new HttpExcute().execute(request);
		System.out.println(new Gson().toJson(response));
	}
}
