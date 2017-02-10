package com.cn.hnust.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.pojo.joke.Joke;
import com.cn.hnust.pojo.joke.JokeResult;
import com.cn.hnust.pojo.weather.WeatherResult;
import com.cn.hnust.pojo.weather.WeathersForDays;
import com.cn.hnust.service.JokeService;
import com.cn.hnust.service.WXMessageOutPutService;
import com.cn.hnust.service.WeatherService;
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
	private JokeService jokeService;

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
		switch (msgType) {
		case WxMessagesUtils.TEXT:
			textMessage = msgTypeByText(content, toUserName, fromUserName,wxcontent,sendMsgType,textMessage,createTime);
			break;
		case WxMessagesUtils.EVENT:
			textMessage = msgTypeByEvent( content, toUserName, fromUserName,map,wxcontent,sendMsgType,textMessage,createTime);
			break;
		default:
			break;
		}
		message = WxMessagesUtils.textToXml(textMessage);
		return message;
	}

	
	private TextMessage msgTypeByText(String content,String toUserName,String fromUserName, 
			String wxcontent, String sendMsgType, TextMessage textMessage, 
			long createTime) throws IOException{

		sendMsgType = WxMessagesUtils.TEXT;
		int suffx = content.indexOf("����");
		if (suffx>0) {
			sendMsgType = WxMessagesUtils.TEXT;
			String addr = content.substring(0, content.length()-2);
			WeatherResult weatherResult = wXMessageService.getWeather(addr);		
			wxcontent = weatherResult.getResult().getCity()+":"+weatherResult.getResult().getWeather()+",����:"+weatherResult.getResult().getWindpower();
			textMessage = new TextMessage(toUserName, fromUserName, WxMessagesUtils.TEXT, wxcontent, createTime);		
		}else {
			if (content.equals("����")) {
				
				wxcontent = textMenu();
				textMessage = new TextMessage(toUserName, fromUserName, sendMsgType, wxcontent, createTime);
				
			}else if(content.equals("Ц��")){
				JokeResult jokeResult = jokeService.getJoke();
				List<Joke> jokes = jokeResult.getResult().getList();
				wxcontent = "";
				for (Joke joke : jokes) {
					wxcontent += joke.getContent()+";";
				}
				textMessage = new TextMessage(toUserName, fromUserName, sendMsgType, wxcontent, createTime);						
			}else {
				
				wxcontent = "�����͵���Ϣ��" + content + "(��ӭ��ע�����ĺ�,�������Է���'Ц��'�ؼ��ֻ�ȡ���Ц��Ŷ,Ϊ��������������Ȥ:-{))";
				textMessage = new TextMessage(toUserName, fromUserName, sendMsgType, wxcontent, createTime);
			}			
		}	
		return textMessage;
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
