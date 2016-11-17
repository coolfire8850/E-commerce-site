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
		
		 //1. 根据前台页面product.id获取相应的商品数据
		
		//System.out.println("detail页面传进来的ID: "+model.getProduct().getId()))
			
			Product product = productService.get(model.getProduct().getId());
			 //2. 判断当前session是否有购物车，如果没有则创建  
			if(session.get(SHOPPINGCART) == null){
				 //创建新的购物车，存储到session中  
				session.put(SHOPPINGCART, new Shoppingcart(new ArrayList<Sorder>()));
			}
			
			//3. 把商品信息转化为sorder,并且添加到购物车中（判断购物项是否重复）  
			Shoppingcart shoppingcart = (Shoppingcart) session.get(SHOPPINGCART);
			shoppingcart = sorderService.addSorder(shoppingcart, product);
			
			//4. 计算购物的总价格
			shoppingcart.setTotal(shoppingcartService.cluTotal(shoppingcart));
			
			//5. 把新的购物车存储到session中  
			session.put(SHOPPINGCART, shoppingcart);
			
		
		
		
		return "showCart";
	}
	
	//根据商品编号更新商品数量
	public String updateSorder(){
		Shoppingcart shoppingcart = (Shoppingcart)session.get(SHOPPINGCART);
		shoppingcart = sorderService.updateSorder(model, shoppingcart);
		shoppingcart.setTotal(shoppingcartService.cluTotal(shoppingcart));
		
		session.put(SHOPPINGCART, shoppingcart);
		//以流的形式返回新的总价格
		inputStream = new ByteArrayInputStream(shoppingcart.getTotal().toString().getBytes());
		return "stream";
	}
	
	//返回热门商品及其销售量
	public String querySale(){
		List<Object> jsonList = sorderService.querySale(model.getNumber());
		//将查询出来的list放到值栈的顶端，因为这里jsonList是个List<Object>对象，不是BaseAction中的List<T>对象
		//所以我们要在这个Action中定义一个List<Object>对象并实现get方法
		ActionContext.getContext().getValueStack().push(jsonList);
		return "jsonList";
	}
	
	
	
}
