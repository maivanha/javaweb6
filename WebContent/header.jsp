<%@page import="java.util.Locale"%>
<%@page import="ulti.PropertiesReader"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ct" uri="/WEB-INF/tld1.tld"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/styleDangKy.css">
<link rel="stylesheet" type="text/css"
	href="./data/css/style-DangNhap.css">
<link rel="stylesheet" type="text/css"
	href="./data/css/style-Header.css">
<link rel="stylesheet" type="text/css" href="./data/css/style-index.css">
<link rel="stylesheet" type="text/css"
	href="./data/css/style-Footer.css">
<link rel="stylesheet" href="js/bootstrap.min.css">
<link rel="stylesheet" href="./js/all.css">

<meta name="viewport" content="width = device-width, initial-scale = 1">

<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/index.js"></script>
<script src="./js/all.js"></script>
<script src="./js/header.js"></script>

<style type="text/css">
body {
	margin: 0 auto;
}

svg {
	font-size: 20px !important;
}
</style>

</head>
<body>

	<ct:resourceBundle>index.home</ct:resourceBundle>
	<a href="./ChangeLanguage?lang=vi">Tiếng Việt</a>
	<a href="./ChangeLanguage?lang=en">Tiếng Anh</a>
	<%
		PropertiesReader pr = new PropertiesReader();
		pr.setlocale(new Locale("vi", "VN"));
	%>
	<div class="container">
		<div id="header">
			<nav class="navbar navbar-inverse">

				<div class="container-fluid">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span> 
							<span class="icon-bar"></span>
						</button>
						<div class="logo">
							<img src="./data/img/logo.png">
						</div>
					</div>

					<div class="collapse navbar-collapse" id="myNavbar">
						<ul  style="font-size: 20px">
							<li><a href="index.jsp" title="Trang chủ"><i class="fas fa-home"></i>&nbsp<ct:resourceBundle>index.home</ct:resourceBundle></a></li>
							<li><a href="./ListNew.jsp" title="Tin Tức"><i class="fas fa-newspaper"></i>&nbsp<ct:resourceBundle>index.news</ct:resourceBundle>


							<%
								if (session.getAttribute("username") == null) {
							%>
							<li><a data-toggle="modal" data-target="#checkOrderForm" title="Tra đơn hàng"><i
									class="fas fa-user-edit"></i>&nbspTRA ĐƠN HÀNG</a></li>
							<li><a data-toggle="modal" data-target="#registerModal" title="Đăng ký"><i
									class="fas fa-user-edit"></i>&nbsp<ct:resourceBundle>index.register</ct:resourceBundle></a></li>

							<li><a data-toggle="modal" data-target="#loginModal"
								id="login" title="Đăng nhập"><i class="fas fa-sign-in-alt"></i>&nbsp<ct:resourceBundle>index.login</ct:resourceBundle></a></li>

							<%
								} else {
							%>
							<li><a title="Giỏ hàng" style="cursor: point" onclick = "showpopup('p1','GetListCartAction')"><i
									class="fas fa-shopping-cart"></i>&nbsp GIỎ HÀNG </a></li>
							<li><a href="./admin.jsp"><i class="fas fa-user-circle"></i>&nbsp<%=session.getAttribute("username").toString().toUpperCase()%></a></li>
							<li><a href="./LogoutAction" title="Đăng xuất"><i
									class="fas fa-sign-out-alt"></i>&nbsp ĐĂNG XUẤT </a></li>
							<%
								}
							%>
						</ul>
						<form name="formSearch">
							<div class="search-item" style="position: relative;">
								<input type="text" name="search" id="search" placeholder="Tìm kiếm.." onkeyup="Search()" />
								<div id="searchh" style="diplay: none;"></div>
							</div>

					</form>
					</div>
				</div>

			</nav>
		</div>
	</div>


	<!-- Đăng nhập -->
	<div class="modal fade" id="loginModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal body -->
				<div class="modal-body">
					<div class="login-box">
						<h1>ĐĂNG NHẬP</h1>
						<form action="./LoginAction" method="post">

							<p>Tài khoản</p>
							<input type="text" name="username" placeholder="Nhập tài khoản">
							<p>Mật khẩu</p>
							<input type="password" name="password"
								placeholder="Nhập mật khẩu"> <input type="submit"
								name="submit" value="Đăng nhập"> <a href="#">Quên
								mật khẩu</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Đăng ký -->
	<div class="modal fade" id="registerModal">
		<div class="modal-dialog">
			<div class="modal-content" style="width: 500px">

				<!-- Modal body -->
				<div class="modal-body">
					<div id="register">
						<div class="mLeft">
							<h1>Đăng ký</h1>
							<form action="./AccountRegisterAction" method="post" id="formregis">
								<table width="400px" cellspacing="5" align="center"	background="rgba(0, 0, 0, 0.5)";>
									<tr>
										<td>Tên đăng nhập</td>
										<td><input type="text" name="username" size="30" required class="inputText"></td>
									</tr>
									<tr>
										<td>Mật khẩu</td>
										<td><input type="password" name="userpass" width="100px" size="30" required /></td>
									</tr>

									<tr>
										<td>Email</td>
										<td><input type="text" name="email" size="30" required></td>
									</tr>
									<tr>
										<td>Họ tên</td>
										<td><input type="text" name="fullname" size="30" required></td>
									</tr>
									<tr>
										<td>Địa chỉ</td>
										<td><input type="text" name="address" size="30" required></td>
									</tr>
									<tr>
										<td>Điện thoại</td>
										<td><input type="text" name="phone" size="30"
											maxlength="12" required></td>
									</tr>
									<tr>
										<td colspan="2" align="center"><input
											class="btn btn-warning" type="reset" name="reset"
											value="Reset"> &nbsp &nbsp &nbsp <input
											class="btn btn-info" type="submit" name="ok" value="Đồng Ý"></td>
									</tr>
								</table>
							</form>

						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
	

  <!-- Tra đơn hàng -->
  <div class="modal fade" id="checkOrderForm">
    <div class="modal-dialog modal-lg">
      <div class="modal-content" style="width: 100%; min-height: 200px !improtant;">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <form name="formcheckOrder">
          	<input type="text" id="emailCheckOrder" name="email" placeholder="Nhập email">
          	<button type="button" onclick="LoadFormOrder()">Tra đơn hàng</button>
          </form>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
        <ul class="nav nav-tabs" >
   			<li class="active"><a data-toggle="tab" href="#home">Đang giao hàng</a></li>
    		<li><a data-toggle="tab" href="#menu1" >Đã Mua</a></li>
 		</ul>
			<div class="tab-content">
				<div id="home" class="tab-pane fade in active">
					<div id="checkOrder"></div>
				</div>
				<div id="menu1" class="tab-pane fade">
					<div id="checkOrder"></div>
				</div>
						
			</div>
		</div>
					<!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        </div>
        
      </div>
    </div>
  </div>

	<div class="popup" id="p1">
	
		<div class="boxpopup">
			<div id="cart"></div>
		</div>
	</div>


	<script>

		var span1 = document.getElementById("bp1");

		span1.onclick = function() {
			document.getElementById("p1").style.display = "none";
		}
		
		
		window.onclick = function(event) {
			var x = document.getElementById("p1");
		    if (event.target == x) {
		    	x.style.display = "none";
		    }
		}
		
		window.onclick = function(event) {
			var search = document.getElementById("searchh");
		    if (event.target != search) {
		    	search.style.display = "none";
		    } else {
		    	search.style.display = "block";
		    }
		}

	</script>
</body>
</html>