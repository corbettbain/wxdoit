package com.cn.hnust.service.joke.factory;

import com.cn.hnust.service.joke.impl.InsertJoke;

/**
* @author zn
* @version ����ʱ�䣺2017��2��20�� ����2:21:53
* ��˵��
*/
public class InsertJokes implements JokeFactory {

	@SuppressWarnings("unchecked")
	@Override
	public InsertJoke getJokeResource() {
		// TODO Auto-generated method stub
		return new InsertJoke();
	}

}
