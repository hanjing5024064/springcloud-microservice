package cn.mldn.mldncloud.rest;

import java.security.Principal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ResourceRest {
	@RequestMapping("/user")						// 资源路径
	public Principal resource(Principal user) {		// 访问资源
		return user ;
	}
}

