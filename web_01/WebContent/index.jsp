<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>我的</title>
</head>
<body>


	<form action="login" method="post">
		<div>账号</div>
		<input type="text" name="userName"/>
		<div>密码</div>
		<input type="password" name = "passWord"/>
		</br>
		<button>提交</button>	
	</form>
	
	
		<%
		
		String error = request.getParameter("error");
		
		if("1001".equals(error)){
		%>
	
			<div>登录失败</div>
		
		<%}%>
</body>
</html>