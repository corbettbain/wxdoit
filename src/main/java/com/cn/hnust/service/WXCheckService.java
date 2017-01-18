package com.cn.hnust.service;
/**
* @author zn
* @version 创建时间：2017年1月13日 下午11:57:52
* 类说明
*/
public interface WXCheckService {

	Boolean checkWX(String signature,String timestamp,String nonce,String echostr);
}
