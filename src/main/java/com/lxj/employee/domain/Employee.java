package com.lxj.employee.domain;

import java.util.Date;

//员工实体
public class Employee {
	private Integer eid;			//员工id
	private String eno;				//员工编号
	private String ename;			//员工名字
	private String sex;				//员工性别
	private Date birthday;			//员工生日
	private Date joinDate;			//员工入职日期
	private String username;		//员工账户名
	private String password;		//员工密码
	private Department department;	//员工所属部门
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", eno=" + eno + ", ename=" + ename + ", sex=" + sex + ", birthday=" + birthday
				+ ", joinDate=" + joinDate + ", username=" + username + ", password=" + password + ", department="
				+ department + "]";
	}
	
	
	
}
