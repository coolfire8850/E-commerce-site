package com.bindong.shop.dao;

import java.util.List;

import com.bindong.shop.model.Sorder;

public interface SorderDao extends BaseDao<Sorder> {
		//��ѯ�ȵ���Ʒ��������
		public List<Object> querySale(int number);
}
