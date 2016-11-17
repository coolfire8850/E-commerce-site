package com.bindong.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bindong.shop.model.User;

@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User> {
	
	public String login(){
		System.out.println("����getLogin"+model.getLogin()+","+model.getPass());
		//���е�½���ж� 
		model = userService.getLogin(model);
		
		if(model == null){
			session.put("error", getText("loginError"));
			return "login";
			
		}else{
			//��¼�ɹ����Ƚ��û��洢��session�� 
			session.put("user",model);
			if(session.get("goUrl") == null)
				return "index";
			else {
				return "goUrl";
			}
			
		}
		
		
	}

}
