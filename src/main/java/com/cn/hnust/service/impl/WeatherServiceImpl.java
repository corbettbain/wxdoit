package com.cn.hnust.service.impl;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.pojo.weather.WeathersForDays;
import com.cn.hnust.service.WeatherService;
import com.cn.hnust.wxmessages.WxMessagesUtils;

/**
 * @author zn
 * @version 创建时间：2017年1月18日 下午4:13:54 类说明
 */
@Service
public class WeatherServiceImpl implements WeatherService {

	@Override
	public com.cn.hnust.pojo.weather.WeathersForDays getWeather(String city) throws IOException {
		String results = null;
		WeathersForDays weathersForDays = null;
		try {
//			String s1 = URLEncoder.encode(city, "utf-8");
			
			String strUrl = "http://api.jisuapi.com/weather/query";
			
			Map<String, String > param = new HashMap<String, String>();
			param.put("appkey", "a5ec7b9e7a5c3e2a");
			param.put("city", city);
			
			String method = "GET";

			results = WxMessagesUtils.getUrlData(strUrl, param, method, null);
			
			JSONObject weather = JSONObject.parseObject(results);
			
			weathersForDays = JSONObject.toJavaObject(weather.getJSONObject("result"), WeathersForDays.class);
			System.out.println(weather);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return weathersForDays;
	}

}
