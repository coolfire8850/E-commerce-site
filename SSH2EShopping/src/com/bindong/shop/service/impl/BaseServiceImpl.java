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

@Service("baseService") //ͨ��ע�ⷽʽ���Ͳ���Ҫ��beans.xml�н���������
@Lazy(true)

public class BaseServiceImpl<T> implements BaseService<T> {
	
	//clazz�д洢�˵�ǰ�Ĳ������ͣ�������T
	private Class clazz;
	/*@Resource //�����������棬�Ͳ������set������ʹ�÷���ע�����������ȥ��set�����ˡ�Ĭ�ϰ�����װ�䣬���Ҳ���������ƥ���bean�Żᰴ����װ�䡣
	private SessionFactory sessionFactory;*/
	
	
	public BaseServiceImpl(){
		
		System.out.println("��ǰ���ù��췽���Ķ���"+this);
		System.out.println("��ȡ��ǰthis����ĸ�����Ϣ"+this.getClass().getSuperclass());
		System.out.println("��ȡ��ǰthis����ĸ�����Ϣ(����������Ϣ)"+this.getClass().getGenericSuperclass());
		//�õ����͵Ĳ�������
		ParameterizedType typeParameterized = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) typeParameterized.getActualTypeArguments()[0];
		System.out.println(clazz.getSimpleName());
	}
	
	@PostConstruct
	public void init() {
		//����clazz�����ͣ��Ѳ�ͬ��dao�����Ƹ�baseDao����
		String clazzName = clazz.getSimpleName();
		String clazzDao = clazzName.substring(0, 1).toLowerCase() 
				+ clazzName.substring(1) + "Dao"; //����Account==>accountDao
		System.out.println(clazzDao);
		try {
//			Field clazzField = this.getClass().getField(clazzDao);
//			Field baseField = this.getClass().getField("baseDao");
			Field clazzField = this.getClass().getSuperclass().getDeclaredField(clazzDao);
			Field baseField = this.getClass().getSuperclass().getDeclaredField("baseDao");
			baseField.set(this, clazzField.get(this)); //baseDao����ֵ��
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	//@Resource //baseDao�Ƿ��ͣ����ܹ�ע��ֻ��ͨ�������init������ֵ
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
		//System.out.println("������getSession����");
		return sessionFactory.getCurrentSession();
	}*/
	
	//ע�����sessionFactory
	/*public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

}
