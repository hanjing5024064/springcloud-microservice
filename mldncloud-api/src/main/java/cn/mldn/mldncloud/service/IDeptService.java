package cn.mldn.mldncloud.service;

import java.util.List;

import cn.mldn.mldncloud.to.DeptTO;

public interface IDeptService {
	public boolean add(DeptTO to) ;		// 增加新部门
	public DeptTO get(long deptno) ;	// 根据部门编号获取部门信息
	public List<DeptTO> list() ;		// 部门信息列表
}
