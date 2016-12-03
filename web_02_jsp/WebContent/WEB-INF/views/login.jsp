<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style>
    	#img {
    		
    		width : 160px;
    		height : 70px;	
    	}
    	 sapn {
    		float : left;
    		display : block;
    	
    	}
    </style>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
			
			<c:if test="${not empty message }">
			<div class="alert alert-danger">账号或密码错误</div>
			</c:if>
			
				<form action="/login" method="post" id="loginForm">
					<legend>登录注册</legend>
					<div class="form-group">
						<label>账号</label>
						<input type="text" name="username" id="username"  value="${username }" class="form-control" />
					</div>
					<div class="form-group">
						<label>密码</label>
						<input type="password" id="psw" name="password" class="form-control" />
					<div class="form-group">
						<label>验证码</label>
						<input type="text" name="code" class="form-control" />
						<a href="javascript:;" id="change"><img id="img" src="/patchca.png" alt="" /><span>看不清,换一张</span></a>
				
					<br />
					<div class="checkbox">
						<label>
							<input type="checkbox" name="remeber" value="remeber" id="remeber" />记住账号
						</label>
					</div>
					
					</div>
					<button type="button" id="loginBtn"class="btn btn-primary">登录</button>
					<a href="/regist" class="btn btn-default">注册</a>
				</form>
				
			</div>
		</div>
	</div>
	
	<script src="/static/js/jquery-1.12.4.min.js"></script>
	<script src="/static/js/jquery.cookie.js"></script>
	<script src="/static/js/cryptojs/rollups/md5.js"></script>
	<script>
	
	//在客户端实现记住账号功能
		$(function(){
			/* $("#username").val($.cookie("username"));
 */
 			//点击验证码
 			
 		
			$("#change").click(function(){
				
				//$("#img").removeAttr("src");
				 $("#img").removeAttr("src").attr("src","/patchca.png?_="+new Date().getTime());
			});
 				 
			$("#loginBtn").click(function(){
				
			/* 	if($("#remeber")[0].checked){
					$.cookie("username",$("#username").val(),{expires:7, path :'/'});
				} */
				
				//客户端密码加密
				/* var password = $("#psw").val();
				password = CryptoJS.MD5(password);
				$("#psw").val(password);
				 */
				$("#loginForm").submit();
				
				
			});
			
		});
		
	</script>
	
</body>
</html>