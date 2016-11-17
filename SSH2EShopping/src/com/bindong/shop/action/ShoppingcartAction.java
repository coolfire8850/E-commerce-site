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
	
	
	//ʵ�ֹ��ﳵ���������빺��������������⹦��
	public String save(){
		
      //��session�еĹ��������ǰ��model����  
     /* Shoppingcart shoppingcart = (Shoppingcart) session.get("shoppingcart");  
      model.setSorders(shoppingcart.getSorders());  
      shoppingcart.setAddress(model.getAddress());  
      shoppingcart.setName(model.getName());  
      shoppingcart.setPhone(model.getPhone());  
      shoppingcart.setRemark(model.getRemark());  
      shoppingcart.setUser((User)session.get("user"));  
      shoppingcart.setStatus(new Status(1));  
      shoppingcart.setPost(model.getPost());  
     //�������(��Ҫ��xml����POJO��ע��������)����Ҫsorder����shoppingcart  
    //  ��SorderServiceImpl����׷��sorder.setShoppingcart(shoppingcart);  
        shoppingcartService.save(shoppingcart);  */
		System.out.println("name is"+model.getName());
		System.out.println("phone is"+model.getPhone());
		
		model.setUser((User)session.get("user"));
		model.setStatus(new Status(1));
		shoppingcartService.save(model); 
		
		 //��ʱ���ﳵ�Ѿ���⣬��ôԭ��session�еĹ��ﳵ��Ӧ�����  
        session.put("oldShoppingcart", session.get(SorderAction.SHOPPINGCART));//�Ƚ�ԭ���Ĺ��ﳵ��Ϣ������������Ϊ���渶���ʱ����Ҫ�����Ϣ  
        session.put(SorderAction.SHOPPINGCART, new Shoppingcart());//newһ���µĿչ��ﳵ���൱������˹��ﳵ���������Է����û�����~  
        
        return "bank";  
        	
	}
	
	
}
