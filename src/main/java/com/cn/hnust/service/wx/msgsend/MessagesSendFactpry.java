package com.cn.hnust.service.wx.msgsend;
/**
* @author zn
* @version ����ʱ�䣺2017��2��20�� ����8:49:01
* ��˵��
*/
public interface MessagesSendFactpry {

	<T> T createMessage(String className);
}
