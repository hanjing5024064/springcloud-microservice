package cn.mldn.mldncloud.service;

import java.util.List;

import cn.mldn.mldncloud.dto.DeptDTO;

public interface IDeptService {
	public DeptDTO add(DeptDTO dto) ;		// 增加新部门
	public DeptDTO get(long deptno) ;	// 根据部门编号获取部门信息
	public List<DeptDTO> list() ;		// 部门信息列表
}
