package com.cn.hnust.service.wx.msgsend.impl;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.TextMessage;
import com.cn.hnust.service.wx.msgsend.ResponseMessageService;

/**
* @author zn
* @version 创建时间：2017年2月21日 下午5:26:42
* 类说明
*/
@Service
public class JokeSend implements ResponseMessageService {

	@Override
	public TextMessage messageResponse(TextMessage textMessage) {
		
		return textMessage;
	}

}
