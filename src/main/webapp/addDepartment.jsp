<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加部门页面</title>
</head>
<body>
<h1><%=request.getContextPath() %></h1>
<s:form action="department_save" method="post" >
	<table>
		<tr>
			<td>部门名称 ：</td>
			<td><s:textfield name="dname" theme="simple"/></td>
		</tr>
		<tr>
			<td>部门介绍 ：</td>
			<td><s:textarea rows="7" cols="70" name="ddesc" /></td>
		</tr>
	</table>
	<input type="submit" value="保存">
</s:form>
</body>
</html>