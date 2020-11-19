package cn.mldn.mldncloud.consumer;			// 无法扫描到Fallback类

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication  
@EnableEurekaClient
@ComponentScan("cn.mldn.mldncloud.service,cn.mldn.mldncloud.consumer")
@EnableFeignClients(basePackages={"cn.mldn.mldncloud.service"})	// 定义Feign接口扫描包
public class StartWebConsumerApplication80 {
	public static void main(String[] args) {
		SpringApplication.run(StartWebConsumerApplication80.class, args);
	}
}
 