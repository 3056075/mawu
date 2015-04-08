package com.zm.mw.mwinterface.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.zm.common.exception.ZmException;
import com.zm.common.face.BaseRequest;
import com.zm.common.face.BaseResponse;
import com.zm.common.utils.EncryptionUtils;

/**
 * 数据请求服务
 * 
 * @author jinyu
 * @createTime 2013-12-13
 * @updatePerson jinyu
 * @updateTime 2013-12-13
 */
public class HttpExcute {
	private static String BASE_URL = "http://127.0.0.1:8080/face/rest.htm";

	/**
	 * 整理传输数据
	 * 
	 * @param <T>
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends BaseResponse> T execute(BaseRequest<T> request) {
		Class<T> responseClazz = null;
		try {
			// 得到返回的clazz
			Type requestClazz = request.getClass().getGenericSuperclass();
			responseClazz = (Class<T>) ((ParameterizedType) requestClazz)
					.getActualTypeArguments()[0];

			//
			Gson gson = new Gson();
			String requestString = new Gson().toJson(request);
			String reqtime=DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss");
			String md5 = EncryptionUtils.md5Encode(requestString
					+ request.faceCode() + BaseRequest.VERSION
					+ BaseRequest.TYPE_JSON + reqtime +BaseRequest.SECRET);

			Map<String, String> params = new HashMap<String, String>();
			params.put("version", BaseRequest.VERSION);
			params.put("data", requestString);
			params.put("type", BaseRequest.TYPE_JSON);
			params.put("code", request.faceCode());
			params.put("reqtime", reqtime);
			params.put("md5", md5);

			String url = BASE_URL;

			String result = post(url, params);

			try {
				T t = gson.fromJson(result, responseClazz);
				return t;
			} catch (JsonSyntaxException e) {
				throw new ZmException(BaseResponse.CODE_JSON_C);
			}

		} catch (Exception e) {
			if (null != responseClazz) {
				try {
					T response = responseClazz.newInstance();
					response.setSuccess(false);
					if (e instanceof ZmException) {
						ZmException aexception = (ZmException) e;
						response.setCode(aexception.getMessage());
						response.setMessage(aexception.getOrgMessage());
					} else {
						response.setCode(BaseResponse.CODE_UNKNOW);
						response.setMessage("未知错误");
					}
					return response;
				} catch (Exception e1) {

				}
			}
			return null;
		}
	}

	/**
	 * 传输数据
	 * 
	 * @param params
	 * @return
	 */
	private String post(String urlStr, Map<String, String> params)
			throws ZmException {

		try {

			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams, 5000);
			HttpConnectionParams.setSoTimeout(httpParams, 10000);
			HttpClient hc = new DefaultHttpClient(httpParams);
			HttpPost post = new HttpPost(urlStr);
			post.addHeader("User-Agent", BaseRequest.USERAGENT);// 增加使用代理的头信息，便于struts知道是android客户端过来的请求
			writeSessionId(post);
			//
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			if (null != params && !params.isEmpty()) {
				for (Entry<String, String> entry : params.entrySet()) {
					BasicNameValuePair pair = new BasicNameValuePair(
							entry.getKey(), entry.getValue());
					nameValuePairs.add(pair);
					// Log.i(LOG_TAG,
					// "post data: key:"+entry.getKey()+" value:"+entry.getValue());
				}
			}
			// 创建一个请求头的字段，比如content-type,text/plain

			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
					nameValuePairs,"utf-8");
			post.setEntity(entity);

			HttpResponse response = hc.execute(post);
			int code = response.getStatusLine().getStatusCode();
			// Log.i(LOG_TAG, "response code:"+code);
			readSessionId(response);

			if (code == 200 || code==500) {// 正常
				InputStream in = response.getEntity().getContent();
				String result = readString(in, "UTF-8");
				return result;
			} else if (code >= 300 && code < 400) {// 30x 跳转
				// Header header = post.getResponseHeader("location");
				Header header = post.getFirstHeader("Location");
				if (header != null) {
					String newuri = header.getValue();
					return post(newuri, null);
				}
			} else if (code >= 400 && code < 500) {// 40x权限不够
				throw new ZmException(BaseResponse.CODE_40x);
			} else if (code >= 500 && code < 600) {// 50x系统出错
				throw new ZmException(BaseResponse.CODE_50x);
			}
		} catch (Exception e) {
			if (e instanceof ZmException) {
				throw (ZmException) e;
			}
		}
		throw new ZmException(BaseResponse.CODE_NETWORK_ERROR);

	}

	/**
	 * 读取cookie
	 * 
	 * @param response
	 */
	private void readSessionId(HttpResponse response) {
		Header header = response.getFirstHeader("Set-Cookie");
		if (header != null) {
			try {
				FileUtils.writeStringToFile(new File("cookie"),
						header.getValue(), false);
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 写入cookie
	 * 
	 * @param post
	 */
	private void writeSessionId(HttpPost post) {
		try {
			String cookies = FileUtils.readFileToString(new File("cookie"));
			if (cookies != null && cookies.length() > 0) {
				post.addHeader("cookie", cookies);

			}
		} catch (IOException e) {

		}
	}

	protected String readString(InputStream in, String charset)
			throws IOException {
		byte[] data = new byte[1024];
		int length = 0;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		while ((length = in.read(data)) != -1) {
			bout.write(data, 0, length);
		}
		return new String(bout.toByteArray(), charset);
	}
}

