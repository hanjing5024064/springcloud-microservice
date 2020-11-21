package cn.mldn.mldncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;
@SpringBootApplication
@EnableZipkinServer					// 启用Zipkin服务
public class StartSleuthApplication8601 {
	public static void main(String[] args) {
		SpringApplication.run(StartSleuthApplication8601.class, args);
	}
} 
