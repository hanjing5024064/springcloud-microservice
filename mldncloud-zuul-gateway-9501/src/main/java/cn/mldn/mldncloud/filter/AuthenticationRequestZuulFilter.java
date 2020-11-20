package cn.mldn.mldncloud.filter;

import java.nio.charset.Charset;
import java.util.Base64;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AuthenticationRequestZuulFilter extends ZuulFilter {	// 定义认证过滤器

	@Override
	public Object run() {
		RequestContext currentContext = RequestContext.getCurrentContext() ; // 获取当前请求的上下文
		String auth = "mldnjava:hello"; // 认证的原始信息
		byte[] encodedAuth = Base64.getEncoder()
				.encode(auth.getBytes(Charset.forName("US-ASCII"))); // 进行一个加密的处理
		// 在进行授权的头信息内容配置的时候加密的信息一定要与“Basic”之间有一个空格
		String authHeader = "Basic " + new String(encodedAuth);
		currentContext.addZuulRequestHeader("Authorization", authHeader);
		return currentContext;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;	// 设置优先级，数字越大优先级越低
	}

	@Override
	public String filterType() {
		return "pre";	// 执行过滤器前配置

	}

}
