package com.cn.hnust.service.wx.msgsend;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.service.WeatherService;
import com.cn.hnust.service.joke.factory.JokeFactory;

/**
* @author zn
* @version ����ʱ�䣺2017��2��21�� ����9:48:42
* ��˵��
*/
public class TextSendAbstract implements MessagesSend {

	private WeatherService weatherService;
	private JokeFactory jokeFactory;
	
	@Override
	public TextMessage send(TextMessage textMessage) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ��ȡ weatherService
	 * @return the weatherService weatherService
	 */
	public WeatherService getWeatherService() {
		return weatherService;
	}

	/**
	 * ���� weatherService
	 * @param weatherService the weatherService to set weatherService
	 */
	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	/**
	 * ��ȡ jokeFactory
	 * @return the jokeFactory jokeFactory
	 */
	public JokeFactory getJokeFactory() {
		return jokeFactory;
	}

	/**
	 * ���� jokeFactory
	 * @param jokeFactory the jokeFactory to set jokeFactory
	 */
	public void setJokeFactory(JokeFactory jokeFactory) {
		this.jokeFactory = jokeFactory;
	}

	
	
}
