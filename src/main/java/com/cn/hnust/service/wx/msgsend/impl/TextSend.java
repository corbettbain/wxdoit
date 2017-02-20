package com.cn.hnust.service.wx.msgsend.impl;

import java.io.IOException;

import javax.inject.Inject;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.pojo.weather.WeatherResult;
import com.cn.hnust.service.WeatherService;
import com.cn.hnust.service.joke.factory.Gets;
import com.cn.hnust.service.joke.factory.JokeFactory;
import com.cn.hnust.service.joke.impl.GetJoke;
import com.cn.hnust.service.wx.msgsend.MessagesSend;
import com.cn.hnust.wxmessages.WxMessagesUtils;

/**
* @author zn
* @version 创建时间：2017年2月20日 下午7:36:15
* 类说明
*/
public class TextSend implements MessagesSend{

	@Inject
	private WeatherService weatherService;
	
	@Override
	public TextMessage send(TextMessage textMessage) {
		textMessage.setMsgType(WxMessagesUtils.TEXT);
		String content = textMessage.getContent();
		String wxcontent = null;
		String toUserName = textMessage.getFromUserName();
		textMessage.setFromUserName(textMessage.getToUserName());
		textMessage.setToUserName(toUserName);
		int suffx = content.indexOf("天气");
		if (suffx>0) {
			String addr = content.substring(0, content.length()-2);
			WeatherResult weatherResult = null;
			try {
				weatherResult = weatherService.getWeather(addr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			wxcontent = weatherResult.getResult().getCity()+":"+weatherResult.getResult().getWeather()+",风力:"+weatherResult.getResult().getWindpower();
					
		}else {
			if (content.equals("帮助")) {
				
				wxcontent = textMenu();
				
				
			}else if(content.equals("笑话")){
				JokeFactory jokeFactory = new Gets();
				GetJoke getJoke = jokeFactory.getJokeResource();
				wxcontent = getJoke.getRandJoke().getContent();
									
			}else {
				
				wxcontent = "您发送的消息是" + content + "(欢迎关注本订阅号,您还可以发送'笑话'关键字获取随机笑话哦,为您的聊天增添乐趣:-{))";
				
			}			
		}	
		textMessage.setContent(wxcontent);
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
