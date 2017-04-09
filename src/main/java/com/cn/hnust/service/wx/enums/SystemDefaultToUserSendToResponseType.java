package com.cn.hnust.service.wx.enums;

/**
 * 回复字典
 * @author 周宁 - 2017年4月7日 - 下午10:56:53 - 项目:wxdoit - 包名:com.cn.hnust.service.wx.enums
 *
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
