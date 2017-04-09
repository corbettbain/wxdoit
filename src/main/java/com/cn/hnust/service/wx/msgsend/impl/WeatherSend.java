package com.cn.hnust.service.wx.msgsend.impl;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.pojo.weather.WeatherResult;
import com.cn.hnust.service.weather.WeatherService;
import com.cn.hnust.service.wx.enums.WxSendType;
import com.cn.hnust.service.wx.msgsend.ResponseMessageService;

/**
* @author zn
* @version ����ʱ�䣺2017��2��21�� ����5:35:08
* ��˵��
*/
@Service
public class WeatherSend implements ResponseMessageService {

	@Inject
	private WeatherService weatherService;
	
	@Override
	public TextMessage messageResponse(TextMessage textMessage) throws IOException {


		String city = textMessage.getContent();
		WeatherResult weatherResult = null;

		weatherResult = weatherService.getWeather(city);

		textMessage.setContent(weatherResult.getResult().getCity()+":"+weatherResult.getResult().getWeather()+",风力:"+weatherResult.getResult().getWindpower());
		textMessage.setMsgType(WxSendType.text.toString());
		
		return textMessage;
	}

}
