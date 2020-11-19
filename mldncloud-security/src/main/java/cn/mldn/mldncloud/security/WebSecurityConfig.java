package cn.mldn.mldncloud.security;				// 此包可以为服务扫描子包

import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {	// 建立安全配置
	@Resource
	public void configGlobal(AuthenticationManagerBuilder auth)
			throws Exception {								// 配置用户名与密码
		auth.inMemoryAuthentication().withUser("mldnjava").password("hello")
				.roles("USER").and().withUser("admin").password("hello")
				.roles("USER", "ADMIN").and();
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 表示所有的访问都必须进行认证处理后才可以正常进行
		http.httpBasic().and().authorizeRequests().anyRequest()
				.fullyAuthenticated().and().csrf().disable();
		// 所有的Restful服务一定要设置为无状态，以提升操作性能
		http.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
}
