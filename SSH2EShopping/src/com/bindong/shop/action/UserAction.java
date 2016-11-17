package com.bindong.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bindong.shop.model.User;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	public String login(){
		System.out.println("进入getLogin"+model.getLogin()+","+model.getPass());
		//进行登陆的判断 
		model = userService.getLogin(model);
		
		if(model == null){
			session.put("error", getText("loginError"));
			return "login";
			
		}else{
			//登录成功，先将用户存储到session中 
			session.put("user",model);
			if(session.get("goUrl") == null)
				return "index";
			else {
				return "goUrl";
			}
			
		}
		
		
	}

}
