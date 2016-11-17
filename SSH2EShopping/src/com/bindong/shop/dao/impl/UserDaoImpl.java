package com.bindong.shop.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bindong.shop.dao.UserDao;
import com.bindong.shop.model.User;

@Repository("userDao")

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	

	@Override
	public User login(User user) {
		String hql = "from User u where u.login=:login and u.pass=:pass";
		return (User) getSession().createQuery(hql) //
			.setString("login", user.getLogin()) //
			.setString("pass", user.getPass()) //
			.uniqueResult();
	}

}
