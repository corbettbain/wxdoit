package com.cn.hnust.service.wx.msgsend;

import com.cn.hnust.pojo.TextMessage;
/**
* @author zn
* @version 创建时间：2017年2月21日 下午5:23:01
* 类说明
*/
public interface ResponseMessageService {

	TextMessage messageResponse(TextMessage textMessage);
}
