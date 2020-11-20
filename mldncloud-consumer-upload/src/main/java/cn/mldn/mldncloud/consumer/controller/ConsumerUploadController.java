package cn.mldn.mldncloud.consumer.controller;

import java.nio.charset.Charset;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class ConsumerUploadController {
	// 设置要进行远程上传微服务调用的代理地址
	public static final String UPLOAD_URL = "http://gateway-9501.com:9501/zuul/mldn-proxy/upload-proxy/upload";
	@RequestMapping(value = "/consumer/uploadPre", method = RequestMethod.GET)
	public String uploadPre() {
		return "upload";
	}
	@RequestMapping(value = "/consumer/upload", method = RequestMethod.POST)
	public @ResponseBody Object upload(String name, MultipartFile photo) throws Exception {
		if (photo != null) {
			CloseableHttpClient httpClient = HttpClients.createDefault(); 	// 创建一个HttpClient对象
			CredentialsProvider credsProvider = new BasicCredentialsProvider(); // 创建了一个具有认证访问的信息
			Credentials credentials = new UsernamePasswordCredentials("zdmin",
					"mldnjava"); 											// 创建一条认证操作信息
			credsProvider.setCredentials(AuthScope.ANY, credentials); 		// 现在所有的认证请求都使用一个认证信息
			HttpClientContext httpContext = HttpClientContext.create(); 	// 创建Http处理操作的上下文对象
			httpContext.setCredentialsProvider(credsProvider);				// 设置认证的提供信息
			HttpPost httpPost = new HttpPost(UPLOAD_URL); 					// 设置要进行访问的请求地址
			HttpEntity entity = MultipartEntityBuilder.create()
					.addBinaryBody("photo", photo.getBytes(),
						ContentType.create("image/png"), "temp.png").build();
			httpPost.setEntity(entity);	// 将请求的实体信息进行发送
			HttpResponse response = httpClient.execute(httpPost, httpContext) ;	// 执行请求的发送
			return EntityUtils.toString(response.getEntity(),Charset.forName("UTF-8")) ;
		} 
		return "nophoto";
	}
}

