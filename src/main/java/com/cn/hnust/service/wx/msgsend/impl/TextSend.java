package com.cn.hnust.service.wx.msgsend.impl;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.service.WeatherService;
import com.cn.hnust.service.joke.factory.JokeFactory;
import com.cn.hnust.service.wx.enums.SystemDefaultToUserSendToResponseType;
import com.cn.hnust.service.wx.msgsend.ResponseMessageService;
import com.cn.hnust.service.wx.msgsend.TextSendAbstract;
import com.cn.hnust.utils.SpringContextUtil;
import com.cn.hnust.wxmessages.WxMessagesUtils;

/**
* @author zn
* @version 创建时间：2017年2月20日 下午7:36:15
* 类说明
*/
@Service
public class TextSend extends TextSendAbstract{

	@SuppressWarnings("unused")
	private WeatherService weatherService;
	@SuppressWarnings("unused")
	private JokeFactory jokeFactory;
	
	@Override
	public TextMessage send(TextMessage textMessage) {
		textMessage.setMsgType(WxMessagesUtils.TEXT);
		String content = textMessage.getContent();
		/**
		 * 判断用户发送是否为枚举中定义的类型
		 */
		SystemDefaultToUserSendToResponseType sendToResponseType = 
				SystemDefaultToUserSendToResponseType.getEnumByValue(content);
		if (sendToResponseType == null) {
			int suffx = content.indexOf(SystemDefaultToUserSendToResponseType.
					weather.getKeyWord());
			if (suffx > 0) {
				String addr = content.substring(0, content.length()-2);
				textMessage.setContent(addr);
				sendToResponseType = SystemDefaultToUserSendToResponseType.weather;
			}else {
				sendToResponseType = SystemDefaultToUserSendToResponseType.other;
			}
		}
		
		/**
		 * 从spring 容器中获取bean
		 */
		ResponseMessageService responseMessageService = 
				SpringContextUtil.getBean(sendToResponseType.getBeanName());
		
		 TextMessage messageSend = responseMessageService.messageResponse(textMessage);
		
//		int suffx = content.indexOf("天气");
//		if (suffx>0) {
//			String addr = content.substring(0, content.length()-2);
//			WeatherResult weatherResult = null;
//			try {
//				weatherResult = weatherService.getWeather(addr);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}		
//			wxcontent = weatherResult.getResult().getCity()+":"+weatherResult.getResult().getWeather()+",风力:"+weatherResult.getResult().getWindpower();
//					
//		}else {
//			if (content.equals("帮助")) {
//				
//				wxcontent = textMenu();
//				
//				
//			}else if(content.equals("笑话")){
//				wxcontent = jokeFactory.getRandJoke().getContent();
//									
//			}else {
//				
//				wxcontent = "您发送的消息是" + content + "(欢迎关注本订阅号,您还可以发送'笑话'关键字获取随机笑话哦,为您的聊天增添乐趣:-{))";
//				
//			}			
//		}	
//		textMessage.setContent(wxcontent);
		return messageSend;
	}


	
	public void setJokeFactory(JokeFactory jokeFactory) {
		this.jokeFactory = jokeFactory;
	}
	
	
	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
}
