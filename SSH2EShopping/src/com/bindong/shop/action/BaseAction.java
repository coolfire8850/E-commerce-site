package com.bindong.shop.action;

import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.bindong.shop.model.FileImage;
import com.bindong.shop.service.AccountService;
import com.bindong.shop.service.CategoryService;
import com.bindong.shop.service.ProductService;
import com.bindong.shop.service.ShoppingcartService;
import com.bindong.shop.service.SorderService;
import com.bindong.shop.service.UserService;
import com.bindong.shop.utils.FileUpload;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//因为有很多不同的Model都需要使用modeldriven,所以这里使用泛型
@Controller("baseAction")
@Scope("prototype")
public class BaseAction <T> extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware,ModelDriven<T>{
	
	@Resource
	protected UserService userService;
	
	//注入购物车类
	@Resource
	protected ShoppingcartService shoppingcartService;
	@Resource
	protected SorderService sorderService;
	
	//封装了图片信息的类
	protected FileImage fileImage;
	
	//上传工具文件类,在FileUploadUtil类中进行了@Component("fileUpload")注解
	@Resource  
	protected FileUpload fileUpload;
	
	//用来装有将要被打包成json格式返回给前台的数据，下面要实现get方法
	protected List<T> jsonList = null;
	
	//获取要删除的ids,要有get和set方法
	//流数据用来向前台返回数据，这个数据由struts获取，然后通过流的形式传到前台，所以实现get方法即可
	
	protected String ids;
	protected InputStream inputStream;
	
	//page和rows与分页有关，pageMap存放查询的数据，然后打包成json的格式
	//page和rows实现get和set方法，pageMap只需要实现get方法即可，因为pageMap不接受前台参数，是让Struts获取
	protected Integer page;
	protected Integer rows;
	protected Map<String, Object> pageMap; //让不同的action自己去实现
	
	
	
	
	//service对象 ,多态性，用接口调用了子类具体实现，相对应的子类impl中有相应的@service注解
	@Resource  //@Resource 默认按名称装配，当找不到与名称匹配的bean才会按类型装配
	protected CategoryService categoryService;
	@Resource
	protected AccountService accountService;
	@Resource 
	protected ProductService productService;
		
	
	//域对象
	protected Map<String, Object> request;
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	
	@Override
	public void setApplication(Map<String, Object> application) {

		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {

		this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {

		this.request = request;
	}
	
	
	
	
	//model driven
	protected T model;

	

	@Override
	public T getModel() {
		// 通过解析传进来的T来new一个对应的实例
	    ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
	    Class clazz = (Class)type.getActualTypeArguments()[0];
	    try {
			model = (T)clazz.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	    return model;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Map<String, Object> getPageMap() {
		return pageMap;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public List<T> getJsonList() {
		return jsonList;
	}

	public FileImage getFileImage() {
		return fileImage;
	}

	public void setFileImage(FileImage fileImage) {
		this.fileImage = fileImage;
	}

	

	



}
