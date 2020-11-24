package cn.mldn.mldncloud.security.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import cn.mldn.mldncloud.po.Client;
import cn.mldn.mldncloud.service.IClientService;
public class DefaultClientDetailsService implements ClientDetailsService {
	@Autowired
	private IClientService clientService ;							// 查询客户对应的信息以及授权信息
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		Map<String,Object> map = this.clientService.get(clientId) ;	// 查询信息
		if (map.get("client") == null) {							// 没有查询到客户信息
			throw new ClientRegistrationException("客户“" + clientId + "”的信息不存在，无法进行OAuth认证处理。");
		}
		Client client = (Client) map.get("client") ; 				// 获取客户信息，将其进行填充
		BaseClientDetails clientDetails = new BaseClientDetails() ;
		clientDetails.setClientId(clientId);
		clientDetails.setClientSecret(client.getClientsecret()); 	// 需要后续验证
		clientDetails.setAuthorizedGrantTypes(Arrays.asList(client.getAuthorizedgranttypes()));
		clientDetails.setScope(Arrays.asList(client.getScope()));
		clientDetails.setAutoApproveScopes(clientDetails.getScope());
		// 接收所有的授权信息
		Set<String> auth = (Set<String>) map.get("allAuthorities") ; // 获得所有的授权信息
		List<GrantedAuthority> allGrantedAuthority = new ArrayList<GrantedAuthority>() ;
		Iterator<String> iter = auth.iterator() ;
		while(iter.hasNext()) {
			allGrantedAuthority.add(new SimpleGrantedAuthority(iter.next())) ;
		}
		clientDetails.setAuthorities(allGrantedAuthority); 
		return clientDetails; 
	}
}

