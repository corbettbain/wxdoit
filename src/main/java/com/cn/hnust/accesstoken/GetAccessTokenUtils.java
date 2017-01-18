package com.cn.hnust.accesstoken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zn
 * @version 创建时间：2017年1月18日 下午9:03:51 类说明
 */
public class GetAccessTokenUtils {

	private static final String akurl = "https://api.weixin.qq.com/cgi-bin/token";

	public static JSONObject getAccessToken(String grant_type,String appid, String secret) throws IOException {
		JSONObject accesstokens = null;
		String param = getParam("grant_type:" + grant_type ,"appid:" + appid, "secret:" + secret);
		BufferedReader reader =null;
		InputStream inputStream = null;
		HttpURLConnection connection = null;
		try {
			URL url = new URL(akurl + param);

			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.connect();
			
			inputStream = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			String liString = null;
			StringBuffer stringBuffer = new StringBuffer();
			while ((liString = reader.readLine()) != null) {
				stringBuffer.append(liString);
			}
			JSONObject result = null;
			result = JSONObject.parseObject(stringBuffer.toString());
			accesstokens = result;
			if (!accesstokens.containsKey("access_token")) {
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (connection != null) {
				connection.disconnect();
			}
			if (inputStream != null) {
				inputStream.close();
			}
			if (reader != null) {
				reader.close();
			}
		}

		return accesstokens;
	}

	private static String getParam(Object... aObjects) {
		String param = null;
		if (aObjects.length == 0) {
			return null;
		}
		param = "?";
		for (Object object : aObjects) {
			String params = (String) object;
			param += params.split(":")[0] + "=" + params.split(":")[1] + "&";
		}
		param = param.substring(0, param.length() - 1);
		return param;
	}
}
