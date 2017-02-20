package com.cn.hnust.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.pojo.weather.WeatherResult;
import com.cn.hnust.service.WXMessageOutPutService;
import com.cn.hnust.service.WeatherService;
import com.cn.hnust.service.joke.factory.JokeFactory;
import com.cn.hnust.service.joke.impl.GetJoke;
import com.cn.hnust.service.wx.enums.WxSendType;
import com.cn.hnust.service.wx.msgsend.MessagesSend;
import com.cn.hnust.service.wx.msgsend.MessagesSendFactpry;
import com.cn.hnust.service.wx.msgsend.impl.MessagesSendFactpryImpl;
import com.cn.hnust.wxmessages.WxMessagesUtils;

/**
 * @author zn
 * @version 创建时间：2017年1月18日 下午8:00:55 类说明
 */
@Service
public class WXMessageOutPutServiceImpl implements WXMessageOutPutService {
	
	@Inject
	private WeatherService wXMessageService;
	
	@Inject
	private JokeFactory jokeFactory;

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
		String wxcontent = null;
		String sendMsgType = null;
		TextMessage textMessage = null;
		
		long createTime = new Date().getTime();
		
		textMessage = new TextMessage(toUserName, fromUserName, sendMsgType, content, createTime);
//		switch (msgType) {
//		case WxMessagesUtils.TEXT:
//			textMessage = msgTypeByText(content, toUserName, fromUserName,wxcontent,sendMsgType,textMessage,createTime);
//			break;
//		case WxMessagesUtils.EVENT:
//			textMessage = msgTypeByEvent( content, toUserName, fromUserName,map,wxcontent,sendMsgType,textMessage,createTime);
//			break;
//		default:
//			break;
//		}
	
		MessagesSend messagesSend = (MessagesSend) messagesSendFactpry.createMessage(msgType);
		textMessage = messagesSend.send(textMessage);
		message = WxMessagesUtils.textToXml(textMessage);
		return message;
	}

	
	private TextMessage msgTypeByEvent(String content,String toUserName,String fromUserName,
			Map<String, String> map, String wxcontent, String sendMsgType, 
			TextMessage textMessage, long createTime){
		
		String eventType = map.get("Event");
		switch (eventType) {
		case WxMessagesUtils.SUBSCRIBE:
			sendMsgType = WxMessagesUtils.TEXT;
			wxcontent = textMenu();
			textMessage = new TextMessage(toUserName, fromUserName, sendMsgType, wxcontent, createTime);		
			break;
		default:
			break;
		}
		
		return textMessage;
		
	}
	
	private String textMenu(){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("欢迎关注快乐驿站,请按照菜单提示进行操作:").append("           ");
		stringBuffer.append("1.任意回复,开始学你说话小游戏^.^").append("      ");
		stringBuffer.append("2.获取天气详情,回复格式:地址+'天气'.例如'崇仁天气'").append("      ");
		stringBuffer.append("3.获取笑话大全,回复格式:'笑话'").append("      ");
		stringBuffer.append("如需帮助请回复'帮助'");
		return stringBuffer.toString();
	}
}
