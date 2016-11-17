package com.bindong.shop.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bindong.shop.dao.AccountDao;
import com.bindong.shop.model.Account;

@Repository("accountDao")

public class AccountDaoImpl extends BaseDaoImpl<Account> implements AccountDao {

	

}
