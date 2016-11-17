package com.bindong.shop.dao;

import com.bindong.shop.model.Shoppingcart;

public interface ShoppingcartDao extends BaseDao<Shoppingcart> {
	//根据订单编号，更新订单状态
		public void updateStatusById(int id, int sid);
}
