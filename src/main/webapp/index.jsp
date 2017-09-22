<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>账户登陆界面</title>
</head>
<body>
<s:form action="employee_login" method="post">
	<p>账号 : <input type="text" name="username"></p>
	<p>密码 : <input type="password" name="password"></p>
	<input type="submit" value="登陆">
	<p><s:actionerror/></p>
</s:form>
</body>
</html>