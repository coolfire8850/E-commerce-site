package com.bindong.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bindong.shop.dao.ShoppingcartDao;
import com.bindong.shop.model.Shoppingcart;

@SuppressWarnings("unchecked")
@Repository("shoppingcartDao")

public class ShoppingcartDaoImpl extends BaseDaoImpl<Shoppingcart> implements
		ShoppingcartDao {



	@Override
	public void updateStatusById(int id, int sid) {
		String hql = "update Shoppingcart s set s.status.id=:sid where s.id=:id";
		getSession().createQuery(hql)
			.setInteger("sid", sid)
			.setInteger("id", id)
			.executeUpdate();

	}

}
