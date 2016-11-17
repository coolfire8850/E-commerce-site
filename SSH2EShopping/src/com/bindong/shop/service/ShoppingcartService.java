package com.bindong.shop.service;

import com.bindong.shop.model.Shoppingcart;

public interface ShoppingcartService extends BaseService<Shoppingcart> {

	// 计算购物总价格
	public double cluTotal(Shoppingcart shoppingcart);

	// 根据订单编号，更新订单状态
	public void updateStatusById(int id, int sid);
}
