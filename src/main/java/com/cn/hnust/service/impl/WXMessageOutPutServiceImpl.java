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
 * @version ����ʱ�䣺2017��1��18�� ����8:00:55 ��˵��
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
		stringBuffer.append("��ӭ��ע������վ,�밴�ղ˵���ʾ���в���:").append("           ");
		stringBuffer.append("1.����ظ�,��ʼѧ��˵��С��Ϸ^.^").append("      ");
		stringBuffer.append("2.��ȡ��������,�ظ���ʽ:��ַ+'����'.����'��������'").append("      ");
		stringBuffer.append("3.��ȡЦ����ȫ,�ظ���ʽ:'Ц��'").append("      ");
		stringBuffer.append("���������ظ�'����'");
		return stringBuffer.toString();
	}
}
