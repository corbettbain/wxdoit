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
		textMessage.setContent("您发送的消息是" + content + "(欢迎关注本订阅号,您还可以发送'笑话'关键字获取随机笑话哦,为您的聊天增添乐趣:-{))");
		textMessage.setMsgType(WxSendType.text.toString());
		return textMessage;
	}

}
