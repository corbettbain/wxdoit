package com.cn.hnust.service.joke;

import com.cn.hnust.pojo.joke.Joke;
import com.cn.hnust.pojo.joke.JokeResult;

/**
* @author zn
* @version ����ʱ�䣺2017��2��9�� ����7:30:07
* ��˵��
*/
public interface JokeService {

	JokeResult getJoke(Integer no);
	
	void insertJoke();
	
	Joke getRandJoke();
}
