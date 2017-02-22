package com.cn.hnust.service.wx.msgsend.impl;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.service.wx.enums.WxSendType;
import com.cn.hnust.service.wx.msgsend.ResponseMessageService;

/**
* @author zn
* @version ����ʱ�䣺2017��2��21�� ����5:36:29
* ��˵��
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
		stringBuffer.append("��ӭ��ע������վ,�밴�ղ˵���ʾ���в���:").append("           ");
		stringBuffer.append("1.����ظ�,��ʼѧ��˵��С��Ϸ^.^").append("      ");
		stringBuffer.append("2.��ȡ��������,�ظ���ʽ:��ַ+'����'.����'��������'").append("      ");
		stringBuffer.append("3.��ȡЦ����ȫ,�ظ���ʽ:'Ц��'").append("      ");
		stringBuffer.append("���������ظ�'����'");
		return stringBuffer.toString();
	}
}
