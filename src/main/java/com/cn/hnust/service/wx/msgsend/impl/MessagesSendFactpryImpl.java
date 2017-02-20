package com.cn.hnust.service.wx.msgsend.impl;

import com.cn.hnust.service.wx.enums.WxSendType;
import com.cn.hnust.service.wx.msgsend.MessagesSend;
import com.cn.hnust.service.wx.msgsend.MessagesSendFactpry;

/**
* @author zn
* @version 创建时间：2017年2月20日 下午8:51:46
* 类说明
*/
public class MessagesSendFactpryImpl implements MessagesSendFactpry {

	@Override
	public Object createMessage(String className) {
		MessagesSend messagesSend = null;
		try {
			messagesSend = (MessagesSend) Class.forName(WxSendType.valueOf(className).getClassName()).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messagesSend;
	}

}
