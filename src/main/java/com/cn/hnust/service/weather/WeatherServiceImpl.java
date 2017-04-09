package com.cn.hnust.service.weather;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cn.hnust.pojo.weather.WeatherResult;
import com.cn.hnust.wxmessages.WxMessagesUtils;

/**
 * @author zn
 * @version ����ʱ�䣺2017��1��18�� ����4:13:54 ��˵��
 */
@Service
public class WeatherServiceImpl implements WeatherService {

	@Override
	public WeatherResult getWeather(String city) throws IOException {
		String results = null;
		WeatherResult weatherResult = null;
		try {
//			String s1 = URLEncoder.encode(city, "utf-8");
			
			String strUrl = "http://api.jisuapi.com/weather/query";
			
			Map<String, Object > param = new HashMap<String, Object>();
			param.put("appkey", "a5ec7b9e7a5c3e2a");
			param.put("city", city);
			
			String method = "GET";

			results = WxMessagesUtils.getUrlData(strUrl, param, method, null);
			
			JSONObject weather = JSONObject.parseObject(results);
			
			weatherResult = JSONObject.toJavaObject(weather, WeatherResult.class);
			System.out.println(weather);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		return weatherResult;
	}

}
