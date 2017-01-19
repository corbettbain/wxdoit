package com.cn.hnust.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;

/**
* @author zn
* @version 创建时间：2017年1月18日 下午7:24:55
* 类说明
*/
public interface WXMessageOutPutService {

	String outPutToWx(HttpServletRequest request) throws IOException, DocumentException;
}

