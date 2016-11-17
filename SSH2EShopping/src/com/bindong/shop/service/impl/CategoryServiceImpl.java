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
	

	

	//已经自动拥有了父类的公共方法，所有不需要再定义save,update,delete等方法
	@Override
	public List<Category> queryJoinAccount(String type,int page,int size) {
		//left join表示关联Account一起查询，fetch表示将Account对象加到Categoy中，这样就只会发出一条SQL语句
	
		/*String hql = "from Category c left join fetch c.account where c.type like :type";
		return getSession().createQuery(hql)
			    .setString("type","%"+type+"%")
				.setFirstResult((page-1)*size)//从第几个开始
				.setMaxResults(size)
				.getResultList();//显示几个
*/       	
		return categoryDao.queryJoinAccount(type, page, size);
	}
	
	//返回一条记录：总记录数
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
