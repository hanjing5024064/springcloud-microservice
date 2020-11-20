package cn.mldn.mldncloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.mldn.mldncloud.filter.AuthenticationRequestZuulFilter;

@Configuration
public class ZuulConfig {
	@Bean
	public AuthenticationRequestZuulFilter getAuthorizedRequestFilter() {
		return new AuthenticationRequestZuulFilter() ;		// 定义过滤器配置Bean
	}
}
