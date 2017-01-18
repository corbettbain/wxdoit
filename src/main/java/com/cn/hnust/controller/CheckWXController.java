package com.cn.hnust.controller;

import java.util.Date;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.service.WXCheckService;
import com.cn.hnust.service.WXMessageService;
import com.cn.hnust.wxmessages.WxMessagesUtils;

/**
 * @author zn
 * @version ����ʱ�䣺2017��1��14�� ����12:15:06 ��˵��
 */
@Controller
@RequestMapping("/wx")
public class CheckWXController {

	@Inject
	private WXCheckService wXCheckService;

	@Inject
	private WXMessageService wXMessageService;

	// @RequestMapping("/checkwx")
	// @ResponseBody
	// public Long checkwx(String signature,String timestamp,String nonce,String
	// echostr){
	//
	// Boolean flg = wXCheckService.checkWX(signature, timestamp,
	// nonce,echostr);
	// if (flg) {
	// System.out.println(echostr);
	// return Long.valueOf(echostr);
	// }else {
	// return null;
	// }
	// }
	//

	@RequestMapping("/checkwx")
	@ResponseBody
	public String checkwx(HttpServletRequest request, HttpServletResponse response) {

		try {
			Map<String, String> map = WxMessagesUtils.messageToMap(request);
			String toUserName = map.get("ToUserName");
			String content = map.get("Content");
			String fromUserName = map.get("FromUserName");
			String msgType = map.get("MsgType");
			String message = null;
			if ("text".equals(msgType)) {
				com.cn.hnust.pojo.TextMessage textMessage = new com.cn.hnust.pojo.TextMessage();

				textMessage.setFromUserName(toUserName);
				textMessage.setToUserName(fromUserName);
				textMessage.setMsgType("text");
				textMessage.setContent("�����͵���Ϣ��" + content + "(-- ��Ϣ�����������ı���)");
				textMessage.setCreateTime(new Date().getTime());
				message = WxMessagesUtils.textToXml(textMessage);

				System.out.println(message);
			}

			return message;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
