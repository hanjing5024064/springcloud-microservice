package cn.mldn.mldncloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.mldn.mldncloud.dto.DeptDTO;
import cn.mldn.mldncloud.service.IDeptService;

@RestController
public class DeptRest {
	@Autowired
	private IDeptService deptService ;			// 注入部门业务
	@PostMapping("/dept/add")
	public Object get(@RequestBody DeptDTO dept) {
		return this.deptService.add(dept)  ;	// 增加部门信息
	}
	@GetMapping("/dept/get/{deptno}")
	public Object get(@PathVariable("deptno") long deptno) {
		return this.deptService.get(deptno)  ;	// 查询部门信息
	}
	@GetMapping("/dept/list")
	public Object list() {
		return this.deptService.list() ;		// 部门信息列表
	}
}
