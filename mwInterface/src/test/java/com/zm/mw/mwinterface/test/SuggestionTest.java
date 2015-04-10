package com.zm.mw.mwinterface.test;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import com.google.gson.Gson;
import com.zm.mw.mwinterface.request.SuggestionRequest;
import com.zm.mw.mwinterface.response.SuggestionResponse;

public class SuggestionTest extends TestCase {
	@Test
	public void testSuggestion() throws IOException {
		SuggestionRequest request = new SuggestionRequest();
		request.setContents("asdasdasdas");
		request.setBase64Imgs(null);
		//TODO
		SuggestionResponse response = new HttpExcute().execute(request);
		System.out.println(new Gson().toJson(response));
	}


}
