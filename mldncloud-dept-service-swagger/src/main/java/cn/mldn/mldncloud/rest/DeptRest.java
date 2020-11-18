package cn.mldn.mldncloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.mldn.mldncloud.dto.DeptDTO;
import cn.mldn.mldncloud.service.IDeptService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class DeptRest {
	@Autowired
	private IDeptService deptService; 				// 注入部门业务

	@ApiOperation(value = "增加部门信息", notes = "增加部门数据，需要传入DTO对象（dname、loc）")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "dept", value = "部门实体", required = true, dataType = "DeptDTO") })
	@PostMapping("/dept/add")
	public Object get(@RequestBody DeptDTO dept) {
		return this.deptService.add(dept); 			// 增加部门信息
	}

	@ApiOperation(value = "获取一个部门信息", notes = "根据部门编号获取一个部门的信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "deptno", value = "部门编号", required = true, 
					paramType = "path", dataType = "Long") })
	@GetMapping("/dept/get/{deptno}")
	public Object get(@PathVariable("deptno") long deptno) {
		return this.deptService.get(deptno); 		// 查询部门信息
	} 

	@ApiOperation(value = "部门信息列表", notes = "将进行部门信息的详细列表")
	@GetMapping("/dept/list")
	public Object list() {
		return this.deptService.list(); 			// 部门信息列表
	}
}
