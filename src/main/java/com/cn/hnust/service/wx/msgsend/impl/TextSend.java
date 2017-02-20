package com.cn.hnust.service.wx.msgsend.impl;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.pojo.weather.WeatherResult;
import com.cn.hnust.service.WeatherService;
import com.cn.hnust.service.joke.factory.JokeFactory;
import com.cn.hnust.service.joke.impl.GetJoke;
import com.cn.hnust.service.wx.msgsend.MessagesSend;
import com.cn.hnust.wxmessages.WxMessagesUtils;

/**
* @author zn
* @version ����ʱ�䣺2017��2��20�� ����7:36:15
* ��˵��
*/
@Service
public class TextSend implements MessagesSend{

	private WeatherService weatherService;
	private JokeFactory jokeFactory;
	
	@Override
	public TextMessage send(TextMessage textMessage) {
		textMessage.setMsgType(WxMessagesUtils.TEXT);
		String content = textMessage.getContent();
		String wxcontent = null;
		int suffx = content.indexOf("����");
		if (suffx>0) {
			String addr = content.substring(0, content.length()-2);
			WeatherResult weatherResult = null;
			try {
				weatherResult = weatherService.getWeather(addr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			wxcontent = weatherResult.getResult().getCity()+":"+weatherResult.getResult().getWeather()+",����:"+weatherResult.getResult().getWindpower();
					
		}else {
			if (content.equals("����")) {
				
				wxcontent = textMenu();
				
				
			}else if(content.equals("Ц��")){
				
									
			}else {
				
				wxcontent = "�����͵���Ϣ��" + content + "(��ӭ��ע�����ĺ�,�������Է���'Ц��'�ؼ��ֻ�ȡ���Ц��Ŷ,Ϊ��������������Ȥ:-{))";
				
			}			
		}	
		textMessage.setContent(wxcontent);
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


	/**
	 * @return the weatherService
	 */
	public WeatherService getWeatherService() {
		return weatherService;
	}


	/**
	 * @param weatherService the weatherService to set
	 */
	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}


	/**
	 * @return the jokeFactory
	 */
	public JokeFactory getJokeFactory() {
		return jokeFactory;
	}


	/**
	 * @param jokeFactory the jokeFactory to set
	 */
	public void setJokeFactory(JokeFactory jokeFactory) {
		this.jokeFactory = jokeFactory;
	}
	
	
	
}
