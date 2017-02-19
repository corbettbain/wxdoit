package com.cn.hnust.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IJokeDao;
import com.cn.hnust.pojo.joke.Joke;
import com.cn.hnust.pojo.joke.JokeResult;
import com.cn.hnust.wxmessages.WxMessagesUtils;

/**
* @author zn
* @version 创建时间：2017年2月10日 上午9:54:28
* 类说明
*/
@Service
public class JokeServiceImpl implements com.cn.hnust.service.joke.JokeService {

	
	@Inject
	private IJokeDao jokeDao;
	
	@Override
	public JokeResult getJoke(Integer no) {
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

	@Override
	public void insertJoke() {
		List<Joke> jokes = null;
		
		JokeResult jokeResult = null;
		for (int i = 1; i < 2251; i++) {
			jokeResult = getJoke(i);
			
			jokes = jokeResult.getResult().getList();
			
			for (Joke joke : jokes) {
				jokeDao.insertSelective(joke);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public Joke getRandJoke() {
		
		return jokeDao.getRandJoke();
	}

}
