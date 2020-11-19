package cn.mldn.mldncloud.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import cn.mldn.commons.config.RibbonLoadBalanceConfig;

@SpringBootApplication 
@EnableEurekaClient
@RibbonClient(name="ribbonClient",configuration=RibbonLoadBalanceConfig.class)
public class StartWebConsumerApplication80 {
	public static void main(String[] args) {
		SpringApplication.run(StartWebConsumerApplication80.class, args);
	}
}
 