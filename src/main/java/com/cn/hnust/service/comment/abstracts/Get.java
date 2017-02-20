package com.cn.hnust.service.comment.abstracts;

import java.util.ArrayList;
import java.util.List;

import com.cn.hnust.service.comment.GetService;

public abstract class Get<T> implements GetService<T> {

	private T tt;
	
	public T get(Object object) {
		return null;
	}
	
	@Override
	public T get() {
		// TODO Auto-generated method stub
		return tt;
	}
	@Override
	public List<T> getList() {
		List<T> list  = new ArrayList<>();
		list.add(tt);
		return  list;
	}
	
	public void setT(T t){
		this.tt = t;
	}
}
