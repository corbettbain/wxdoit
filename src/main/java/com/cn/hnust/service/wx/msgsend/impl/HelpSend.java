package com.cn.hnust.service.wx.msgsend.impl;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.service.wx.enums.WxSendType;
import com.cn.hnust.service.wx.msgsend.ResponseMessageService;

/**
* @author zn
* @version 创建时间：2017年2月21日 下午5:36:29
* 类说明
*/
@Service
public class HelpSend implements ResponseMessageService {

	@Override
	public TextMessage messageResponse(TextMessage textMessage) {
		// TODO Auto-generated method stub
		
		textMessage.setContent(textMenu());
		textMessage.setMsgType(WxSendType.text.toString());
		
		return textMessage;
	}

	
	private String textMenu(){
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("欢迎关注快乐驿站,请按照菜单提示进行操作:").append("           ");
		stringBuffer.append("1.任意回复,开始学你说话小游戏^.^").append("      ");
		stringBuffer.append("2.获取天气详情,回复格式:地址+'天气'.例如'崇仁天气'").append("      ");
		stringBuffer.append("3.获取笑话大全,回复格式:'笑话'").append("      ");
		stringBuffer.append("如需帮助请回复'帮助'");
		return stringBuffer.toString();
	}
}
