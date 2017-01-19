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
 * @version ����ʱ�䣺2017��1��18�� ����8:00:55 ��˵��
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

			int suffx = content.indexOf("����");
			if (suffx>0) {
				String addr = content.substring(0, content.length()-2);
				wXMessageService.getWeather(addr);
			}

			textMessage.setFromUserName(toUserName);
			textMessage.setToUserName(fromUserName);
			textMessage.setMsgType("text");
			textMessage.setContent("�����͵���Ϣ��" + content + "(-- ��Ϣ�����������ı���)");
			textMessage.setCreateTime(new Date().getTime());
			message = WxMessagesUtils.textToXml(textMessage);
			System.out.println(message);
		}
		return message;
	}

}
