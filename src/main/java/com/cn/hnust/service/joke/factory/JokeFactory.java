package com.cn.hnust.service.joke.factory;

import com.cn.hnust.pojo.joke.Joke;
import com.cn.hnust.pojo.joke.JokeResult;

/**
* @author zn
* @version 创建时间：2017年2月20日 上午9:51:29
* 类说明
 * @param <T>
*/
public interface JokeFactory {

	Joke getRandJoke();
	
	JokeResult get(Object no);
}
