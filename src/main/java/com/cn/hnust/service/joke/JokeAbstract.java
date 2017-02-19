package com.cn.hnust.service.joke;

import com.cn.hnust.pojo.joke.Joke;
import com.cn.hnust.pojo.joke.JokeResult;

/**
* @author zn
* @version 创建时间：2017年2月19日 下午7:48:08
* 类说明
*/
public abstract class JokeAbstract implements JokeService {

	public abstract String getKill();
	
	@Override
	public JokeResult getJoke(Integer no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertJoke() {
		// TODO Auto-generated method stub

	}

	@Override
	public Joke getRandJoke() {
		// TODO Auto-generated method stub
		return null;
	}

}
