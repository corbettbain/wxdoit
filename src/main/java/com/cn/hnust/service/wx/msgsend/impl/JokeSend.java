package com.cn.hnust.service.wx.msgsend.impl;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.service.wx.msgsend.ResponseMessageService;

/**
* @author zn
* @version ����ʱ�䣺2017��2��21�� ����5:26:42
* ��˵��
*/
@Service
public class JokeSend implements ResponseMessageService {

	@Override
	public TextMessage messageResponse(TextMessage textMessage) {
		
		return textMessage;
	}

}
