package cn.mldn.mldncloud.config;
import org.springframework.boot.autoconfigure.security.oauth2.client
.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration
.WebSecurityConfigurerAdapter;
@Configuration
@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.antMatcher("/**")					// 所有的请求都必须经过认证和授权处理
			.authorizeRequests().anyRequest().authenticated()
			.and().authorizeRequests().antMatchers("/","/anon").permitAll()
			.and().csrf().disable() ;
	}
}
