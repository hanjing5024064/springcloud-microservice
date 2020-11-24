package cn.mldn.mldncloud.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.mldn.mldncloud.po.Member;

public interface IMemberDAO extends JpaRepository<Member, String> {
	@Query(nativeQuery=true,value="SELECT rid FROM member_role WHERE mid=:mid")
	public Set<String> findAllByMember(@Param("mid") String mid) ;
}
