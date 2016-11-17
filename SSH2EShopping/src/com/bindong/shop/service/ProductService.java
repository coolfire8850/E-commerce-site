package com.bindong.shop.service;

import java.util.List;

import com.bindong.shop.model.Product;

public interface ProductService extends BaseService<Product> {
	
	
		//��ѯ��Ʒ��Ϣ���������ʹ����Ʒ���Ʋ�ѯ
	public List<Product> queryJointCategory(String name, int page, int size);
	
	//ͨ�����ֲ�ѯ��Ʒ��Ϣ���������,�ṩǰ̨��Ʒ��Ѱչʾ
	public List<Product> queryJointCategory(String name);
	//���ݹؼ��ֲ�ѯ�ܼ�¼��
	public Long getCount(String name);
	
	public void deleteByIds(String ids);
		
	//�����ȵ�����ѯ�Ƽ���Ʒ��������ѯǰ4����
	public List<Product> queryByCategoryId(int cid);
}
