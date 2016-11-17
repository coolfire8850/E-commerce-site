package com.bindong.shop.action;

import java.io.ByteArrayInputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bindong.shop.model.Product;

@Controller("productAction")
@Scope("prototype")
public class ProductAction extends BaseAction<Product> {

	public String queryJoinCategory() {
		System.out.println("name :" + model.getName());
		System.out.println("page :" + page);
		System.out.println("rows :" + rows);

		pageMap = new HashMap<String, Object>();
		List<Product> products = productService.queryJointCategory(
				model.getName(), page, rows);
		// List<Product> products = productService.query();
		pageMap.put("rows", products);

		Long total = productService.getCount(model.getName());
		pageMap.put("total", total);

		return "jsonMap";
	}

	public String deleteByIds() {

		productService.deleteByIds(ids);
		// ��trueת��Ϊ�ֽ����飬ͨ������ʽ�ش���struts
		inputStream = new ByteArrayInputStream(("true").getBytes());

		return "stream";
	}

	public void save() throws Exception {
		// fileUpload�����౻��ȡ�ˣ�uploadFile����ֱ�ӽ���һ��fileImage���󣬷����µ�ͼƬ��
		String pic = fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		model.setDate(new Timestamp(new Date().getTime()));
		productService.save(model);

	}

	public void update() throws Exception {
		// fileUpload�����౻��ȡ�ˣ�uploadFile����ֱ�ӽ���һ��fileImage���󣬷����µ�ͼƬ��
		String pic = fileUpload.uploadFile(fileImage);
		System.out.println("���غ��pic����"+pic);
		model.setPic(pic);
		model.setDate(new Timestamp(new Date().getTime()));
		productService.update(model);
	}
	
	public String get(){
		//key��Ӧҳ���еı��ʽ�е�product
		System.out.println("ҳ�洫������idΪ��"+model.getId());
		request.put("product", productService.get(model.getId()));
		
		return "details";
	}
	
	public String search(){
		
		System.out.println("ҳ�洫������nameΪ��"+model.getName());
		for(Product p :productService.queryJointCategory(model.getName())){
			System.out.println(p);
		}
		request.put("product", productService.queryJointCategory(model.getName()));
		return "search";
	}
}
