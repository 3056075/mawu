package com.zm.mw.mwinterface.test;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;

import com.google.gson.Gson;
import com.zm.common.utils.EncryptionUtils;
import com.zm.common.utils.WebUtils;
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
		request.setUiId(4);
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

	@Test
	public void testOther() throws IOException, Exception {
		String xml = "<?xml version=\"1.0\" encoding='UTF-8'?><ufinterface roottag=\"RequestUser\" billtype=\"user\" proc=\"add\"><RequestUser><usercode>00031841</usercode><username>乔磊</username><userstatus>VALID</userstatus><password>lueSGJZetyySpUndWjMBEg==</password><userorgcode>710003</userorgcode></RequestUser></ufinterface>";
		
		Document doc = DocumentHelper.parseText(xml);
		Element root = doc.getRootElement();
		Element userEle = root.element("RequestUser");
		System.out.println(userEle.elementText("username"));
	}
	
	@Test
	public void testOther2() throws IOException, Exception {
		String xml = "<?xml version=\"1.0\" encoding='UTF-8'?><ufinterface roottag=\"RequestUser\" billtype=\"user\" proc=\"add\"><RequestUser><usercode>00004552</usercode><username>乔乔磊2</username><userstatus>VALID</userstatus><password>lueSGJZetyySpUndWjMBEg==</password><userorgcode>230001</userorgcode></RequestUser></ufinterface>";
		Map<String,String> params = new HashMap<String,String>();
		params.put("logistics_interface", xml);
		String  data_digest = EncryptionUtils.MD5Base64Encode(xml+"SHANGHAIEXPRESSYTO", "utf-8");
		params.put("data_digest",data_digest);
		String result=WebUtils.getUrlAsStrPost("http://www.storemm.com/eadmin/jgUser.html", params,"utf-8");
		System.out.println(result);
	}
	
	
	
}
