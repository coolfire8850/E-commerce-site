package com.bindong.shop.dao;

import com.bindong.shop.model.User;

public interface UserDao extends BaseDao<User> {
	//�û���½���ɹ����ظ�User
	public User login(User user);
}
