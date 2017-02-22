package com.cn.hnust.service.wx.msgsend.impl;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.pojo.weather.WeatherResult;
import com.cn.hnust.service.WeatherService;
import com.cn.hnust.service.wx.enums.WxSendType;
import com.cn.hnust.service.wx.msgsend.ResponseMessageService;

/**
* @author zn
* @version 创建时间：2017年2月21日 下午5:35:08
* 类说明
*/
@Service
public class WeatherSend implements ResponseMessageService {

	@Inject
	private WeatherService weatherService;
	
	@Override
	public TextMessage messageResponse(TextMessage textMessage) {


		String city = textMessage.getContent();
		WeatherResult weatherResult = null;
		try {
			weatherResult = weatherService.getWeather(city);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		textMessage.setContent(weatherResult.getResult().getCity()+":"+weatherResult.getResult().getWeather()+",风力:"+weatherResult.getResult().getWindpower());
		textMessage.setMsgType(WxSendType.text.toString());
		
		return textMessage;
	}

}
