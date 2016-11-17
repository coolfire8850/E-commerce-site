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
		// 把true转化为字节数组，通过流方式回传给struts
		inputStream = new ByteArrayInputStream(("true").getBytes());

		return "stream";
	}

	public void save() throws Exception {
		// fileUpload工具类被抽取了，uploadFile方法直接接受一个fileImage对象，返回新的图片名
		String pic = fileUpload.uploadFile(fileImage);
		model.setPic(pic);
		model.setDate(new Timestamp(new Date().getTime()));
		productService.save(model);

	}

	public void update() throws Exception {
		// fileUpload工具类被抽取了，uploadFile方法直接接受一个fileImage对象，返回新的图片名
		String pic = fileUpload.uploadFile(fileImage);
		System.out.println("返回后的pic名称"+pic);
		model.setPic(pic);
		model.setDate(new Timestamp(new Date().getTime()));
		productService.update(model);
	}
	
	public String get(){
		//key对应页面中的表达式中的product
		System.out.println("页面传进来的id为："+model.getId());
		request.put("product", productService.get(model.getId()));
		
		return "details";
	}
	
	public String search(){
		
		System.out.println("页面传进来的name为："+model.getName());
		for(Product p :productService.queryJointCategory(model.getName())){
			System.out.println(p);
		}
		request.put("product", productService.queryJointCategory(model.getName()));
		return "search";
	}
}
