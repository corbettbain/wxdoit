package com.cn.hnust.service.joke.factory;

/**
* @author zn
* @version 创建时间：2017年2月20日 上午9:51:29
* 类说明
 * @param <T>
*/
public interface JokeFactory {

	public <T> T getJokeResource();
}
