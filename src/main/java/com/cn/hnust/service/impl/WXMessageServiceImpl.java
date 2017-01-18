package com.cn.hnust.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.WeathersForDays;
import com.cn.hnust.service.WXMessageService;

/**
 * @author zn
 * @version 创建时间：2017年1月18日 下午4:13:54 类说明
 */
@Service
public class WXMessageServiceImpl implements WXMessageService {

	@Override
	public WeathersForDays getWeather(String city) throws IOException {
		HttpURLConnection connection = null;
		BufferedReader read = null;
		String rs = null;
		InputStream in = null;
		try {
			// String s1=URLEncoder.encode(city, "utf-8");
			// URL url = new URL(WEATHER_URL+s1);
			//
			// String city1 = "崇仁";
			String s1 = URLEncoder.encode(city, "utf-8");
			URL url = new URL("http://api.jisuapi.com/weather/query?appkey=a5ec7b9e7a5c3e2a&city=" + s1);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			connection.connect();
			in = connection.getInputStream();
			read = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String lists = null;
			StringBuffer sBuffer = new StringBuffer();
			while ((lists = read.readLine()) != null) {
				sBuffer.append(lists);
			}
			rs = sBuffer.toString();
			System.out.println(rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (read != null) {
				read.close();
			}
			if (connection != null) {
				connection.disconnect();
			}
			if (in != null) {
				in.close();
			}
		}
		return null;
	}

}
