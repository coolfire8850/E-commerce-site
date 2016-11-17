package com.bindong.shop.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindong.shop.model.Category;
import com.bindong.shop.service.CategoryService;

@Service("categoryService")

public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {
	

	

	//�Ѿ��Զ�ӵ���˸���Ĺ������������в���Ҫ�ٶ���save,update,delete�ȷ���
	@Override
	public List<Category> queryJoinAccount(String type,int page,int size) {
		//left join��ʾ����Accountһ���ѯ��fetch��ʾ��Account����ӵ�Categoy�У�������ֻ�ᷢ��һ��SQL���
	
		/*String hql = "from Category c left join fetch c.account where c.type like :type";
		return getSession().createQuery(hql)
			    .setString("type","%"+type+"%")
				.setFirstResult((page-1)*size)//�ӵڼ�����ʼ
				.setMaxResults(size)
				.getResultList();//��ʾ����
*/       	
		return categoryDao.queryJoinAccount(type, page, size);
	}
	
	//����һ����¼���ܼ�¼��
	@Override
	public Long getCount(String type) {
		/*String hql = "select count(c) from Category c where c.type like :type";
		return (Long) getSession().createQuery(hql)
				.setString("type","%"+type+"%")
				.uniqueResult();*/
		return categoryDao.getCount(type);
	}

	

	@Override
	public void deleteByIds(String ids) {
		/*String hql = "delete from Category c where c.id in ("+ids+")";
		getSession().createQuery(hql).executeUpdate();*/
		categoryDao.deleteByIds(ids);
		
	}

	public List<Category> queryByHot(boolean hot) {
		/*String hql ="from Category c where c.hot=:hot";
		return getSession().createQuery(hql)
				.setBoolean("hot", hot)
				.getResultList();*/
		return categoryDao.queryByHot(hot);
	}



}
