package com.bindong.shop.service;

import java.util.List;

import com.bindong.shop.model.Product;
import com.bindong.shop.model.Shoppingcart;
import com.bindong.shop.model.Sorder;

public interface SorderService extends BaseService<Sorder> {
	
	//添加购物项，返回新的购物车
	public Shoppingcart addSorder(Shoppingcart shoppingcart,Product product);
	
	//把商品数据转化为购物项
	public Sorder productToSorder(Product product);
	
	//根据商品id和数量更新商品数量
	public Shoppingcart updateSorder(Sorder sorder, Shoppingcart shoppingcart);
	
	//查询热点商品的销售量
	public List<Object> querySale(int number);
}
