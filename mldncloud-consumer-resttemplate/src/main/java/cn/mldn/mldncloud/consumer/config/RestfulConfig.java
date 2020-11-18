package cn.mldn.mldncloud.consumer.config;

import java.nio.charset.Charset;
import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestfulConfig {
	@Bean
	public HttpHeaders getHeaders() { 				// Http头信息配置
		HttpHeaders headers = new HttpHeaders(); 	// 定义HTTP的头信息
		String auth = "mldnjava:hello"; 			// 认证的原始信息
		byte[] encodedAuth = Base64.getEncoder()
				.encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行加密的处理
		// 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
		String authHeader = "Basic " + new String(encodedAuth);
		headers.set("Authorization", authHeader);	// 保存头信息
		return headers;
	}

	@Bean 
	public RestTemplate getRestTemplate() {
		return new RestTemplate() ;			// 实例化RestTemplate对象
	}
}
