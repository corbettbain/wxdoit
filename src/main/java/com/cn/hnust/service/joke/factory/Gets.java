package com.cn.hnust.service.joke.factory;

import com.cn.hnust.service.joke.impl.GetJoke;

/**
* @author zn
* @version ����ʱ�䣺2017��2��20�� ����9:52:28
* ��˵��
*/
public class Gets implements JokeFactory {

	@SuppressWarnings("unchecked")
	@Override
	public GetJoke getJokeResource() {
		return new GetJoke();
	}

}
