package com.cn.hnust.service.weather;
import java.io.IOException;

import com.cn.hnust.pojo.weather.WeatherResult;
/**
* @author zn
* @version ����ʱ�䣺2017��1��18�� ����4:08:43
* ��˵��
*/
public interface WeatherService {

	WeatherResult getWeather(String city) throws IOException;
}
