package com.bindong.shop.service;

import java.util.List;

//基础接口使用泛型
public interface BaseService <T>{
	public void save(T t);
	public void update(T t);
	public void delete(int id);
	public T get(int id);
	public List<T> query();
	
}
