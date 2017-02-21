package com.cn.hnust.service.wx.enums;
/**
* @author zn
* @version ����ʱ�䣺2017��2��20�� ����7:56:56
* ��˵��
*/
public enum WxSendType {

	text("com.cn.hnust.service.wx.msgsend.impl.TextSend"),
	voice(""),
	vedio(""),
	image(""),
	event(""),
	;
	
	
	private String className;
	
	private WxSendType(String className) {
		setClassName(className);
	}

	/**
	 * ��ȡ className
	 * @return the className className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * ���� className
	 * @param className the className to set className
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
}
