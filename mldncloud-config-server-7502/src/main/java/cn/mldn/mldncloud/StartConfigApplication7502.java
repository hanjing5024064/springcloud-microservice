package cn.mldn.mldncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient					// 启用Eureka客户端
@EnableDiscoveryClient
@EnableConfigServer					// 配置服务器
public class StartConfigApplication7502 {
	public static void main(String[] args) {
		SpringApplication.run(StartConfigApplication7502.class, args);
	}
} 
