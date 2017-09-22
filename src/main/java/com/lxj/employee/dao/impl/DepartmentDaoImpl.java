package com.lxj.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.lxj.employee.dao.DepartmentDao;
import com.lxj.employee.domain.Department;

//部门管理的Dao层实现类
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {
	//查询部门总数
	@SuppressWarnings("unchecked")
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Department";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if(list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}
	
	//分页查询部门
	@SuppressWarnings("unchecked")
	public List<Department> findByPage(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = (List<Department>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}
	//dao层保存部门的方法
	public void save(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(department);
	}
	//dao层根据部门的id号查询部门的方法
	public Department findById(Integer did) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Department.class, did);
	}
	//dao层修改部门的执行方法
	public void update(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(department);
	}
	//dao层删除部门的方法
	public void delete(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(department);
	}
	//查询所有部门的方法
	@SuppressWarnings("unchecked")
	public List<Department> findAll() {
		return (List<Department>) this.getHibernateTemplate().find("from Department");
	}
}
