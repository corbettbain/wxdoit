package com.cn.hnust.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.DocumentException;

/**
* @author zn
* @version ����ʱ�䣺2017��1��18�� ����7:24:55
* ��˵��
*/
public interface WXMessageOutPutService {

	String outPutToWx(HttpServletRequest request) throws IOException, DocumentException;
}

