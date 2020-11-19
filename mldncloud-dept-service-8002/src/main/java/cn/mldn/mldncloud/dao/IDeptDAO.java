package cn.mldn.mldncloud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.mldn.mldncloud.po.Dept;

public interface IDeptDAO extends JpaRepository<Dept,Long> { 	// 包含有全部的基础Crud支持
}
