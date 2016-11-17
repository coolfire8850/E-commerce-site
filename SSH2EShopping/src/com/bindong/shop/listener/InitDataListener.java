package com.bindong.shop.listener;

import java.util.Timer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.bindong.shop.threadTask.ProductTimerTask;
import com.bindong.shop.utils.FileUpload;

//监听器是web层的组件，它由tomcat实例化，不是spring实例化，不能放到Spring中,在web.xml中配置
public class InitDataListener implements ServletContextListener {
	// ServletContextListener 接口，它能够监听 ServletContext 对象的生命周期，实际上就是监听 Web
	// 应用的生命周期

	private ProductTimerTask productTimerTask;
	private ApplicationContext applicationContext = null;
	private FileUpload fileUpload;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	/*
	 * 当Servlet 容器启动Web 应用时调用该方法。在调用完该方法之后，容器再对Filter 初始化， 并且对那些在Web
	 * 应用启动时就需要被初始化的Servlet 进行初始化。
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {

		applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(event.getServletContext());
		// 从配置文件中获取ProductTimerTask对象
		productTimerTask = (ProductTimerTask) applicationContext
				.getBean("productTimerTask");

		// 加载类别信息
		// categoryService = (CategoryService)
		// applicationContext.getBean("categoryService");

		// 加载商品信息
		// productService = (ProductService)
		// applicationContext.getBean("productService");

		// 把内置对象交给producTimerTask,因为productTimerTask里面是拿不到application的，只能通过监听器set给它
		productTimerTask.setServletContext(event.getServletContext());

		// 通过设置定时器，让首页数据每小时同步一次(配置为守护线程)
		new Timer(true).schedule(productTimerTask, 0, 1000 * 60 * 60);
		// 将存储银行图片的数组放到application中，项目启动的时候加载
		fileUpload = (FileUpload) applicationContext.getBean("fileUpload");
		event.getServletContext().setAttribute("bankImageList",
				fileUpload.getBankImage());

	}

}
