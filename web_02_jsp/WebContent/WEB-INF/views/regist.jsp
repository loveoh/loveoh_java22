<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
       <link rel="stylesheet" href="/static/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
			
			<c:if test="${not empty message }">
				<div class="alert alert-danger">${message }</div>
			</c:if>
			
				<form action="/regist" method="post">
					<legend>注册页面</legend>
					<div class="form-group">
						<label>账号</label>
						<input type="text" name="username" value="${username }"class="form-control" />
					</div>
					<div class="form-group">
						<label>密码</label>
						<input type="password" name="password" class="form-control" />
					
					<button class="btn btn-primary">确定</button>
					<a href="login" class="btn btn-default">取消</a>
				</form>
				
			</div>
		</div>
	</div>

</body>
</html>