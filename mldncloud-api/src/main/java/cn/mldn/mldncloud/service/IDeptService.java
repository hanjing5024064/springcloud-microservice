package cn.mldn.mldncloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cn.mldn.mldncloud.dto.DeptDTO;
import cn.mldn.mldncloud.service.config.FeignClientConfig;
import cn.mldn.mldncloud.service.fallback.DeptServiceFallbackFactory;

@FeignClient(value = "MLDNCLOUD-ZUUL-GATEWAY", configuration = FeignClientConfig.class, 
	fallbackFactory=DeptServiceFallbackFactory.class)
public interface IDeptService {
	@PostMapping("/mldn-proxy/dept-proxy/dept/add")
	public DeptDTO add(DeptDTO dto) ;							// 增加新部门
	@GetMapping("/mldn-proxy/dept-proxy/dept/get/{deptno}")
	public DeptDTO get(@PathVariable("deptno") long deptno) ;	// 根据部门编号获取部门信息
	@GetMapping("/mldn-proxy/dept-proxy/dept/list")
	public List<DeptDTO> list() ;								// 部门信息列表
}
