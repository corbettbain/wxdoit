package com.cn.hnust.service.wx.msgsend.impl;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.pojo.weather.WeatherResult;
import com.cn.hnust.service.WeatherService;
import com.cn.hnust.service.joke.factory.JokeFactory;
import com.cn.hnust.service.joke.impl.GetJoke;
import com.cn.hnust.service.wx.enums.SystemDefaultToUserSendToResponseType;
import com.cn.hnust.service.wx.msgsend.MessagesSend;
import com.cn.hnust.service.wx.msgsend.ResponseMessageService;
import com.cn.hnust.service.wx.msgsend.TextSendAbstract;
import com.cn.hnust.utils.SpringContextUtil;
import com.cn.hnust.wxmessages.WxMessagesUtils;

/**
* @author zn
* @version ����ʱ�䣺2017��2��20�� ����7:36:15
* ��˵��
*/
@Service
public class TextSend extends TextSendAbstract{

	private WeatherService weatherService;
	private JokeFactory jokeFactory;
	
	@Override
	public TextMessage send(TextMessage textMessage) {
		textMessage.setMsgType(WxMessagesUtils.TEXT);
		String content = textMessage.getContent();
		/**
		 * �ж��û������Ƿ�Ϊö���ж��������
		 */
		SystemDefaultToUserSendToResponseType sendToResponseType = 
				SystemDefaultToUserSendToResponseType.getEnumByValue(content);
		if (sendToResponseType == null) {
			int suffx = content.indexOf(SystemDefaultToUserSendToResponseType.
					weather.getKeyWord());
			if (suffx > 0) {
				sendToResponseType = SystemDefaultToUserSendToResponseType.weather;
			}else {
				sendToResponseType = SystemDefaultToUserSendToResponseType.other;
			}
		}
		
		/**
		 * ��spring �����л�ȡbean
		 */
		ResponseMessageService responseMessageService = 
				SpringContextUtil.getBean(sendToResponseType.getBeanName());
		
		 TextMessage messageSend = responseMessageService.messageResponse(textMessage);
		
//		int suffx = content.indexOf("����");
//		if (suffx>0) {
//			String addr = content.substring(0, content.length()-2);
//			WeatherResult weatherResult = null;
//			try {
//				weatherResult = weatherService.getWeather(addr);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}		
//			wxcontent = weatherResult.getResult().getCity()+":"+weatherResult.getResult().getWeather()+",����:"+weatherResult.getResult().getWindpower();
//					
//		}else {
//			if (content.equals("����")) {
//				
//				wxcontent = textMenu();
//				
//				
//			}else if(content.equals("Ц��")){
//				wxcontent = jokeFactory.getRandJoke().getContent();
//									
//			}else {
//				
//				wxcontent = "�����͵���Ϣ��" + content + "(��ӭ��ע�����ĺ�,�������Է���'Ц��'�ؼ��ֻ�ȡ���Ц��Ŷ,Ϊ��������������Ȥ:-{))";
//				
//			}			
//		}	
//		textMessage.setContent(wxcontent);
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

	
	public void setJokeFactory(JokeFactory jokeFactory) {
		this.jokeFactory = jokeFactory;
	}
	
	
	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}
}
