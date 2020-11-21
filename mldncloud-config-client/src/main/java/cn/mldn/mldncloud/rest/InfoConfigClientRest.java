package cn.mldn.mldncloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mldn.mldncloud.config.InfoConfig;

@RestController
public class InfoConfigClientRest {
	@Autowired
	private InfoConfig infoConfig;	// 注入InfoConfig对象 
	@GetMapping("/config")
	public Object getConfig() {		// 取得配置信息
		return "ApplicationName = " + this.infoConfig.getAppName()
			+ "、CompanyName = " + this.infoConfig.getCompanyName()
			+ "、ApplicationVersion = " + this.infoConfig.getAppVersion();
	}
}
