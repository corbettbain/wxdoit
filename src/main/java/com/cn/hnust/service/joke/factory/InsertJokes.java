package com.cn.hnust.service.joke.factory;

import com.cn.hnust.service.joke.impl.InsertJoke;

/**
* @author zn
* @version 创建时间：2017年2月20日 下午2:21:53
* 类说明
*/
public class InsertJokes implements JokeFactory {

	@SuppressWarnings("unchecked")
	@Override
	public InsertJoke getJokeResource() {
		// TODO Auto-generated method stub
		return new InsertJoke();
	}

}
