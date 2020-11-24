package cn.mldn.mldncloud.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.mldn.mldncloud.dao.IClientDAO;
import cn.mldn.mldncloud.po.Client;
import cn.mldn.mldncloud.service.IClientService;
@Service
public class ClientServiceImpl implements IClientService {
	@Autowired
	private IClientDAO clientDAO ;
	@Override
	public Map<String, Object> get(String clientId) {
		Map<String,Object> map = new HashMap<String,Object>() ;
		Client client = this.clientDAO.findOne(clientId) ;	// 查询客户信息
		if (client != null) {								// 客户信息存在
			map.put("allAuthorities", this.clientDAO.findAllAuthoritiesByClient(clientId)) ;
		}
		map.put("client", client) ; 
		return map;
	}
}
