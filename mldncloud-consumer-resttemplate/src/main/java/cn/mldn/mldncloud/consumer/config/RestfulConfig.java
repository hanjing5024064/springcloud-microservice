package cn.mldn.mldncloud.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestfulConfig {
	@Bean 
	public RestTemplate getRestTemplate() {
		return new RestTemplate() ;			// 实例化RestTemplate对象
	}
}
