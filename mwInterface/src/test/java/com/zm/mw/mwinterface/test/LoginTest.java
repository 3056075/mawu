package com.zm.mw.mwinterface.test;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Test;

import com.google.gson.Gson;
import com.zm.mw.mwinterface.request.LoginRequest;
import com.zm.mw.mwinterface.response.LoginResponse;


public class LoginTest extends  TestCase{
	@Test
	public void testLogin() throws IOException {
		LoginRequest request = new LoginRequest();		
		request.setType((short)1);
		request.setCode("C2");
		LoginResponse response = new HttpExcute().execute(request);
		System.out.println(new Gson().toJson(response));
	}
}
