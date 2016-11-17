package com.bindong.shop.action;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bindong.shop.model.Category;
import com.bindong.shop.service.CategoryService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

//继承BaseAction
@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category>{
	
	//private Category category; 
	
	//为了直观的看出与spring整合前后有何不同
	//private CategoryService categoryService; 被抽取到了BaseAction层
	
	public String queryJoinAccount(){
		
		//用来存储分页的数据
		pageMap = new HashMap<String, Object>();
		
		//根据关键字和分页的参数查询相应的数据。这个方法我们在Service中已经写过了。通过继承BaseAction获得相应的域
		List<Category> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
		//List<Category> categoryList = categoryService.query();
	
		
		//存储为JSON格式，从上一节的json文件可以看出，一个key是total,一个key是rows,这里先把rows存放好
		pageMap.put("rows", categoryList);
		System.out.println("categoryList :"+categoryList.size());
		//根据关键字查询总记录数
		
		Long total = categoryService.getCount(model.getType());
		
		//存储为JSON格式，再把total存放好
	    pageMap.put("total", total);	
		
		return "jsonMap";
		
		
	}
	
	public String deleteByIds(){
		System.out.println(ids);
		categoryService.deleteByIds(ids);
		//如果删除成功，往下执行，我们将"true"以流的形式传给前台
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
		
	}
	
	
	public void update(){
		System.out.println("-----update-----");
		System.out.println(model.getId()+","+model.getType()+","+model.getAccount());
		categoryService.update(model); //直接使用model代替category
		
		
	}
	
	public void save(){
		
		System.out.println(model);
		
		categoryService.save(model);
		
	}
	
	public String query(){
		
		//第一种方法
		/*ActionContext.getContext().put("categorylist", categoryService.query());
		ActionContext.getContext().getSession().put("categorylist", categoryService.query());
		ActionContext.getContext().getApplication().put("categorylist", categoryService.query());*/
		
		//第二种方法
		/*request.put("categorylist", categoryService.query());
		session.put("categorylist", categoryService.query());
		application.put("categorylist", categoryService.query());*/
		
		jsonList = categoryService.query();
		
		return "jsonList";
	}

/*	public Category getCategory() {
		System.out.println("调用getCategory方法 ："+category.getId()+","+category.getType());
		return category;
	}

	public void setCategory(Category category) {
		System.out.println("调用setCategory方法 ："+category.getId()+","+category.getType());
		this.category = category;
	}*/
	
	/*public CategoryService getCategoryService() {
		return categoryService;
	}
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}*/
	
	//使用ModelDriven接口必须实现getModel()方法，此方法会把返回的项压到栈顶
	/*@Override
	public Category getModel() {
		 return super.getModel();
	}*/
	
}
