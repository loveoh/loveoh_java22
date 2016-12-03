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
			<div class="col-md-6">
			
				<c:if test="${not empty message }">
				<div class="alert alert-danger">
					${message }
				</div>
				</c:if>
			
				<form action="/add" method="post" id="addForm">
					<legend>添加书籍</legend>
					<div class="form-group">
						<label>书籍名称</label> <input type="text" value="${name }"  name="name"
							class="form-control" />
					</div>
					<div class="form-group">
						<label>作者名称</label> <input type="text" value="${author }"  name="author"
							class="form-control" />
					</div>
					<div class="form-group">
						<label>书籍数量</label> <input type="text" value="${total }"  name="total"
							class="form-control" />
					</div>
					<div class="form-group">
						<label>isbn</label> <input type="text" value="${isbn }" name="isbn"
							class="form-control" />
					</div>
					<button class="btn btn-primary">保存</button>
				</form>
			</div>
		</div>
	</div>

</body>
</html>