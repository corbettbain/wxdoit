package com.cn.hnust.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cn.hnust.pojo.joke.JokeResult;
import com.cn.hnust.service.JokeService;
import com.cn.hnust.wxmessages.WxMessagesUtils;

/**
* @author zn
* @version 创建时间：2017年2月10日 上午9:54:28
* 类说明
*/
@Service
public class JokeServiceImpl implements JokeService {

	@Override
	public JokeResult getJoke() {
		String results = null;
		JokeResult jokeResult = null;
		String strUrl = JokeResult.STRURL;
		Map<String, Object > param = new HashMap<>();
		param.put(WxMessagesUtils.JISU_APP_KEY, WxMessagesUtils.JISU_APP_KEY_VALUE);
		param.put("pagesize", 3);
		param.put("pagenum", 1);
		String method = WxMessagesUtils.METHOD_GET;
		try {
			results = WxMessagesUtils.getUrlData(strUrl, param, method, null);
			jokeResult = (JokeResult) WxMessagesUtils.jsonObjectToJavaBean(results, JokeResult.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jokeResult;
	}

}
