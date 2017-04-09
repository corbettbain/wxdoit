package com.cn.hnust.service.wx.msgsend;

import java.io.IOException;

import com.cn.hnust.pojo.TextMessage;
/**
 * 
 * @author 周宁 - 2017年4月9日 - 下午8:51:35 - 项目:wxdoit - 包名:com.cn.hnust.service.wx.msgsend
 *
 */
public interface ResponseMessageService {

	TextMessage messageResponse(TextMessage textMessage) throws IOException;
}
