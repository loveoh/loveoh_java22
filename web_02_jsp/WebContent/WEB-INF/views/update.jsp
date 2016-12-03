<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kaishengit.entity.Book" %>
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
				<form action="/update" method="post">
					<legend>修改书籍</legend>
					<div class="form-group">
						<label>书籍名称</label>
						<input type="hidden" name="id" value="${book.id }" calss="form-control"/>
						<input type="text" name="name" value="${book.name }" class="form-control" />
					</div>
					<div class="form-group">
						<label>作者名称</label>
						<input type="text" name="author" value="${book.author }" class="form-control" />
					</div>
					<div class="form-group">
						<label>书籍数量</label>
						<input type="text" name="total" value="${book.total }" class="form-control" />
					</div>
					<div class="form-group">
						<label>isbn</label>
						<input type="text" name="isbn" value="${book.isbn }" class="form-control" />
					</div>
					<button class="btn btn-primary">修改</button>
					
				</form>
			</div>
		</div>
	</div>

</body>
</html>