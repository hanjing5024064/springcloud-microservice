package cn.mldn.mldncloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mldn.mldncloud.dao.IDeptDAO;
import cn.mldn.mldncloud.dto.DeptDTO;
import cn.mldn.mldncloud.po.Dept;
import cn.mldn.mldncloud.service.IDeptService;
@Service
public class DeptServiceImpl implements IDeptService {
	@Autowired
	private IDeptDAO deptDAO ;					// 注入DAO接口对象
	@Override
	public DeptDTO add(DeptDTO dto) {			// 增加新部门
		Dept po = new Dept() ;					// 创建持久化对象
		BeanUtils.copyProperties(dto, po);		// 将DTO对象内容拷贝到持久化对象PO之中
		DeptDTO returnTO = new DeptDTO() ;		// 定义业务方法返回对象
		BeanUtils.copyProperties(this.deptDAO.save(po), returnTO);	// 将业务返回结果保存到TO
		return returnTO ;
	}

	@Override
	public DeptDTO get(long deptno) {			// 根据部门编号获取一个部门信息
		Dept po = this.deptDAO.getOne(deptno) ;	// 通过数据层获取持久化对象
		DeptDTO dto = new DeptDTO() ;			// 定义传输对象
		BeanUtils.copyProperties(po, dto); 		// 将持久化PO对象内容拷贝到传输对象DTO中
		return dto;
	}
 
	@Override
	public List<DeptDTO> list() {				// 部门列表
		List<Dept> allDepts = this.deptDAO.findAll() ;			// 查询全部部门信息
		List<DeptDTO> returnDepts = new ArrayList<DeptDTO>() ;	// 定义返回集合
		allDepts.forEach((dept)->{								// 将持久化对象集合保存到传输对象集合
			DeptDTO dto = new DeptDTO() ;
			BeanUtils.copyProperties(dept, dto);// 对象拷贝
			returnDepts.add(dto) ;				// 保存全部DTO对象
		});
		return returnDepts;
	}

}
