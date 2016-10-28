package org.yangjie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置
 */
@Configuration
@EnableWebMvc // 开启mvc支持
@ComponentScan("org.yangjie") // 包扫描路径
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	@Bean  // 用于读取配置文件
	public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Override   // 配置静态资源路径
	public void addResourceHandlers(ResourceHandlerRegistry registry) {  
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");  
        registry.addResourceHandler("/uploadfile/**").addResourceLocations("/uploadfile/");  
    }

	@Override // 配置默认主页等无逻辑页面映射
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("/login");
	}  
	
}
