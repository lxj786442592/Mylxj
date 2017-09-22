package com.lxj.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lxj.employee.dao.DepartmentDao;
import com.lxj.employee.domain.Department;
import com.lxj.employee.domain.PageBean;
import com.lxj.employee.service.DepartmentService;

//部门管理业务层的实现类
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao departmentDao;

	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	//分页查询的方法
	public PageBean<Department> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总页记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		int totalPage = (int) Math.ceil(tc / pageSize);
		pageBean.setTotalPage(totalPage);
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);	
		return pageBean;
	}
	//业务层保存部门的方法
	public void save(Department department) {
		departmentDao.save(department);
	}
	//业务层编辑部门的方法
	public Department findById(Integer did) {		
		return departmentDao.findById(did);
	}
	//业务层修改部门的执行方法
	public void update(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
	}
	//业务层删除部门的方法
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
	}
	//查询所有部门的方法
	public List<Department> findAll() {
		return departmentDao.findAll();
	}
}
