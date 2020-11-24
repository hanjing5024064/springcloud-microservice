package cn.mldn.mldncloud.service;

import java.util.Map;

public interface IClientService { 
	/**
	 * 根据客户的编号（client_id）查询出客户的信息以及对应的授权内容
	 * @param clientId 客户端id
	 * @return 返回的数据包含有如下内容：
	 * key = client、value = Client的对象，如果不存在则null；
	 * key = allAuthorities、value = 当client信息存在时获取授权内容
	 */
	public Map<String,Object> get(String clientId) ;
}
