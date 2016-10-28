package org.yangjie.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 初始化
 * 将spring加载到serverlet生命周期
 */
public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext(); 
		// 注册配置文件
		applicationContext.register(WebMvcConfig.class); 
		
		// 动态加载spring-mvc的核心servlet
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(applicationContext)); 
		// 是否在容器启动时加载, 数值越大优先级越高, 值小于零或无时调用时加载
		dispatcher.setLoadOnStartup(1); 
		// spring mvc servlet拦截路径
		dispatcher.addMapping("/");	 
		

	}
	
	
}
