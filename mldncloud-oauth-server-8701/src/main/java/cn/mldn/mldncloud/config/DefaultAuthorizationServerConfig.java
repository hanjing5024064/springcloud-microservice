package cn.mldn.mldncloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers
.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration
.AuthorizationServerConfigurerAdapter;

import cn.mldn.mldncloud.security.util.DefaultClientDetailsService;
@Configuration
public class DefaultAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(new DefaultClientDetailsService()) ;
	}
}

