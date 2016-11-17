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
 * ֧��JUnit����ע��Ĳ��ԣ���@runwith��ע��@ContextConfiguration��ʾ��ApplicationContext����ע�������
 * ����Ҫ�ٲ��Գ��������new��
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
	
	
	@Test //����hibernate������������Ϊû�����ϣ�����ֱ��newʵ��
	public void hibernate(){
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = new Category("��ʿ��װ", true);
		categoryService.save(category);
	}
	
	@Test //����spring��hibernate���Ϻ�
	public void afterIntegration(){
		
		categoryService.update(new Category(1,"Ůʿ��װ", true));
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
