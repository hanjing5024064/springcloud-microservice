package cn.mldn.mldncloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.config.annotation.configurers
.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration
.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import cn.mldn.mldncloud.security.util.DefaultClientDetailsService;
@Configuration
public class DefaultAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	@Autowired 
	private RedisConnectionFactory redisConnectionFactory ; // 自动注入Redis连接对象
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// 建立一个Token存储的配置项，此时将Token直接保存在Redis之中
		endpoints.tokenStore(new RedisTokenStore(this.redisConnectionFactory)) ;
	}
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.withClientDetails(new DefaultClientDetailsService()) ;
	}
}

