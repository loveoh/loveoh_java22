<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
	
	<%
		String name = (String)request.getAttribute("name");
		List<String> addressList = (List<String>)request.getAttribute("addressList");
	%>
	
	<h3><%= name %>,登录成功</h3>
	
	<%
		for(String address :addressList){
	%>	
		
		<li><%= address %></li>
		
		<% }%>

</body>
</html>