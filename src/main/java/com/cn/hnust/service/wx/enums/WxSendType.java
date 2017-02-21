package com.cn.hnust.service.wx.enums;
/**
* @author zn
* @version 创建时间：2017年2月20日 下午7:56:56
* 类说明
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
	 * 获取 className
	 * @return the className className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * 设置 className
	 * @param className the className to set className
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	
	
	
}
