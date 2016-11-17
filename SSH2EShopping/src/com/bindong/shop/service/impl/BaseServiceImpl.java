package com.bindong.shop.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.io.filefilter.FalseFileFilter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.TrueFalseType;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bindong.shop.dao.AccountDao;
import com.bindong.shop.dao.BaseDao;
import com.bindong.shop.dao.CategoryDao;
import com.bindong.shop.dao.ProductDao;
import com.bindong.shop.dao.ShoppingcartDao;
import com.bindong.shop.dao.SorderDao;
import com.bindong.shop.dao.UserDao;
import com.bindong.shop.service.BaseService;

@Service("baseService") //通过注解方式，就不需要在beans.xml中进行配置了
@Lazy(true)

public class BaseServiceImpl<T> implements BaseService<T> {
	
	//clazz中存储了当前的操作类型，即泛型T
	private Class clazz;
	/*@Resource //放在属性上面，就不会调用set方法，使用反射注入进来，可以去掉set方法了。默认按名称装配，当找不到与名称匹配的bean才会按类型装配。
	private SessionFactory sessionFactory;*/
	
	
	public BaseServiceImpl(){
		
		System.out.println("当前调用构造方法的对象"+this);
		System.out.println("获取当前this对象的父类信息"+this.getClass().getSuperclass());
		System.out.println("获取当前this对象的父类信息(包括泛型信息)"+this.getClass().getGenericSuperclass());
		//拿到泛型的参数类型
		ParameterizedType typeParameterized = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) typeParameterized.getActualTypeArguments()[0];
		System.out.println(clazz.getSimpleName());
	}
	
	@PostConstruct
	public void init() {
		//根据clazz的类型，把不同的dao对象复制给baseDao对象
		String clazzName = clazz.getSimpleName();
		String clazzDao = clazzName.substring(0, 1).toLowerCase() 
				+ clazzName.substring(1) + "Dao"; //例如Account==>accountDao
		System.out.println(clazzDao);
		try {
//			Field clazzField = this.getClass().getField(clazzDao);
//			Field baseField = this.getClass().getField("baseDao");
			Field clazzField = this.getClass().getSuperclass().getDeclaredField(clazzDao);
			Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
			baseField.set(this, clazzField.get(this)); //baseDao就有值了
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//@Resource //baseDao是泛型，不能够注入只能通过上面的init方法赋值
		protected BaseDao baseDao;
		@Resource
		protected AccountDao accountDao;
		@Resource
		protected CategoryDao categoryDao;
		@Resource
		protected ShoppingcartDao shoppingcartDao;
		@Resource
		protected ProductDao productDao;
		@Resource
		protected SorderDao sorderDao;
		@Resource
		protected UserDao userDao;

	@Override
	public void save(T t) {
		// TODO Auto-generated method stub
		//getSession().save(t);
		baseDao.save(t);
	}

	@Override
	public void update(T t) {
		// TODO Auto-generated method stub
		//getSession().update(t);
		baseDao.update(t);
	}

	@Override
	public void delete(int id) {
	
		/*String hql ="delete "+clazz.getSimpleName() + " as c where c.id=:id";
		getSession().createQuery(hql)
					.setInteger("id", id)
					.executeUpdate();*/
		baseDao.delete(id);
	}

	@Override
	public T get(int id) {
		// TODO Auto-generated method stub
		//return (T) getSession().get(clazz, id);
		return (T) baseDao.get(id);
	}

	@Override
	public List<T> query() {
	
		/*String hql ="from "+clazz.getSimpleName();
		return getSession().createQuery(hql).getResultList();*/
		return baseDao.query();
	}

	/*protected Session getSession() {
		//System.out.println("调用了getSession方法");
		return sessionFactory.getCurrentSession();
	}*/
	
	//注入进来sessionFactory
	/*public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

}
