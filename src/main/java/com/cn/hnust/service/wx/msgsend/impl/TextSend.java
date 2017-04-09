package com.cn.hnust.service.wx.msgsend.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.service.wx.enums.SystemDefaultToUserSendToResponseType;
import com.cn.hnust.service.wx.msgsend.ResponseMessageService;
import com.cn.hnust.service.wx.msgsend.TextSendAbstract;
import com.cn.hnust.utils.SpringContextUtil;
import com.cn.hnust.wxmessages.WxMessagesUtils;

/**
 * 
 * @author 周宁 - 2017年4月9日 - 下午8:20:13 - 项目:wxdoit - 包名:com.cn.hnust.service.wx.msgsend.impl
 *
 */
@Service
public class TextSend extends TextSendAbstract{

	@Override
	public TextMessage send(TextMessage textMessage) throws IOException {
		textMessage.setMsgType(WxMessagesUtils.TEXT);
		String contents = textMessage.getContent();
		String beanName = "";
		String content = "";
		if (contents.indexOf(" ") > 0) {
			content = contents.substring(0,contents.indexOf(" "));
			beanName = contents.substring(contents.indexOf(" ") + 1, contents.length());
		}else {
			beanName = contents;
			content = contents;
		}
		
		textMessage.setContent(content);
		
		SystemDefaultToUserSendToResponseType sendToResponseType = 
				SystemDefaultToUserSendToResponseType.getEnumByValue(beanName);

		if (sendToResponseType == null) {
			return null;
		}
		
		ResponseMessageService responseMessageService = 
				SpringContextUtil.getBean(sendToResponseType.getBeanName());
		
		 TextMessage messageSend = responseMessageService.messageResponse(textMessage);
		
		return messageSend;
	}

}
