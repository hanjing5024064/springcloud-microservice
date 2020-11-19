package cn.mldn.commons.config;

import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
public class RibbonLoadBalanceConfig {
	@Bean
	public IRule ribbonRule() { 			// 其中IRule就是所有规则的标准
		return new com.netflix.loadbalancer.RandomRule(); // 随机的访问策略
	}
	@Bean
	public IPing ribbonPing() {				// 定义Ping策略
		return new com.netflix.loadbalancer.PingUrl() ;
	}
}
