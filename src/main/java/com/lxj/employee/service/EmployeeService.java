package com.lxj.employee.service;

import com.lxj.employee.domain.Employee;
import com.lxj.employee.domain.PageBean;

//员工管理的业务接口
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(int currPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);
	
}
