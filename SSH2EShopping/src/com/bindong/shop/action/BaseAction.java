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

//��Ϊ�кܶ಻ͬ��Model����Ҫʹ��modeldriven,��������ʹ�÷���
@Controller("baseAction")
@Scope("prototype")
public class BaseAction <T> extends ActionSupport implements RequestAware,
		SessionAware, ApplicationAware,ModelDriven<T>{
	
	@Resource
	protected UserService userService;
	
	//ע�빺�ﳵ��
	@Resource
	protected ShoppingcartService shoppingcartService;
	@Resource
	protected SorderService sorderService;
	
	//��װ��ͼƬ��Ϣ����
	protected FileImage fileImage;
	
	//�ϴ������ļ���,��FileUploadUtil���н�����@Component("fileUpload")ע��
	@Resource  
	protected FileUpload fileUpload;
	
	//����װ�н�Ҫ�������json��ʽ���ظ�ǰ̨�����ݣ�����Ҫʵ��get����
	protected List<T> jsonList = null;
	
	//��ȡҪɾ����ids,Ҫ��get��set����
	//������������ǰ̨�������ݣ����������struts��ȡ��Ȼ��ͨ��������ʽ����ǰ̨������ʵ��get��������
	
	protected String ids;
	protected InputStream inputStream;
	
	//page��rows���ҳ�йأ�pageMap��Ų�ѯ�����ݣ�Ȼ������json�ĸ�ʽ
	//page��rowsʵ��get��set������pageMapֻ��Ҫʵ��get�������ɣ���ΪpageMap������ǰ̨����������Struts��ȡ
	protected Integer page;
	protected Integer rows;
	protected Map<String, Object> pageMap; //�ò�ͬ��action�Լ�ȥʵ��
	
	
	
	
	//service���� ,��̬�ԣ��ýӿڵ������������ʵ�֣����Ӧ������impl������Ӧ��@serviceע��
	@Resource  //@Resource Ĭ�ϰ�����װ�䣬���Ҳ���������ƥ���bean�Żᰴ����װ��
	protected CategoryService categoryService;
	@Resource
	protected AccountService accountService;
	@Resource 
	protected ProductService productService;
		
	
	//�����
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
		// ͨ��������������T��newһ����Ӧ��ʵ��
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
