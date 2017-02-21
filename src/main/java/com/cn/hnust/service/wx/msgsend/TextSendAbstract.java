package com.cn.hnust.service.wx.msgsend;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.service.WeatherService;
import com.cn.hnust.service.joke.factory.JokeFactory;

/**
* @author zn
* @version 创建时间：2017年2月21日 上午9:48:42
* 类说明
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
	 * 获取 weatherService
	 * @return the weatherService weatherService
	 */
	public WeatherService getWeatherService() {
		return weatherService;
	}

	/**
	 * 设置 weatherService
	 * @param weatherService the weatherService to set weatherService
	 */
	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}

	/**
	 * 获取 jokeFactory
	 * @return the jokeFactory jokeFactory
	 */
	public JokeFactory getJokeFactory() {
		return jokeFactory;
	}

	/**
	 * 设置 jokeFactory
	 * @param jokeFactory the jokeFactory to set jokeFactory
	 */
	public void setJokeFactory(JokeFactory jokeFactory) {
		this.jokeFactory = jokeFactory;
	}

	
	
}
