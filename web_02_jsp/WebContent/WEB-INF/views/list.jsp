<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.kaishengit.entity.Book"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div class="col-md-10">
				<a href="/add" class="btn btn-success">添加书籍</a> <a href="/logout"
					class="btn btn-primary">安全退出</a>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>书籍名称</th>
							<th>书籍作者</th>
							<th>书籍数量</th>
							<th>isbn编码</th>
							<th>#</th>
						</tr>
					</thead>
					<tbody>

						<c:if test="${empty page }">

							<div>
								<td colspan="6">暂无数据</td>
							</div>
						</c:if>
						<c:forEach var="items" items="${page.items }">

							<tr>
								<td>${items.name }</td>
								<td>${items.author }</td>
								<td>${items.total }</td>
								<td>${items.isbn }</td>
								<td>
									<a href="/update?id=${items.id }">修改</a> 
									<a href="javascript:;" rel="${items.id }" class="del">删除</a>
								</td>

							</tr>
						</c:forEach>


					</tbody>
				</table>
				<nav>
				  <!--  <ul id="pagination" class="pagination-sm"></ul> -->
				   <ul id="pagination" class="pagination pull-right"></ul>
				   </nav>
				
				<%--    
				<nav>
					<ul class="pagination pull-right">
					<c:choose>
						<c:when test="${page.pagNo == 1 }">
							<li><a class="disabled" href="javascript:;">首页</a></li>
							<li><a class="disabled" href="javascript:;">上一页</a></li>
						</c:when>
					
					<c:otherwise>
						<li><a href="/list">首页</a></li>
						<li><a href="/list?p=${page.pagNo-1 }">上一页</a></li>
					</c:otherwise>
					
					
					
					</c:choose>
					<c:choose>
						<c:when test="${page.pagNo == page.totalPage }">
							<li><a class="disabled" href="javascript:;">下一页</a></li>
							<li><a class="disabled" href="javascript:;">末页</a></li>
						
						</c:when>
						<c:otherwise>
							<li><a  href="/list?p=${page.pagNo + 1 }">下一页</a></li>
							<li><a  href="list?p=${page.totalPage }">末页</a></li>
						</c:otherwise>
					
					</c:choose>	
						
						
					</ul>
				</nav> --%>
			</div>
		</div>
	</div>
	<script src="/static/js/jquery-1.12.4.min.js"></script>
	<script src="/static/js/jquery.twbsPagination.min.js"></script>
	<script>
		$(function() {
			//分页插件的使用
			$("#pagination").twbsPagination({
				totalPages:${page.totalPage},
				visiblePages: 5,
				herf:"/list?p={{number}}",
				first:"首页",
                prev:"上一页",
                next:"下一页",
                last:"末页"
			});
			
			
			
			
			
			
			$(".del").click(function() {
				if (confirm("你确定要删除吗?")) {
					var id = $(this).attr("rel");

					location.href = "/del?id=" + id;
				}
			})

		})();
	</script>


</body>
</html>