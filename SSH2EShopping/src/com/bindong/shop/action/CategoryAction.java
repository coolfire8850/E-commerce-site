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

//�̳�BaseAction
@Controller("categoryAction")
@Scope("prototype")
public class CategoryAction extends BaseAction<Category>{
	
	//private Category category; 
	
	//Ϊ��ֱ�۵Ŀ�����spring����ǰ���кβ�ͬ
	//private CategoryService categoryService; ����ȡ����BaseAction��
	
	public String queryJoinAccount(){
		
		//�����洢��ҳ������
		pageMap = new HashMap<String, Object>();
		
		//���ݹؼ��ֺͷ�ҳ�Ĳ�����ѯ��Ӧ�����ݡ��������������Service���Ѿ�д���ˡ�ͨ���̳�BaseAction�����Ӧ����
		List<Category> categoryList = categoryService.queryJoinAccount(model.getType(), page, rows);
		//List<Category> categoryList = categoryService.query();
	
		
		//�洢ΪJSON��ʽ������һ�ڵ�json�ļ����Կ�����һ��key��total,һ��key��rows,�����Ȱ�rows��ź�
		pageMap.put("rows", categoryList);
		System.out.println("categoryList :"+categoryList.size());
		//���ݹؼ��ֲ�ѯ�ܼ�¼��
		
		Long total = categoryService.getCount(model.getType());
		
		//�洢ΪJSON��ʽ���ٰ�total��ź�
	    pageMap.put("total", total);	
		
		return "jsonMap";
		
		
	}
	
	public String deleteByIds(){
		System.out.println(ids);
		categoryService.deleteByIds(ids);
		//���ɾ���ɹ�������ִ�У����ǽ�"true"��������ʽ����ǰ̨
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
		
	}
	
	
	public void update(){
		System.out.println("-----update-----");
		System.out.println(model.getId()+","+model.getType()+","+model.getAccount());
		categoryService.update(model); //ֱ��ʹ��model����category
		
		
	}
	
	public void save(){
		
		System.out.println(model);
		
		categoryService.save(model);
		
	}
	
	public String query(){
		
		//��һ�ַ���
		/*ActionContext.getContext().put("categorylist", categoryService.query());
		ActionContext.getContext().getSession().put("categorylist", categoryService.query());
		ActionContext.getContext().getApplication().put("categorylist", categoryService.query());*/
		
		//�ڶ��ַ���
		/*request.put("categorylist", categoryService.query());
		session.put("categorylist", categoryService.query());
		application.put("categorylist", categoryService.query());*/
		
		jsonList = categoryService.query();
		
		return "jsonList";
	}

/*	public Category getCategory() {
		System.out.println("����getCategory���� ��"+category.getId()+","+category.getType());
		return category;
	}

	public void setCategory(Category category) {
		System.out.println("����setCategory���� ��"+category.getId()+","+category.getType());
		this.category = category;
	}*/
	
	/*public CategoryService getCategoryService() {
		return categoryService;
	}
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}*/
	
	//ʹ��ModelDriven�ӿڱ���ʵ��getModel()�������˷�����ѷ��ص���ѹ��ջ��
	/*@Override
	public Category getModel() {
		 return super.getModel();
	}*/
	
}
