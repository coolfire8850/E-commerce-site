package com.bindong.shop.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bindong.shop.model.Shoppingcart;
import com.bindong.shop.model.Status;
import com.bindong.shop.model.User;
@Controller("shoppingcartAction")
@Scope("prototype")
public class ShoppingcartAction extends BaseAction<Shoppingcart> {

	@Override
	public Shoppingcart getModel() {
		model = (Shoppingcart) session.get(SorderAction.SHOPPINGCART);
		return model;
	}
	
	
	//实现购物车（订单）与购物项（订单项）级联入库功能
	public String save(){
		
      //把session中的购物项交给当前的model对象  
     /* Shoppingcart shoppingcart = (Shoppingcart) session.get("shoppingcart");  
      model.setSorders(shoppingcart.getSorders());  
      shoppingcart.setAddress(model.getAddress());  
      shoppingcart.setName(model.getName());  
      shoppingcart.setPhone(model.getPhone());  
      shoppingcart.setRemark(model.getRemark());  
      shoppingcart.setUser((User)session.get("user"));  
      shoppingcart.setStatus(new Status(1));  
      shoppingcart.setPost(model.getPost());  
     //级联入库(需要在xml或者POJO的注解中配置)，需要sorder关联shoppingcart  
    //  在SorderServiceImpl类中追加sorder.setShoppingcart(shoppingcart);  
        shoppingcartService.save(shoppingcart);  */
		System.out.println("name is"+model.getName());
		System.out.println("phone is"+model.getPhone());
		
		model.setUser((User)session.get("user"));
		model.setStatus(new Status(1));
		shoppingcartService.save(model); 
		
		 //此时购物车已经入库，那么原来session中的购物车就应该清空  
        session.put("oldShoppingcart", session.get(SorderAction.SHOPPINGCART));//先将原来的购物车信息保存下来，因为后面付款的时候还需要相关信息  
        session.put(SorderAction.SHOPPINGCART, new Shoppingcart());//new一个新的空购物车（相当于清空了购物车），还可以方便用户再买~  
        
        return "bank";  
        	
	}
	
	
}
