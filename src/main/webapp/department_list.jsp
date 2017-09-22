<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<s:iterator value="list" var="d">
<form action="department_findAll" method="post">
<table border="1px" cellpadding="5px">
	<tr>
		<td><s:property value="#d.did"></s:property></td>
		<td><s:property value="#d.dname"></s:property></td>	
		<td><s:property value="#d.ddesc"/></td>
		<td><a href="${pageContext.request.contextPath}/department_edit.action?did=<s:property value="#d.did"/>">编辑</a></td>
		<td><a href="${pageContext.request.contextPath}/department_delete.action?did=<s:property value="#d.did"/>">删除</a></td>
	</tr>
</table>
</form>
</s:iterator> 

<s:if test="currPage != NULL">
	<div>第<s:property value="currPage"/>页/共<s:property value="totalPage"/>页</div>
	<s:if test="currPage != 1">
		<a href="${pageContext.request.contextPath}/department_findAll.action?currPage=1">[首页]</a>
		<a href="${pageContext.request.contextPath}/department_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>
	</s:if>
	<s:if test="currPage != totalPage">
		<a href="${pageContext.request.contextPath}/department_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>
		<a href="${pageContext.request.contextPath}/department_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>
	</s:if>
</s:if>
<s:if test="currPage = NULL">
	<div>第N页/共N页</div>
</s:if>
</body>
</html>