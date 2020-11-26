package cn.mldn.mldncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
@SpringBootApplication
@EnableAuthorizationServer // 启动授权服务
@EnableJpaRepositories(basePackages="cn.mldn.mldncloud.dao")
public class StartOAuthServerApplication8701 {
	public static void main(String[] args) {
		SpringApplication.run(StartOAuthServerApplication8701.class, args);
	}
} 
