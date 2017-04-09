package com.cn.hnust.service.wx.msgsend.impl;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.service.wx.enums.WxSendType;
import com.cn.hnust.service.wx.msgsend.ResponseMessageService;

@Service
public class OtherSend implements ResponseMessageService {

	@Override
	public TextMessage messageResponse(TextMessage textMessage) {
		
		String content = textMessage.getContent();
		textMessage.setContent("你发送的信息为" + content + "!");
		textMessage.setMsgType(WxSendType.text.toString());
		return textMessage;
	}

}
