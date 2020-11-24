package cn.mldn.mldncloud.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mldn.mldncloud.dao.IMemberDAO;
import cn.mldn.mldncloud.po.Member;
import cn.mldn.mldncloud.service.IMemberService;

@Service
public class MemberServiceImpl implements IMemberService {
	@Autowired
	private IMemberDAO memberDAO;

	@Override
	public Map<String, Object> get(String mid) {
		Map<String, Object> map = new HashMap<String, Object>();
		Member member = this.memberDAO.findOne(mid);
		if (member != null) {
			map.put("allRoles", this.memberDAO.findAllByMember(mid));
		}
		map.put("member", member);
		return map;
	}

}
