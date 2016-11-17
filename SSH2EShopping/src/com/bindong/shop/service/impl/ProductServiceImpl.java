package com.bindong.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindong.shop.model.Product;
import com.bindong.shop.service.ProductService;

//
@Service("productService")

public class ProductServiceImpl extends BaseServiceImpl<Product> implements
		ProductService {

	@Override
	public List<Product> queryJointCategory(String name, int page, int size) {
	/*	String hql = "from Product p left join fetch p.category where p.name like :name";
		return getSession().createQuery(hql)
				.setString("name", "%"+name+"%")
				.setFirstResult((page-1)*size)
				.setMaxResults(size)
				.getResultList();*/
		return productDao.queryJoinCategory(name, page, size);

	}

	@Override
	public Long getCount(String name) {
		
		/*String hql ="select count(p) from Product p where p.name like :name";
		return (Long)getSession().createQuery(hql)
				.setString("name", "%"+name+"%")
				.uniqueResult();*/
		return productDao.getCount(name);
		
	}

	@Override
	public void deleteByIds(String ids) {
		
		/*String hql ="delete from Product p where p.id in ("+ids+")";
		getSession().createQuery(hql).executeUpdate();*/
		productDao.deleteByIds(ids);
	}

	public List<Product> queryByCategoryId(int cid) {
		/*String hql ="from Product p join fetch p.category "
				+ "where p.commend=true and p.open=true and p.category.id=:cid order by p.date desc";
		return getSession().createQuery(hql)
				.setInteger("cid", cid)
				.setFirstResult(0)
				.setMaxResults(4)
				.getResultList();*/
		return productDao.querByCategoryId(cid);
	}

	public List<Product> queryJointCategory(String name) {
		/*String hql = "from Product p left join fetch p.category where p.name like :name";
		return getSession().createQuery(hql)
				.setString("name", "%"+name+"%")
				.getResultList();*/
		return productDao.queryJointCategory(name);
	}

	

}
