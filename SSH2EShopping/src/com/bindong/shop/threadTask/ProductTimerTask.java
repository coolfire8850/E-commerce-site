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
	private ProductService productService; //注入produceService
	@Resource
	private CategoryService categoryService; //注入categoryService
	
	private ServletContext servletContext; //定义一个ServletContext对象，更新后的后台数据需要存入application域里面
	
	
	
	@Override
	public void run() {
		//bigList中存放一个装有Category类的list
				List<List<Product>> bigList = new ArrayList<List<Product>>();
				//1.查询出热点类别
				for(Category category : categoryService.queryByHot(true)){
					//根据热点类别id获取推荐商品信息
					 List<Product> lst = productService.queryByCategoryId(category.getId());
					 for(Product p :lst){
						 System.out.println(p.getCategory().getType()+" haha "+p.getDetails());
					 }
					 //将装有category的list放到bigList中
					 bigList.add(lst);
					
				}
				
				//2.把查询的bigList交给application内置对象
				servletContext.setAttribute("bigList", bigList);

	}



	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
