package com.bindong.shop.listener;

import java.util.Timer;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import com.bindong.shop.threadTask.ProductTimerTask;
import com.bindong.shop.utils.FileUpload;

//��������web������������tomcatʵ����������springʵ���������ܷŵ�Spring��,��web.xml������
public class InitDataListener implements ServletContextListener {
	// ServletContextListener �ӿڣ����ܹ����� ServletContext ������������ڣ�ʵ���Ͼ��Ǽ��� Web
	// Ӧ�õ���������

	private ProductTimerTask productTimerTask;
	private ApplicationContext applicationContext = null;
	private FileUpload fileUpload;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}

	/*
	 * ��Servlet ��������Web Ӧ��ʱ���ø÷������ڵ�����÷���֮�������ٶ�Filter ��ʼ���� ���Ҷ���Щ��Web
	 * Ӧ������ʱ����Ҫ����ʼ����Servlet ���г�ʼ����
	 */
	@Override
	public void contextInitialized(ServletContextEvent event) {

		applicationContext = WebApplicationContextUtils
				.getWebApplicationContext(event.getServletContext());
		// �������ļ��л�ȡProductTimerTask����
		productTimerTask = (ProductTimerTask) applicationContext
				.getBean("productTimerTask");

		// ���������Ϣ
		// categoryService = (CategoryService)
		// applicationContext.getBean("categoryService");

		// ������Ʒ��Ϣ
		// productService = (ProductService)
		// applicationContext.getBean("productService");

		// �����ö��󽻸�producTimerTask,��ΪproductTimerTask�������ò���application�ģ�ֻ��ͨ��������set����
		productTimerTask.setServletContext(event.getServletContext());

		// ͨ�����ö�ʱ��������ҳ����ÿСʱͬ��һ��(����Ϊ�ػ��߳�)
		new Timer(true).schedule(productTimerTask, 0, 1000 * 60 * 60);
		// ���洢����ͼƬ������ŵ�application�У���Ŀ������ʱ�����
		fileUpload = (FileUpload) applicationContext.getBean("fileUpload");
		event.getServletContext().setAttribute("bankImageList",
				fileUpload.getBankImage());

	}

}
