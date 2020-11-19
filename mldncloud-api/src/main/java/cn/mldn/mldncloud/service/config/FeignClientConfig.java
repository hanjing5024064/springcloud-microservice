package cn.mldn.mldncloud.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

@Configuration
public class FeignClientConfig {
	
	@Bean
	public feign.Logger.Level getFeignLoggerLevel() {
		return feign.Logger.Level.FULL ;
	}
	
	@Bean
	public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
		return new BasicAuthRequestInterceptor("mldnjava", "hello");
	}
}
