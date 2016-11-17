package com.bindong.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bindong.shop.dao.CategoryDao;
import com.bindong.shop.model.Category;

@SuppressWarnings("unchecked")
@Repository("categoryDao")

public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	
	 @Override
		public List<Category> queryJoinAccount(String type, int page, int size) {
		   		//left join��ʾ����Accountһ���ѯ��fetch��ʾ��Account����ӵ�Categoy�У�������ֻ�ᷢ��һ��SQL���
		 		String hql = "from Category c left join fetch c.account where c.type like :type";
		 		//String hql = "from Category c where c.type like :type";
		 		
		 		return getSession().createQuery(hql)
		 			    .setString("type","%"+type+"%")
		 				.setFirstResult((page-1)*size)//�ӵڼ�����ʼ
		 				.setMaxResults(size)
		 				.getResultList();//��ʾ����
		}

		@Override
		public Long getCount(String type) {
			String hql = "select count(c) from Category c where c.type like :type";
			return (Long) getSession().createQuery(hql)
				.setString("type", "%" + type + "%")
				.uniqueResult(); //����һ����¼:�ܼ�¼��
		}

		

		@Override
		public void deleteByIds(String ids) {
			String hql = "delete from Category c where c.id in (" + ids + ")";
			getSession().createQuery(hql).executeUpdate();

		}

		@Override
		public List<Category> queryByHot(boolean hot) {
			String hql ="from Category c where c.hot=:hot";
			return getSession().createQuery(hql)
					.setBoolean("hot", hot)
					.getResultList();
		}

}
