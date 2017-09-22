<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工编辑页面</title>

<script language="javascript" type="text/javascript" src="<%=request.getContextPath() %>/My97DatePicker/WdatePicker.js"></script>  

</head>

<body>
<s:form action="employee_update" method="post" theme="simple">
<s:hidden name="eid" value="%{model.eid}"/>
	<table>
		<tr>
			<td>编号 ：</td>
			<td><s:textfield name="eno" value="%{model.eno}"/></td>
		</tr>
		<tr>
			<td>姓名 ：</td>
			<td><s:textfield name="ename" value="%{model.ename}"/></td>
		</tr>
		<tr>
			<td>性别 ：</td>
			<td><s:radio name="sex" list="{'男','女'}" value="%{model.sex}"/></td>
		</tr>	
		<tr>
			<td>生日：</td>
			<td><s:textfield name="birthday" value="%{model.birthday}" onclick="WdatePicker()" class="Wdate"/></td>
		</tr>
		<tr>
			<td>入职日期 ：</td>
			<td><s:textfield name="joinDate" value="%{model.joinDate}" onclick="WdatePicker()" class="Wdate"/></td>
		</tr>
		<tr>
			<td>所属部门 ：</td>
			<td><s:select name="department.did" list="list" listKey="did" listValue="dname" headerKey="" headerValue="--请选择--"></s:select></td>
		</tr>
		<tr>
			<td>设置账号 ：</td>
			<td><s:textfield name="username" value="%{model.username}"/></td>
		</tr>
		<tr>
			<td>设置密码 ：</td>
			<td><s:password name="password" value="%{model.password}"/></td>
		</tr>
	</table>
	<input type="submit" value="保存">
</s:form>
<p><s:actionerror/></p>
</body>
</html>