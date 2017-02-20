package com.cn.hnust.service.joke.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IJokeDao;
import com.cn.hnust.pojo.joke.Joke;
import com.cn.hnust.pojo.joke.JokeResult;
import com.cn.hnust.service.joke.factory.InsertJokeService;
@Service
public class InsertJoke implements InsertJokeService {

	@Inject
	private IJokeDao jokeDao;
	
	@Inject 
	private GetJoke getJoke;
	
	@Override
	public Integer insert() {
		List<Joke> jokes = null;
		Integer jInteger = 0;
		JokeResult jokeResult = null;
		for (int i = 1; i < 2251; i++) {
			jokeResult = getJoke.get(i);
			
			jokes = jokeResult.getResult().getList();
			
			for (Joke joke : jokes) {
				jInteger += jokeDao.insertSelective(joke);
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return jInteger;
	}
}
