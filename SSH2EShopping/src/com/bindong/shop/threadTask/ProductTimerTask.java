package com.bindong.shop.threadTask;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Component;

import com.bindong.shop.model.Category;
import com.bindong.shop.model.Product;
import com.bindong.shop.service.CategoryService;
import com.bindong.shop.service.ProductService;

@Component
public class ProductTimerTask extends TimerTask {

	@Resource
	private ProductService productService; //ע��produceService
	@Resource
	private CategoryService categoryService; //ע��categoryService
	
	private ServletContext servletContext; //����һ��ServletContext���󣬸��º�ĺ�̨������Ҫ����application������
	
	
	
	@Override
	public void run() {
		//bigList�д��һ��װ��Category���list
				List<List<Product>> bigList = new ArrayList<List<Product>>();
				//1.��ѯ���ȵ����
				for(Category category : categoryService.queryByHot(true)){
					//�����ȵ����id��ȡ�Ƽ���Ʒ��Ϣ
					 List<Product> lst = productService.queryByCategoryId(category.getId());
					 for(Product p :lst){
						 System.out.println(p.getCategory().getType()+" haha "+p.getDetails());
					 }
					 //��װ��category��list�ŵ�bigList��
					 bigList.add(lst);
					
				}
				
				//2.�Ѳ�ѯ��bigList����application���ö���
				servletContext.setAttribute("bigList", bigList);

	}



	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
