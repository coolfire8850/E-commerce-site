package com.bindong.shop.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindong.shop.model.User;
import com.bindong.shop.service.UserService;


@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	
	@Override
	public User getLogin(User user) {
		/*String hql ="from User u where u.login=:login and u.pass=:pass";
		return (User) getSession().createQuery(hql)
						.setString("login", user.getLogin())
						.setString("pass", user.getPass())
						.uniqueResult();*/
		return userDao.login(user);
	}

}
