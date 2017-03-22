package com.cn.hnust.service.wx.msgsend.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.service.joke.impl.GetJoke;
import com.cn.hnust.service.wx.enums.WxSendType;
import com.cn.hnust.service.wx.msgsend.ResponseMessageService;

/**
* @author zn
* @version ����ʱ�䣺2017��2��21�� ����5:26:42
* ��˵��
*/
@Service
public class JokeSend implements ResponseMessageService {


	@Inject
	private GetJoke getJoke;
	
	@Override
	public TextMessage messageResponse(TextMessage textMessage) {
		
		textMessage.setContent(getJoke.getRandJoke().getContent());
		textMessage.setMsgType(WxSendType.text.toString());
		
		return textMessage;
	}

}