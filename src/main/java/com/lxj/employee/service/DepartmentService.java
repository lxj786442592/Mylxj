package com.lxj.employee.service;

import java.util.List;

import com.lxj.employee.domain.Department;
import com.lxj.employee.domain.PageBean;

//部门管理的业务层接口
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();

}
