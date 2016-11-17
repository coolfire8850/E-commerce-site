package com.bindong.shop.service;

import java.util.List;

import com.bindong.shop.model.Category;

public interface CategoryService extends BaseService<Category> {
	//ֻҪ���CategoryService������Ҫ���·������ɣ����������Ѿ�����BaseService����

	
	//��ѯ�����Ϣ����������Ա,��ʵ�ַ�ҳ����
	public List<Category> queryJoinAccount(String type,int page, int size);
	//���ݹؼ��ֲ�ѯ�ܼ�¼��
	public Long getCount(String type);
	

	
	public void deleteByIds(String ids);
	
	//����booleanֵ��ѯ�ȵ����ȵ����
	public List<Category> queryByHot(boolean hot);
}
