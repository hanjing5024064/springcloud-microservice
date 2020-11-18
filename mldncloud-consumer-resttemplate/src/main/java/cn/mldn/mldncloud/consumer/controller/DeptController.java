package cn.mldn.mldncloud.consumer.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.mldn.mldncloud.dto.DeptDTO;

@RestController 							// 为方便起见使用Restful风格展示
public class DeptController {
	public static final String DEPT_ADD_URL = "http://localhost:8001/dept/add";
	public static final String DEPT_GET_URL = "http://localhost:8001/dept/get";
	public static final String DEPT_LIST_URL = "http://localhost:8001/dept/list";
	@Resource
	private RestTemplate restTemplate; 		// 注入RestTemplate对象

	@GetMapping("/consumer/dept/list")
	public Object listDeptRest() {
		return this.restTemplate.getForObject(DEPT_LIST_URL, List.class);
	}

	@GetMapping("/consumer/dept/get")
	public Object getDeptRest(long deptno) {
		DeptDTO dept = this.restTemplate.getForObject(DEPT_GET_URL + "/" + deptno, DeptDTO.class);
		return dept;
	}

	@GetMapping("/consumer/dept/add")
	public Object addDeptRest(DeptDTO dept) {	// 传输DeptDTO对象
		DeptDTO result = this.restTemplate.postForObject(DEPT_ADD_URL, dept, DeptDTO.class);
		return result;
	}

}
