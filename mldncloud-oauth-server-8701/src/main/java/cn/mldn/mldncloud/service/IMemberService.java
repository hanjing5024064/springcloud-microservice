package cn.mldn.mldncloud.service;

import java.util.Map;

public interface IMemberService {
	/**
	 * 根据指定的用户编号查询用户的信息以及用户对应的角色信息
	 * @param mid 用户编号
	 * @return 包含有如下返回内容：
	 * key = member、value = 用户信息，如果没有信息返回null
	 * key = allRoles、value = 所有的角色信息 
	 */
	public Map<String,Object> get(String mid) ;
}
