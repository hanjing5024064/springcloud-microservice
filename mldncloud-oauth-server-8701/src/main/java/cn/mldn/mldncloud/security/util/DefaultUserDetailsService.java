package cn.mldn.mldncloud.security.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import cn.mldn.mldncloud.po.Member;
import cn.mldn.mldncloud.service.IMemberService;

public class DefaultUserDetailsService implements UserDetailsService {
	@Autowired
	private IMemberService memberService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Map<String, Object> map = this.memberService.get(username);
		Member member = (Member) map.get("member");
		if (member == null) { 									// 用户信息不存在
			throw new UsernameNotFoundException("用户“" + username + "”信息不存在！"); 
		}	// 要获取该用户的全部角色信息（授权信息）
		Set<String> allRoles = (Set<String>) map.get("allRoles");
		Iterator<String> iter = allRoles.iterator();
		List<GrantedAuthority> allGrantedAuthority = new ArrayList<GrantedAuthority>();
		while (iter.hasNext()) {
			allGrantedAuthority.add(new SimpleGrantedAuthority(iter.next()));
		}
		User user = new User(username, member.getPassword(), allGrantedAuthority);
		return user;
	}


}
