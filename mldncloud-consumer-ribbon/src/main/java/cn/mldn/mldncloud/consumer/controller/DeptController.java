package cn.mldn.mldncloud.consumer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.mldn.mldncloud.dto.DeptDTO;

@RestController 							// 为方便起见使用Restful风格展示
public class DeptController {
	public static final String DEPT_ADD_URL = "http://MLDNCLOUD-DEPT-SERVICE/dept/add";//域名为微服务在注册中心Eureka注册的名称
	public static final String DEPT_GET_URL = "http://MLDNCLOUD-DEPT-SERVICE/dept/get";
	public static final String DEPT_LIST_URL = "http://MLDNCLOUD-DEPT-SERVICE/dept/list";
	@Resource
	private RestTemplate restTemplate; 		// 注入RestTemplate对象
	@Resource
	private HttpHeaders headers;			// 注入Http头信息对象
	
	@Autowired
	private LoadBalancerClient loadBalancerClient ;	// 客户端信息
	
	@GetMapping("/consumer/client") 
	public Object client() {
		// 获取指定名称的微服务实例对象
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("MLDNCLOUD-DEPT-SERVICE") ;
		Map<String,Object> info = new HashMap<String,Object>() ;
		info.put("host", serviceInstance.getHost()) ;
		info.put("port", serviceInstance.getPort()) ;
		info.put("serviceId", serviceInstance.getServiceId()) ;
		return info ;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/consumer/dept/list")
	public Object listDeptRest() {
		List<DeptDTO> allDepts = this.restTemplate
				.exchange(DEPT_LIST_URL, HttpMethod.GET,
						new HttpEntity<Object>(this.headers), List.class)
				.getBody();					// 访问服务设置头信息
		return allDepts; 

	}

	@GetMapping("/consumer/dept/get")
	public Object getDeptRest(long deptno) {
		DeptDTO dept = this.restTemplate
				.exchange(DEPT_GET_URL + "/" + deptno, HttpMethod.GET,
						new HttpEntity<Object>(this.headers), DeptDTO.class)
				.getBody();					// 访问服务设置头信息
		return dept;
	}

	@GetMapping("/consumer/dept/add")
	public Object addDeptRest(DeptDTO dept) {	// 传输DeptDTO对象
		DeptDTO result = this.restTemplate.exchange(DEPT_ADD_URL, HttpMethod.POST,
				new HttpEntity<Object>(dept, this.headers), DeptDTO.class)
				.getBody(); 				// 访问服务设置头信息
		return result;
	}

}
