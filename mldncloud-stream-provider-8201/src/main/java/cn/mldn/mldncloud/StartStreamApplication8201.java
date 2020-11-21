package cn.mldn.mldncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
@SpringBootApplication
@EnableEurekaClient					// 启用Eureka客户端
@EnableDiscoveryClient
@EnableCircuitBreaker				// 启用熔断机制
@EnableHystrix						// 启用Hystrix支持
public class StartStreamApplication8201 {
	public static void main(String[] args) {
		SpringApplication.run(StartStreamApplication8201.class, args);
	}
} 
