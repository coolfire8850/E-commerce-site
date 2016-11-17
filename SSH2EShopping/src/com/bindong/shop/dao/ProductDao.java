package com.bindong.shop.dao;

import java.util.List;

import com.bindong.shop.model.Product;

public interface ProductDao extends BaseDao<Product> {
		//��ѯ��Ʒ��Ϣ���������
		public List<Product> queryJoinCategory(String name, int page, int size); 
		//ͨ�����ֲ�ѯ��Ʒ��Ϣ���������,�ṩǰ̨��Ʒ��Ѱչʾ
		public List<Product> queryJointCategory(String name);
		//���ݹؼ��ֲ�ѯ�ܼ�¼��
		public Long getCount(String name);
		//����idsɾ��������¼
		public void deleteByIds(String ids);
		//�����ȵ�����ѯ�Ƽ���Ʒ��������ѯǰ4����
		public List<Product> querByCategoryId(int cid);
}
