package com.lxj.employee.dao.impl;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lxj.employee.dao.EmployeeDao;
import com.lxj.employee.domain.Employee;

//员工管理Dao层的实现类
public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
	/*
	 * 在Dao中根据用户名和密码查询用户的方法
	*/
	public Employee findByUsernameAndPassword(Employee employee) {
		// TODO Auto-generated method stub
		String hql = "from Employee where username = ? and password = ?";
		@SuppressWarnings("unchecked")
		List<Employee> list = 
				(List<Employee>) this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());
		if(list.size() > 0) {
			return list.get(0);
		}
		return null;
	}
	//查询员工总数
	@SuppressWarnings("unchecked")
	public int findCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}
	//分页查询员工
	@SuppressWarnings("unchecked")
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
	/*
	 *dao层中的保存员工的方法 
	 */
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
	}
	//通过id查询员工
	public Employee findById(Integer eid) {
		return this.getHibernateTemplate().get(Employee.class, eid);
	}
	//dao层的修改员工执行方法
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(employee);
	}
	//dao层的删除员工执行方法
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(employee);
	}
}
