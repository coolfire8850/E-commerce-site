package com.bindong.shop.service;

import com.bindong.shop.model.User;

public interface UserService extends BaseService<User> {
	
	//用户登陆，成功返回该User
	public User getLogin(User user);
}
