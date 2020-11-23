package cn.mldn.mldncloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
@SpringBootApplication
@EnableZipkinStreamServer	
public class StartSleuthApplication8601 {
	public static void main(String[] args) {
		SpringApplication.run(StartSleuthApplication8601.class, args);
	}
} 
