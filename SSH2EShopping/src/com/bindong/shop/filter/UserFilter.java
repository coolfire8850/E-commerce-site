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
		// �жϵ�ǰsession�Ƿ����û���Ϣ 
		if(req.getSession().getAttribute("user") == null){
			//���浱ǰ�ͻ���Ҫȥ��url��ַ  
			String goUrl = req.getServletPath();
			
			//��õ�ַ��Я���Ĳ���
			String param = req.getQueryString();
			if(param != null){
				goUrl = goUrl + "?"+param;
			}
			System.out.println(goUrl);
		  //�ѵ�ǰ�ͻ���Ҫ���ʵĵ�ַ���洢��session��  
			req.getSession().setAttribute("goUrl", goUrl);
			//�Ƿ�������ת����½ҳ�� 
			req.getSession().setAttribute("error", getText("loginMessage"));
			res.sendRedirect(req.getContextPath()+"/ulogin.jsp");
			
		}else {
			 //�������һ������������ת������ֱ�ӵ�Ŀ��ҳ��
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
