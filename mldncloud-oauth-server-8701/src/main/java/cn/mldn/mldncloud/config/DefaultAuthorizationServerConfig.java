package cn.mldn.mldncloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers
.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration
.AuthorizationServerConfigurerAdapter;
@Configuration
public class DefaultAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient("cmldn")		// client_id信息
			.secret("cjava")			// client_secret信息
			.autoApprove(true)   		// 直接进行授权控制
			.authorizedGrantTypes("authorization_code")		// 定义授权类型
			.scopes("webapp") ;			// 授权范围
	}
}

