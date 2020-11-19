package cn.mldn.mldncloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.mldn.mldncloud.dto.DeptDTO;
import cn.mldn.mldncloud.service.IDeptService;

@RestController 								// 为方便起见使用Restful风格展示
public class DeptController {
	@Autowired
	private IDeptService deptService ;			// 注入远程业务接口对象


	@GetMapping("/consumer/dept/list")
	public Object listDeptRest() {
		return this.deptService.list() ;		// 调用Restful业务方法 

	}

	@GetMapping("/consumer/dept/get")
	public Object getDeptRest(long deptno) {
		return this.deptService.get(deptno);	// 调用Restful业务方法
	}

	@GetMapping("/consumer/dept/add")
	public Object addDeptRest(DeptDTO dept) {	// 传输DeptDTO对象
		return this.deptService.add(dept);		// 调用Restful业务方法
	}

}
