package com.bindong.shop.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("changeLocale")
public class ChangeLocale extends ActionSupport {
	private String returnUrl;
	
	@Override
	public String execute() throws Exception {
		//������Ժ���Ҫ���ص���ǰҳ��
		returnUrl = returnUrl.replace("/SSH2EShopping/", "/");
		System.out.println(returnUrl);
		return "returnUrl";
	}

	public String getReturnUrl() {
		return returnUrl;
	}

	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}


	

}
