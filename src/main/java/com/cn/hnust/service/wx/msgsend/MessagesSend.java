package com.cn.hnust.service.wx.msgsend;

import java.io.IOException;

import com.cn.hnust.pojo.TextMessage;

/**
 * 消息发送接口
 * @author 周宁 - 2017年4月9日 - 下午8:26:23 - 项目:wxdoit - 包名:com.cn.hnust.service.wx.msgsend
 *
 */
public interface MessagesSend {

	public TextMessage send(TextMessage textMessage) throws IOException;
}
