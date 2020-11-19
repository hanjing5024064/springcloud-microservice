package cn.mldn.mldncloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication  
@EnableEurekaClient
@EnableFeignClients(basePackages={"cn.mldn.mldncloud.service"})	// 定义Feign接口扫描包
public class StartWebConsumerApplication80 {
	public static void main(String[] args) {
		SpringApplication.run(StartWebConsumerApplication80.class, args);
	}
}
 