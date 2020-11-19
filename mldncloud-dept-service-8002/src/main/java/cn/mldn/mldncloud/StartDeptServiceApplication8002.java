package cn.mldn.mldncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
@EnableEurekaClient					// 启用Eureka客户端
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages="cn.mldn.mldncloud.dao")
public class StartDeptServiceApplication8002 {
	public static void main(String[] args) {
		SpringApplication.run(StartDeptServiceApplication8002.class, args);
	}
} 
