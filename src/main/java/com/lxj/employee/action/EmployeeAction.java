package com.lxj.employee.action;

import java.util.List;

import com.lxj.employee.domain.Department;
import com.lxj.employee.domain.Employee;
import com.lxj.employee.domain.PageBean;
import com.lxj.employee.service.DepartmentService;
import com.lxj.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//员工的管理Action
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//模型驱动使用的对象
	private Employee employee = new Employee();
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	//注入业务层的类：
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	public DepartmentService getDepartmentService() {
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	//接受当前页数
	private int currPage = 1;
	
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	/**
	 * 登陆执行的方法：
	 * @return
	 */
	public String login() {
		System.out.println("action中的login方法执行了");
		//调用业务层的类
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null) {
			this.addActionError("用户名或密码错误");
			return INPUT;
		}else {
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
		/*
		 * 分页查询员工
		 */
		public String findAll() {
			PageBean<Employee> pageBean = employeeService.findByPage(currPage);
			ActionContext.getContext().getValueStack().push(pageBean);
			return "findAll";		
		}
		
		//跳转到添加员工页面
		public String saveUI() {
			//查询所有部门
			List<Department> list = departmentService.findAll();
			ActionContext.getContext().getValueStack().set("list", list);
			return "saveUI";
		}
		//新增员工的执行方法
		public String save() throws Exception {
			employeeService.save(employee);
			try {
				return "saveSuccess";
			}catch (Exception e) {
				this.addActionError("保存失败");
				return "saveUI";
			}
		}
		//编辑员工的方法
		public String edit() {
			List<Department> list = departmentService.findAll();
			ActionContext.getContext().getValueStack().set("list", list);
			employee = employeeService.findById(employee.getEid());
			return "editSuccess";
		}
		//修改员工的保存方法
		public String update() {			
			employeeService.update(employee);
			return "updateSuccess";
		}
		//删除员工的执行方法
		public String delete() {
			employeeService.findById(employee.getEid());
			employeeService.delete(employee);
			return "deleteSuccess";
		}
		
		
}
