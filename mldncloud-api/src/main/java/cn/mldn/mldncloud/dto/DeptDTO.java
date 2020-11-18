package cn.mldn.mldncloud.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DeptDTO implements Serializable {
	private Long deptno ;
	private String dname ;
	private String loc ;
	// setter、getter略
	public Long getDeptno() {
		return deptno;
	}
	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
