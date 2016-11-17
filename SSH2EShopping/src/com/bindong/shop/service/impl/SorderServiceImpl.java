package com.bindong.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindong.shop.model.Product;
import com.bindong.shop.model.Shoppingcart;
import com.bindong.shop.model.Sorder;
import com.bindong.shop.service.SorderService;

@Transactional
@Service("sorderService")  //相当于xml中配置 bean id="sorderService", 在baseAction中有相应的@Resource注解
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {

	
	//判断购物车中是否有重复项
	@Override
	public Shoppingcart addSorder(Shoppingcart shoppingcart, Product product) {
		boolean isHave = false; //用来标记有没有重复购物项
		//拿到当前的购物项
		System.out.println("当前选购商品名称 ："+product.getName());
		Sorder sorder = productToSorder(product);
		
		//判断当前购物项是否重复，如果重复，则添加数量即可
		for(Sorder current : shoppingcart.getSorders()){
			if(current.getProduct().getId().equals(product.getId())){
				
				//购物项有重复，添加数量即可
				current.setNumber(current.getNumber()+sorder.getNumber());
				isHave = true;
				break;
			}
		}
		
		if(!isHave){
			 //我们在这里插入一句：  在向购物中添加购物项之前，先建立购物项与购物车的关联，但是此时forder.id为null，  
            //但是在入库的时候是先入库购物车，再入库购物项，那时候就有主键了  
			sorder.setShoppingcart(shoppingcart);
			shoppingcart.getSorders().add(sorder);
		}
			
		return shoppingcart;
	}

	@Override
	public Sorder productToSorder(Product product) {
		Sorder sorder = new Sorder();
		sorder.setName(product.getName());
		sorder.setNumber(1);
		sorder.setPrice(product.getPrice());
		sorder.setProduct(product);
		return sorder;
	}

	@Override
	public Shoppingcart updateSorder(Sorder sorder, Shoppingcart shoppingcart) {
		for(Sorder temp : shoppingcart.getSorders()){
			if(temp.getProduct().getId().equals(sorder.getProduct().getId())){
				System.out.println("修改前的数量为"+temp.getNumber());
				System.out.println("修改后的数量为"+sorder.getNumber());
				temp.setNumber(sorder.getNumber());
			}
		}
		return shoppingcart;
	}

	@Override
	public List<Object> querySale(int number) {
		//不用fecth查出来的就是两项
		
		/*String hql ="select s.name, sum(s.number) from Sorder s join s.product group by s.product.id";
		return getSession().createQuery(hql)
				.setFirstResult(0)
				.setMaxResults(number)
				.getResultList();*/
		return sorderDao.querySale(number);
	}

}
