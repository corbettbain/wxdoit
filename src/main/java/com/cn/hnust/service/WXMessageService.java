package com.cn.hnust.service;
import java.io.IOException;

import com.cn.hnust.pojo.WeathersForDays;
/**
* @author zn
* @version ����ʱ�䣺2017��1��18�� ����4:08:43
* ��˵��
*/
public interface WXMessageService {

	WeathersForDays getWeather(String city) throws IOException;
}
