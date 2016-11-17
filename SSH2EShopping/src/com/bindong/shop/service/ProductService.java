package com.bindong.shop.service;

import java.util.List;

import com.bindong.shop.model.Product;

public interface ProductService extends BaseService<Product> {
	
	
		//查询商品信息，级联类别。使用商品名称查询
	public List<Product> queryJointCategory(String name, int page, int size);
	
	//通过名字查询商品信息，级联类别,提供前台商品搜寻展示
	public List<Product> queryJointCategory(String name);
	//根据关键字查询总记录数
	public Long getCount(String name);
	
	public void deleteByIds(String ids);
		
	//根据热点类别查询推荐商品（仅仅查询前4个）
	public List<Product> queryByCategoryId(int cid);
}
