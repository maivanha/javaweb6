<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
	<link rel = "stylesheet" type = "text/css" href = "./css/style-DangNhap.css">

</head>
<body>

	
		
	<div id = "main">
		<div class="login-box">
			<h1>ĐĂNG NHẬP</h1>
			<form action="../LoginAction" method="post">
				
				<p>Tài khoản</p>
				<input type="text" name="username" placeholder="Nhập tài khoản">
				<p>Mật khẩu</p>
				<input type="password" name="password" placeholder="Nhập mật khẩu">
				<input type="submit" name="submit" value="Đăng nhập">
				<a href="#">Quên mật khẩu</a>    
			</form>
		</div>
	</div>

</body>
</html>