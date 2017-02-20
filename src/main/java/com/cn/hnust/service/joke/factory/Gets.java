package com.cn.hnust.service.joke.factory;

import com.cn.hnust.service.joke.impl.GetJoke;

/**
* @author zn
* @version 创建时间：2017年2月20日 上午9:52:28
* 类说明
*/
public class Gets implements JokeFactory {

	@SuppressWarnings("unchecked")
	@Override
	public GetJoke getJokeResource() {
		return new GetJoke();
	}

}
