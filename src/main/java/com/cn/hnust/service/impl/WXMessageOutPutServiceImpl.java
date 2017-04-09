package com.cn.hnust.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.service.WXMessageOutPutService;
import com.cn.hnust.service.wx.msgsend.MessagesSendFactpry;
import com.cn.hnust.service.wx.msgsend.TextSendAbstract;
import com.cn.hnust.wxmessages.WxMessagesUtils;

/**
 * 
 * @author 周宁 - 2017年4月9日 - 下午8:52:26 - 项目:wxdoit - 包名:com.cn.hnust.service.impl
 *
 */
@Service
public class WXMessageOutPutServiceImpl implements WXMessageOutPutService {	

	@Inject
	private MessagesSendFactpry messagesSendFactpry;
	
	@Override
	public String outPutToWx(HttpServletRequest request) throws IOException, DocumentException {
		Map<String, String> map = WxMessagesUtils.messageToMap(request);
		String toUserName = map.get("ToUserName");
		String content = map.get("Content");
		String fromUserName = map.get("FromUserName");
		String msgType = map.get("MsgType");
		String message = null;
		String sendMsgType = null;
		TextMessage textMessage = null;
		
		long createTime = new Date().getTime();
		
		textMessage = new TextMessage(toUserName, fromUserName, sendMsgType, content, createTime);

		TextSendAbstract messagesSend =  messagesSendFactpry.createMessage(msgType);
		textMessage = messagesSend.send(textMessage);
		if (textMessage == null) {
			return null;
		}
		message = WxMessagesUtils.textToXml(textMessage);
		return message;
	}

	
//	private TextMessage msgTypeByEvent(String content,String toUserName,String fromUserName,
//			Map<String, String> map, String wxcontent, String sendMsgType, 
//			TextMessage textMessage, long createTime){
//		
//		String eventType = map.get("Event");
//		switch (eventType) {
//		case WxMessagesUtils.SUBSCRIBE:
//			sendMsgType = WxMessagesUtils.TEXT;
//			wxcontent = textMenu();
//			textMessage = new TextMessage(toUserName, fromUserName, sendMsgType, wxcontent, createTime);		
//			break;
//		default:
//			break;
//		}
//		
//		return textMessage;
//		
//	}
	
	
}
