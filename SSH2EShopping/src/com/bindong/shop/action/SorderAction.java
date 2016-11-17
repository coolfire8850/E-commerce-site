package com.bindong.shop.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bindong.shop.model.Product;
import com.bindong.shop.model.Shoppingcart;
import com.bindong.shop.model.Sorder;
import com.opensymphony.xwork2.ActionContext;




@Controller("sorderAction")
@Scope("prototype")
public class SorderAction extends BaseAction<Sorder> {
	public  static final String SHOPPINGCART= "shoppingcart";
	
	public String addSorder(){
		
		 //1. ����ǰ̨ҳ��product.id��ȡ��Ӧ����Ʒ����
		
		//System.out.println("detailҳ�洫������ID: "+model.getProduct().getId()))
			
			Product product = productService.get(model.getProduct().getId());
			 //2. �жϵ�ǰsession�Ƿ��й��ﳵ�����û���򴴽�  
			if(session.get(SHOPPINGCART) == null){
				 //�����µĹ��ﳵ���洢��session��  
				session.put(SHOPPINGCART, new Shoppingcart(new ArrayList<Sorder>()));
			}
			
			//3. ����Ʒ��Ϣת��Ϊsorder,������ӵ����ﳵ�У��жϹ������Ƿ��ظ���  
			Shoppingcart shoppingcart = (Shoppingcart) session.get(SHOPPINGCART);
			shoppingcart = sorderService.addSorder(shoppingcart, product);
			
			//4. ���㹺����ܼ۸�
			shoppingcart.setTotal(shoppingcartService.cluTotal(shoppingcart));
			
			//5. ���µĹ��ﳵ�洢��session��  
			session.put(SHOPPINGCART, shoppingcart);
			
		
		
		
		return "showCart";
	}
	
	//������Ʒ��Ÿ�����Ʒ����
	public String updateSorder(){
		Shoppingcart shoppingcart = (Shoppingcart)session.get(SHOPPINGCART);
		shoppingcart = sorderService.updateSorder(model, shoppingcart);
		shoppingcart.setTotal(shoppingcartService.cluTotal(shoppingcart));
		
		session.put(SHOPPINGCART, shoppingcart);
		//��������ʽ�����µ��ܼ۸�
		inputStream = new ByteArrayInputStream(shoppingcart.getTotal().toString().getBytes());
		return "stream";
	}
	
	//����������Ʒ����������
	public String querySale(){
		List<Object> jsonList = sorderService.querySale(model.getNumber());
		//����ѯ������list�ŵ�ֵջ�Ķ��ˣ���Ϊ����jsonList�Ǹ�List<Object>���󣬲���BaseAction�е�List<T>����
		//��������Ҫ�����Action�ж���һ��List<Object>����ʵ��get����
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
	
	
	
}
