package com.lxj.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lxj.employee.dao.EmployeeDao;
import com.lxj.employee.domain.Employee;
import com.lxj.employee.domain.PageBean;
import com.lxj.employee.service.EmployeeService;

//员工管理的业务层实现类
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	

	private EmployeeDao employeeDao;
	
	//业务层的登陆方法
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee existEmployee = employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	/*
	 * 业务层的分页查询员工方法
	 */
	public PageBean<Employee> findByPage(int currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总的记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		int totalPage = (int) Math.ceil(tc / pageSize);
		pageBean.setTotalPage(totalPage);
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
	/*
	 * 业务层的新增员工的保存方法
	 */
	public void save(Employee employee) {
		employeeDao.save(employee);
	}
	//业务层通过eid查询员工的方法的方法
	public Employee findById(Integer eid) {
		return employeeDao.findById(eid);
	}
	//业务层修改员工的执行方法
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);
	}
	//业务层删除员工的方法
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}
}
