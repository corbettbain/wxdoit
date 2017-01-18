package com.cn.hnust.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Service;

import com.cn.hnust.service.WXMessageOutPutService;
import com.cn.hnust.service.WXMessageService;
import com.cn.hnust.wxmessages.WxMessagesUtils;

/**
 * @author zn
 * @version 创建时间：2017年1月18日 下午8:00:55 类说明
 */
@Service
public class WXMessageOutPutServiceImpl implements WXMessageOutPutService {
	
	@Inject
	private WXMessageService wXMessageService;

	@Override
	public String outPutToWx(HttpServletRequest request) throws IOException, DocumentException {
		Map<String, String> map = WxMessagesUtils.messageToMap(request);
		String toUserName = map.get("ToUserName");
		String content = map.get("Content");
		String fromUserName = map.get("FromUserName");
		String msgType = map.get("MsgType");
		String event = map.get("Event");
		String message = null;
		if ("text".equals(msgType)) {
			com.cn.hnust.pojo.TextMessage textMessage = new com.cn.hnust.pojo.TextMessage();

			int suffx = content.indexOf("天气");
			if (suffx>0) {
				String addr = content.substring(0, content.length()-2);
				wXMessageService.getWeather(addr);
			}

			textMessage.setFromUserName(toUserName);
			textMessage.setToUserName(fromUserName);
			textMessage.setMsgType("text");
			textMessage.setContent("您发送的消息是" + content + "(-- 消息来自周宁爱的抱抱)");
			textMessage.setCreateTime(new Date().getTime());
			message = WxMessagesUtils.textToXml(textMessage);
			System.out.println(message);
		}
		return message;
	}

}
