package cn.mldn.mldncloud.rest;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cn.mldn.mldncloud.dto.DeptDTO;
import cn.mldn.mldncloud.service.IDeptService;

@RestController
public class DeptRest {
	@Autowired
	private IDeptService deptService ;			// 注入部门业务
	
	@Resource
	private DiscoveryClient client ;	// 进行Eureka的发现服务
	@RequestMapping("/dept/discover")
	@HystrixCommand						// Hystrix监控注解
	public Object discover() {	// 直接返回发现服务信息
		return this.client ;
	}
	
	@PostMapping("/dept/add")
	@HystrixCommand					// Hystrix监控注解
	public Object add(@RequestBody DeptDTO dept) {
		return this.deptService.add(dept)  ;	// 增加部门信息
	}
	@GetMapping("/dept/get/{deptno}")
	@HystrixCommand					// Hystrix监控注解
	public Object get(@PathVariable("deptno") long deptno) {
		if (deptno == 0L) {	// 抛出异常
			throw new RuntimeException("Invalidate Dept Info") ;
		}
		return this.deptService.get(deptno)  ;	// 查询部门信息
	}
	@GetMapping("/dept/list")
	@HystrixCommand(fallbackMethod="listFallback")// Hystrix监控注解,当list方法执行有问题时会自动调用listFallback()方法进行失败处理
	public Object list() {
		return this.deptService.list() ;		// 部门信息列表
	}
	
	public Object listFallback() {
		return new ArrayList<DeptDTO>();
	}
}
