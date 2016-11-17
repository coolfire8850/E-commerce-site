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
@Service("sorderService")  //�൱��xml������ bean id="sorderService", ��baseAction������Ӧ��@Resourceע��
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {

	
	//�жϹ��ﳵ���Ƿ����ظ���
	@Override
	public Shoppingcart addSorder(Shoppingcart shoppingcart, Product product) {
		boolean isHave = false; //���������û���ظ�������
		//�õ���ǰ�Ĺ�����
		System.out.println("��ǰѡ����Ʒ���� ��"+product.getName());
		Sorder sorder = productToSorder(product);
		
		//�жϵ�ǰ�������Ƿ��ظ�������ظ����������������
		for(Sorder current : shoppingcart.getSorders()){
			if(current.getProduct().getId().equals(product.getId())){
				
				//���������ظ��������������
				current.setNumber(current.getNumber()+sorder.getNumber());
				isHave = true;
				break;
			}
		}
		
		if(!isHave){
			 //�������������һ�䣺  ����������ӹ�����֮ǰ���Ƚ����������빺�ﳵ�Ĺ��������Ǵ�ʱforder.idΪnull��  
            //����������ʱ��������⹺�ﳵ������⹺�����ʱ�����������  
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
				System.out.println("�޸�ǰ������Ϊ"+temp.getNumber());
				System.out.println("�޸ĺ������Ϊ"+sorder.getNumber());
				temp.setNumber(sorder.getNumber());
			}
		}
		return shoppingcart;
	}

	@Override
	public List<Object> querySale(int number) {
		//����fecth������ľ�������
		
		/*String hql ="select s.name, sum(s.number) from Sorder s join s.product group by s.product.id";
		return getSession().createQuery(hql)
				.setFirstResult(0)
				.setMaxResults(number)
				.getResultList();*/
		return sorderDao.querySale(number);
	}

}
