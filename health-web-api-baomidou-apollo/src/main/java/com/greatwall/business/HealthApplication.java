package com.greatwall.business;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * @author xingkong
 */
@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@ComponentScan(basePackages={"xingkong.framework", "com.greatwall.business"})
@MapperScan({"com.greatwall.business.db.*.dao"})
@ServletComponentScan
@EnableApolloConfig
public class HealthApplication {

	/**
	 * 网站主程序
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled","false");
		System.setProperty("es.set.netty.runtime.available.processors", "false");
		
		SpringApplication app = new SpringApplication(HealthApplication.class);
		// app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
	
	public void run(String... args) throws Exception {
		log.info("[+_+] 启动Health Web API 程序");

	}
	
}