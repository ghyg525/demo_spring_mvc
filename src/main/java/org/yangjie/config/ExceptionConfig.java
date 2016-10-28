package org.yangjie.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * 异常处理配置
 * @author YangJie [2016年8月8日 下午2:31:12]
 */
@Configuration
public class ExceptionConfig {

	/**
	 * 方法1:
	 * 使用spring的HandlerExceptionResolver实现类: SimpleMappingExceptionResolver
	 * @author YangJie [2016年8月8日 下午2:31:23]
	 * @return
	 */
	@Bean // 统一异常处理
	public SimpleMappingExceptionResolver initMappingExceptionResolver(){
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		exceptionResolver.setDefaultErrorView("/error.jsp"); // 默认的异常处理页面
		return exceptionResolver;
	}
	
	/**
	 * 方法2:
	 * 自己实现HandlerExceptionResolver接口
	 * 实例化实现类到spring容器
	 */
	
	/**
	 * 方法3:
	 * 使用@ExceptionHandler注解
	 * 配合@ControllerAdvice注解实现全局
	 */
}
