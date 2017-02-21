package com.cn.hnust.service.wx.enums;

import com.cn.hnust.service.WeatherService;
import com.cn.hnust.service.impl.WeatherServiceImpl;

/**
* @author zn
* @version ����ʱ�䣺2017��2��21�� ����5:04:07
* ��˵��
*/
public enum SystemDefaultToUserSendToResponseType {

	help("����","helpSend"),
	joke("Ц��","jokeSend"),
	weather("����","weatherSend"),
	other("����","otherSend")
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
