package com.cn.hnust.service.wx.msgsend.impl;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.service.wx.enums.WxSendType;
import com.cn.hnust.service.wx.msgsend.ResponseMessageService;

/**
 * 
 * @author 周宁 - 2017年4月9日 - 下午8:55:23 - 项目:wxdoit - 包名:com.cn.hnust.service.wx.msgsend.impl
 *
 */
@Service
public class HelpSend implements ResponseMessageService {

	@Override
	public TextMessage messageResponse(TextMessage textMessage) {
		// TODO Auto-generated method stub
		
		textMessage.setContent(textMenu());
		textMessage.setMsgType(WxSendType.text.toString());
		
		return textMessage;
	}

	
	private String textMenu(){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("格式为:地名+ 空格 + 天气-查询天气");
		return stringBuffer.toString();
	}
}
