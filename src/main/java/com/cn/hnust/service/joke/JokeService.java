package com.cn.hnust.service.joke;

import com.cn.hnust.pojo.joke.Joke;
import com.cn.hnust.pojo.joke.JokeResult;

/**
* @author zn
* @version 创建时间：2017年2月9日 下午7:30:07
* 类说明
*/
public interface JokeService {

	JokeResult getJoke(Integer no);
	
	void insertJoke();
	
	Joke getRandJoke();
}
