package com.cn.hnust.service;
import java.io.IOException;
/**
* @author zn
* @version ����ʱ�䣺2017��1��18�� ����4:08:43
* ��˵��
*/
public interface WeatherService {

	com.cn.hnust.pojo.weather.WeathersForDays getWeather(String city) throws IOException;
}
