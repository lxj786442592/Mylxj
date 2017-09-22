package com.lxj.employee.action;

import com.lxj.employee.domain.Department;
import com.lxj.employee.domain.PageBean;
import com.lxj.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//部门管理Action类
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Department department = new Department();
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	
	//第几页
	private Integer currPage = 1;
	
	public Integer getCurrPage() {
		return currPage;
	}
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	//注入部门管理的Service
	private DepartmentService departmentService;
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	//提供一个查询的方法
	public String findAll() {
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	//跳转到添加部门页面的方法
	public String saveUI() {
		return "saveUI";
	}
	//添加部门的执行方法
	public String save() {
		departmentService.save(department);
		return "saveSuccess";
	}
	//编辑部门的执行方法
	public String edit() {
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	//修改部门执行的方法
	public String update() {
		departmentService.update(department);
		return "updateSuccess";
	}
	//删除部门的方法
	public String delete() {
		departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
	
}
