package com.cn.hnust.service;
import java.io.IOException;
/**
* @author zn
* @version 创建时间：2017年1月18日 下午4:08:43
* 类说明
*/
public interface WeatherService {

	com.cn.hnust.pojo.weather.WeathersForDays getWeather(String city) throws IOException;
}
