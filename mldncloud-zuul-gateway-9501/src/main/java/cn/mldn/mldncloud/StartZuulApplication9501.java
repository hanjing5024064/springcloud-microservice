package cn.mldn.mldncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
@SpringBootApplication
@EnableZuulProxy
public class StartZuulApplication9501 {
	public static void main(String[] args) {
		SpringApplication.run(StartZuulApplication9501.class, args);
	}
} 
