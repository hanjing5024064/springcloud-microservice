package cn.mldn.mldncloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope	// 如果现在没有这个注解，则在通过SpringCloudBus获取配置信息的时候无法进行刷新
public class InfoConfig {	// 将所有可能动态获取的配置内容写在一个类之中，到处引用
	@Value("${info.app.name}")
	private String appName ;
	@Value("${info.company.name}")
	private String companyName ;
	@Value("${info.app.version}")
	private String appVersion ;
	public String getAppName() {
		return appName;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public String getCompanyName() {
		return companyName;
	}
}

