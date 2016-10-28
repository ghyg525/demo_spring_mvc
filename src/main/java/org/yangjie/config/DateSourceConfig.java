package org.yangjie.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 数据库连接配置
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DateSourceConfig {

	@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.initialSize}")
	private int initialSize;
	@Value("${jdbc.maxActive}")
	private int maxActive;
	@Value("${jdbc.minIdle}")
	private int minIdle;
	@Value("${jdbc.maxIdle}")
	private int maxIdle;
	@Value("${jdbc.maxWait}")
	private int maxWait;
	@Value("${jdbc.removeAbandoned}")
	private boolean removeAbandoned;
	@Value("${jdbc.removeAbandonedTimeout}")
	private int removeAbandonedTimeout;
	@Value("${jdbc.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;
	@Value("${jdbc.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;


	@Bean
	public DataSource dataSourceConfig() {
		PoolProperties poolProperties = new PoolProperties();
		poolProperties.setDriverClassName(driver);
		poolProperties.setUrl(url);
		poolProperties.setUsername(username);
		poolProperties.setPassword(password);
		// 连接池配置
		poolProperties.setInitialSize(initialSize);
		poolProperties.setMaxActive(maxActive);
		poolProperties.setMinIdle(minIdle);
		poolProperties.setMaxIdle(maxIdle);
		poolProperties.setMaxWait(maxWait);
		poolProperties.setRemoveAbandoned(removeAbandoned);
		poolProperties.setRemoveAbandonedTimeout(removeAbandonedTimeout);
		poolProperties.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		poolProperties.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		return new DataSource(poolProperties);
	}
	
}
