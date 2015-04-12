package com.zm.mw.mwinterface.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.google.gson.Gson;
import com.zm.mw.mwinterface.request.SuggestionRequest;
import com.zm.mw.mwinterface.response.SuggestionResponse;

public class SuggestionTest extends TestCase {
	@Test
	public void testSuggestion() throws IOException {
		SuggestionRequest request = new SuggestionRequest();
		request.setContents("asdasdasdas"+new Date().toString());
		
		String file = "D:\\devzm\\workspace\\mw\\mawu\\mwInterface\\src\\test\\resources\\1.jpg";
		String picBase641 = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(new File(file)));
		String file2 = "D:\\devzm\\workspace\\mw\\mawu\\mwInterface\\src\\test\\resources\\1.jpg";
		String picBase642 = Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(new File(file2)));
		List<String> result = new ArrayList<String>();
		result.add(picBase641);
		result.add(picBase642);
		request.setBase64Imgs(result);
		SuggestionResponse response = new HttpExcute().execute(request);
		System.out.println(new Gson().toJson(response));
	}


}
