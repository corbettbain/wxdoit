package com.cn.hnust.service;
/**
* @author zn
* @version ����ʱ�䣺2017��1��13�� ����11:57:52
* ��˵��
*/
public interface WXCheckService {

	Boolean checkWX(String signature,String timestamp,String nonce,String echostr);
}
