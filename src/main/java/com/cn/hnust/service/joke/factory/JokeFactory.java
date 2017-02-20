package com.cn.hnust.service.joke.factory;

import com.cn.hnust.pojo.joke.Joke;
import com.cn.hnust.pojo.joke.JokeResult;

/**
* @author zn
* @version ����ʱ�䣺2017��2��20�� ����9:51:29
* ��˵��
 * @param <T>
*/
public interface JokeFactory {

	Joke getRandJoke();
	
	JokeResult get(Object no);
}
