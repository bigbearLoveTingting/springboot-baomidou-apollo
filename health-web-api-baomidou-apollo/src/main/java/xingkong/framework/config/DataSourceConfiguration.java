package xingkong.framework.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 
 * 将dataSource注入到IOC容器中
 * 
 * @author 尹雄标
 *
 */
@Configuration
public class DataSourceConfiguration {
	/**
	 * 数据库驱动
	 */
	@Value("${spring.datasource.driver-class-name}")
	private String jdbcDriver;
	/**
	 * Url
	 */
	@Value("${spring.datasource.url}")
	private String jdbcUrl;
	/**
	 * 用户名
	 */
	@Value("${spring.datasource.username}")
	private String jdbcUsername;
	/**
	 * 密码
	 */
	@Value("${spring.datasource.password}")
	private String jdbcPassword;

	/**
	 * 生成与spring-dao.xml对应的bean dataSource
	 * 
	 * @return
	 * @throws PropertyVetoException
	 */
	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return new DruidDataSource();
	}
}
