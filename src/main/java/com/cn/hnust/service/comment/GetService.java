package com.cn.hnust.service.comment;

import java.util.List;

public interface GetService<T> {

	T get();
	List<T> getList();
}
