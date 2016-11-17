package com.bindong.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.opensymphony.xwork2.ActionSupport;



public class UserFilter extends ActionSupport implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		// 判断当前session是否有用户信息 
		if(req.getSession().getAttribute("user") == null){
			//保存当前客户想要去的url地址  
			String goUrl = req.getServletPath();
			
			//获得地址中携带的参数
			String param = req.getQueryString();
			if(param != null){
				goUrl = goUrl + "?"+param;
			}
			System.out.println(goUrl);
		  //把当前客户想要访问的地址，存储到session中  
			req.getSession().setAttribute("goUrl", goUrl);
			//非法请求，跳转到登陆页面 
			req.getSession().setAttribute("error", getText("loginMessage"));
			res.sendRedirect(req.getContextPath()+"/ulogin.jsp");
			
		}else {
			 //如果有下一个过滤器则跳转，否则直接到目标页面
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
