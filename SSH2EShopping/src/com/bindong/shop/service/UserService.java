package com.bindong.shop.service;

import com.bindong.shop.model.User;

public interface UserService extends BaseService<User> {
	
	//�û���½���ɹ����ظ�User
	public User getLogin(User user);
}
