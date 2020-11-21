package cn.mldn.mldncloud.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {
	@Value("${spring.application.name}")
	private String applicationName; // 应用的服务名称
	@Value("${eureka.client.service-url.defaultZone}")
	private String eurekaServers; // 设置所有的eureka服务信息项
	@GetMapping("/config") 
	public String getConfig() {
		return "ApplicationName = " + this.applicationName + "、EurekaServers = "
				+ this.eurekaServers;
	}
}
