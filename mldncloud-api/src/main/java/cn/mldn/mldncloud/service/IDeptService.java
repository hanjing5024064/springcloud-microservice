package cn.mldn.mldncloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cn.mldn.mldncloud.dto.DeptDTO;
import cn.mldn.mldncloud.service.config.FeignClientConfig;
@FeignClient(value="MLDNCLOUD-DEPT-SERVICE",configuration=FeignClientConfig.class)
public interface IDeptService {
	@PostMapping("/dept/add")
	public DeptDTO add(DeptDTO dto) ;							// 增加新部门
	@GetMapping("/dept/get/{deptno}")
	public DeptDTO get(@PathVariable("deptno") long deptno) ;	// 根据部门编号获取部门信息
	@GetMapping("/dept/list")
	public List<DeptDTO> list() ;								// 部门信息列表
}
