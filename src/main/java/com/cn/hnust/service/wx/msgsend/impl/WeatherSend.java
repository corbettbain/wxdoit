package com.cn.hnust.service.wx.msgsend.impl;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.service.wx.msgsend.ResponseMessageService;

/**
* @author zn
* @version 创建时间：2017年2月21日 下午5:35:08
* 类说明
*/
@Service
public class WeatherSend implements ResponseMessageService {

	@Override
	public TextMessage messageResponse(TextMessage textMessage) {
		// TODO Auto-generated method stub
		return textMessage;
	}

}
