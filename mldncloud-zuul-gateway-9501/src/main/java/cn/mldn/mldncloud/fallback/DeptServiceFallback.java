package cn.mldn.mldncloud.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
@Component
public class DeptServiceFallback implements FallbackProvider {	// 失败回退
	@Override
	public String getRoute() {
		return "mldncloud-dept-service";						// 微服务名称
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return new ClientHttpResponse() {
			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream(
					("{\"deptno\":-99,\"dname\":\"【ERROR】Zuul-Fallback\""
					+ ",\"loc\":\"Gateway客户端提供\"}").getBytes());	// 当出现服务调用错误之后返回的数据内容
			}
			@Override
			public HttpHeaders getHeaders() {					// 返回头信息
				HttpHeaders headers = new HttpHeaders() ;
				headers.set("Content-Type", "text/html; charset=UTF-8");
				return headers;
			}
			@Override
			public HttpStatus getStatusCode() throws IOException {	// http状态码
				return HttpStatus.BAD_REQUEST;
			}
			@Override
			public int getRawStatusCode() throws IOException {	// http状态码
				return HttpStatus.BAD_REQUEST.value();
			}
			@Override
			public String getStatusText() throws IOException {	// 状态信息
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}
			@Override
			public void close() {	
			}
		};
	}

	@Override
	public ClientHttpResponse fallbackResponse(Throwable cause) {
		return this.fallbackResponse();
	}

}
