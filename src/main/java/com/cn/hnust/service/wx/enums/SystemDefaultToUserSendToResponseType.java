package com.cn.hnust.service.wx.enums;

import com.cn.hnust.service.WeatherService;
import com.cn.hnust.service.impl.WeatherServiceImpl;

/**
* @author zn
* @version 创建时间：2017年2月21日 下午5:04:07
* 类说明
*/
public enum SystemDefaultToUserSendToResponseType {

	help("帮助","helpSend"),
	joke("笑话","jokeSend"),
	weather("天气","weatherSend"),
	other("其他","otherSend")
	;
	
	private String beanName;
	
	private String keyWord;
	
	private SystemDefaultToUserSendToResponseType(String keyWord ,String beanName) {
		setBeanName(beanName);
		setKeyWord(keyWord);
	}
	
	public static SystemDefaultToUserSendToResponseType getEnumByValue(String value){
		
		for (SystemDefaultToUserSendToResponseType send : SystemDefaultToUserSendToResponseType.values()) {
			if (send.getBeanName().equals(value) || send.getKeyWord().equals(value)) {
				return send;
			}
		}
		
		return null;
	}
	
	public String getKeyWord() {
		return keyWord;
	}



	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}



	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
	
}
