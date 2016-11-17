package com.bindong.shop.service;

import java.util.List;

import com.bindong.shop.model.Product;
import com.bindong.shop.model.Shoppingcart;
import com.bindong.shop.model.Sorder;

public interface SorderService extends BaseService<Sorder> {
	
	//��ӹ���������µĹ��ﳵ
	public Shoppingcart addSorder(Shoppingcart shoppingcart,Product product);
	
	//����Ʒ����ת��Ϊ������
	public Sorder productToSorder(Product product);
	
	//������Ʒid������������Ʒ����
	public Shoppingcart updateSorder(Sorder sorder, Shoppingcart shoppingcart);
	
	//��ѯ�ȵ���Ʒ��������
	public List<Object> querySale(int number);
}
