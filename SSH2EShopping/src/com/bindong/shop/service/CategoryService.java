package com.bindong.shop.service;

import java.util.List;

import com.bindong.shop.model.Category;

public interface CategoryService extends BaseService<Category> {
	//只要添加CategoryService本身需要的新方法即可，公共方法已经存在BaseService中了

	
	//查询类别信息，级联管理员,并实现分页功能
	public List<Category> queryJoinAccount(String type,int page, int size);
	//根据关键字查询总记录数
	public Long getCount(String type);
	

	
	public void deleteByIds(String ids);
	
	//根据boolean值查询热点或非热点类别
	public List<Category> queryByHot(boolean hot);
}
