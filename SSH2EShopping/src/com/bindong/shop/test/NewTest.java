package com.bindong.shop.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bindong.shop.action.AccountAction;
import com.bindong.shop.model.Account;
import com.bindong.shop.model.Category;
import com.bindong.shop.model.Product;
import com.bindong.shop.service.AccountService;
import com.bindong.shop.service.CategoryService;
import com.bindong.shop.service.ProductService;
import com.bindong.shop.service.impl.CategoryServiceImpl;

/*
 * 支持JUnit基于注解的测试，用@runwith。注解@ContextConfiguration表示将ApplicationContext对象注入进来，
 * 不需要再测试程序里进行new了
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class NewTest {
	
	
	@Resource
	private CategoryService categoryService;
	@Resource
	private AccountService accountService;
	@Resource
	private ProductService productService;
	
	
	@Test //测试hibernate开发环境，因为没有整合，可以直接new实例
	public void hibernate(){
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = new Category("男士西装", true);
		categoryService.save(category);
	}
	
	@Test //测试spring和hibernate整合后
	public void afterIntegration(){
		
		categoryService.update(new Category(1,"女士西装", true));
	}
	
	@Test  
    public void testQueryJoinAccount() {  
       for(Category c : categoryService.queryJoinAccount("",1,10)) {  
            System.out.println(c);  
            System.out.println(c.getAccount().getName());  
       }  
   }  
	
	@Test  
    public void testQuery() {  
       for(Category c : categoryService.query()) {  
            System.out.println(c);  
            //System.out.println(c.getAccount().getName());  
       }  
    }
	
	@Test
	public void testAccountQuery(){
		
		for(Account a: accountService.query()){
			
			System.out.println(a.getLogin());
		}
	}
	
	@Test
	public void testProductQuery(){
		
		for(Product p : productService.queryJointCategory("", 1, 10)){
			System.out.println(p.getName()+","+p.getRemark()+","+p.getCategory().getType());
		}
	}
}
