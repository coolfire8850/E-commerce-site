package com.bindong.shop.service;

import com.bindong.shop.model.Shoppingcart;

public interface ShoppingcartService extends BaseService<Shoppingcart> {

	// ���㹺���ܼ۸�
	public double cluTotal(Shoppingcart shoppingcart);

	// ���ݶ�����ţ����¶���״̬
	public void updateStatusById(int id, int sid);
}
