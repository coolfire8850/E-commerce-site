package com.bindong.shop.dao;

import com.bindong.shop.model.Shoppingcart;

public interface ShoppingcartDao extends BaseDao<Shoppingcart> {
	//���ݶ�����ţ����¶���״̬
		public void updateStatusById(int id, int sid);
}
