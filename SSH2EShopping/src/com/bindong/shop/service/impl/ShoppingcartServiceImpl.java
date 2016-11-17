package com.bindong.shop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindong.shop.model.Shoppingcart;
import com.bindong.shop.model.Sorder;
import com.bindong.shop.service.ShoppingcartService;

@Service("shoppingcartService")

public class ShoppingcartServiceImpl extends BaseServiceImpl<Shoppingcart> implements
		ShoppingcartService {

	@Override
	public double cluTotal(Shoppingcart shoppingcart) {
		double total = 0;
		for(Sorder sorder : shoppingcart.getSorders()){
			total+=sorder.getNumber()*sorder.getPrice();
		}
		
		return total;
	}

	@Override
	public void updateStatusById(int id, int sid) {
		shoppingcartDao.updateStatusById(id, sid);
		
	}

	

	

}
