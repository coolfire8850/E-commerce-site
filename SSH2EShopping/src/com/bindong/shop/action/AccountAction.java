package com.bindong.shop.action;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bindong.shop.model.Account;

@Controller("accountAction")
@Scope("prototype")
public class AccountAction extends BaseAction<Account> {
	
	public String query(){
		
		jsonList = accountService.query();
		
		System.out.println("µ˜”√¡Àaccount_query:"+jsonList.size());
		
		return "jsonmap";
	}
	
	public String getReturn(){
		return "index";
	}
}
