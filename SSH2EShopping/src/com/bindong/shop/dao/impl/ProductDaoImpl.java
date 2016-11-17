package com.bindong.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bindong.shop.dao.ProductDao;
import com.bindong.shop.model.Product;

@SuppressWarnings("unchecked")
@Repository("productDao")

public class ProductDaoImpl extends BaseDaoImpl<Product> implements ProductDao {


	@Override
	public List<Product> queryJoinCategory(String name, int page, int size) {
		String hql = "from Product p left join fetch p.category where p.name like :name";
		return getSession().createQuery(hql)
				.setString("name", "%"+name+"%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.getResultList();
	}

	@Override
	public Long getCount(String name) {
		String hql ="select count(p) from Product p where p.name like :name";
		return (Long)getSession().createQuery(hql)
				.setString("name", "%"+name+"%")
				.uniqueResult();
	}

	@Override
	public void deleteByIds(String ids) {
		String hql ="delete from Product p where p.id in ("+ids+")";
		getSession().createQuery(hql).executeUpdate();

	}

	@Override
	public List<Product> querByCategoryId(int cid) {
		String hql ="from Product p join fetch p.category "
				+ "where p.commend=true and p.open=true and p.category.id=:cid order by p.date desc";
		return getSession().createQuery(hql)
				.setInteger("cid", cid)
				.setFirstResult(0)
				.setMaxResults(4)
				.getResultList();
	}

	@Override
	public List<Product> queryJointCategory(String name) {
		String hql = "from Product p left join fetch p.category where p.name like :name";
		return getSession().createQuery(hql)
				.setString("name", "%"+name+"%")
				.getResultList();
	}

}
