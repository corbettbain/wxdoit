package com.cn.hnust.service.joke.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IJokeDao;
import com.cn.hnust.pojo.joke.Joke;
import com.cn.hnust.pojo.joke.JokeResult;
import com.cn.hnust.service.joke.factory.JokeFactory;
import com.cn.hnust.wxmessages.WxMessagesUtils;

@Service
public class GetJoke implements JokeFactory{

	@Inject
	private IJokeDao jokeDao;
	
	@Override
	public Joke getRandJoke() {
		
		return jokeDao.getRandJoke();
	}

	@Override
	public JokeResult get(Object no) {
		String results = null;
		JokeResult jokeResult = null;
		String strUrl = JokeResult.STRURL;
		Map<String, Object > param = new HashMap<>();
		param.put(WxMessagesUtils.JISU_APP_KEY, WxMessagesUtils.JISU_APP_KEY_VALUE);
		param.put("pagesize", 20);
		param.put("pagenum", no);
		param.put("sort", "addtime");
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
