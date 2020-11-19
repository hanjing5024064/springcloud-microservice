package cn.mldn.mldncloud.service.fallback;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.mldn.mldncloud.dto.DeptDTO;
import cn.mldn.mldncloud.service.IDeptService;
import feign.hystrix.FallbackFactory;

@Component
public class DeptServiceFallbackFactory implements FallbackFactory<IDeptService> {

	@Override
	public IDeptService create(Throwable exp) {
		return new IDeptService() {

			@Override
			public DeptDTO add(DeptDTO dto) {
				DeptDTO returnDto = new DeptDTO();
				returnDto.setDeptno(-1L);
				returnDto.setDname("部门名称 - Fallback");
				returnDto.setLoc("部门位置 - Fallback");
				return returnDto;
			}

			@Override
			public DeptDTO get(long deptno) {
				DeptDTO returnDto = new DeptDTO();
				returnDto.setDeptno(deptno);
				returnDto.setDname("部门名称 - Fallback");
				returnDto.setLoc("部门位置 - Fallback");
				return returnDto;
			}

			@Override
			public List<DeptDTO> list() {
				return new ArrayList<DeptDTO>(); 
			}
		};
	}

}
