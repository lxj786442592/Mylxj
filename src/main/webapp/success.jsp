<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工管理系统</title>
</head>
<body>
<h1>this is success.jsp</h1>
<p>登陆成功，欢迎您 ： <s:property value="#session.existEmployee.getEname()"></s:property></p>

<!-- 部门管理 -->
<a href="${pageContext.request.contextPath}/department_findAll.action">部门管理</a>
<a href="${pageContext.request.contextPath}/department_saveUI.action">部门添加</a>

<!-- 部门查询迭代 -->
<jsp:include page="department_list.jsp"></jsp:include>

<br>

<!-- 员工管理 -->
<a href="${pageContext.request.contextPath}/employee_findAll.action">员工管理</a>
<a href="${pageContext.request.contextPath}/employee_saveUI.action">员工添加</a>

<!-- 员工查询迭代 -->
<jsp:include page="employee_list.jsp"></jsp:include>
</body>
</html>