<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>

<title>Đăng ký</title>
<link rel="icon" href="img/logo-9.png">
<link rel="stylesheet" type="text/css" href="css/styleDangKy.css">
<link rel="stylesheet" type="text/css" href="css/style-Header.css">
<link rel="stylesheet" type="text/css" href="css/style-Footer.css">

<script src="../js/dangky.js"></script>
<link rel="stylesheet" href="../js/bootstrap.min.css">
<script src="../js/jquery-3.3.1.min.js"></script>

<script src="../js/bootstrap.min.js"></script>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.min.js"></script>

<style type="text/css" media="screen">
#main {
	background-image: url(img/image.jpg);
	background-size: cover;
	background-position: center;
	width: 100%;
	height: 80%;
}
</style>

</head>
<body>
	<div id="header">
		<div class="logo">
			<img src="img/logo.png">
		</div>
		<ul>
			<li><a href="../index.jsp" title="Trang chủ"> TRANG CHỦ </a></li>
			<li><a href="../ListNew.jsp?page=1" title="Tin Tức"> TIN TỨC </a></li>
			<li><a href="dangnhap.html" title="Đăng nhập"> ĐĂNG NHẬP </a></li>
			<li><a href="dangky.html" title="Đăng ký"> ĐĂNG KÝ </a></li>
		</ul>
		<div class="boxsearch">
			<div class="search-item">

				<input type="search" id="search" placeholder="Tìm kiếm.." />
			</div>
		</div>
	</div>
	
	
	<div class="container">
  <h2>Fading Modal</h2>
  <p>Add the "fade" class to the modal container if you want the modal to fade in on open and fade out on close.</p>

  <!-- Button to Open the Modal -->
  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
    Open modal
  </button>

		<!-- The Modal -->
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal body -->
					<div class="modal-body">
						<div id="main">
							<div class="mLeft">
								<h1>Đăng ký</h1>
								<form action="../AccountRegisterAction" method="post" id="formregis">
									<table width="400px" cellspacing="5" align="center"	background="rgba(0, 0, 0, 0.5)";>
										<tr>
											<td>Tên đăng nhập</td>
											<td><input type="text" name="username" size="30"
												required></td>
										</tr>
										<tr>
											<td>Mật khẩu</td>
											<td><input type="password" name="userpass" width="100px"
												size="30" required /></td>
										</tr>

										<tr>
											<td>Email</td>
											<td><input type="text" name="email" size="30" required></td>
										</tr>
										<tr>
											<td>Họ tên</td>
											<td><input type="text" name="fullname" size="30"
												required></td>
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

	</div>
	
<script type="text/javascript">
$(document).ready(function() {
	$("#formregis").validate({
		rules:{
			username: "required",
			userpass: "required",
			email: "required",
			fullname: "required",
			address: "required",
			phone: {
				required: true,
				minlength: 11
			}
		},
		messages: {
			username: "Vui lòng nhập tài khoản",
			userpass: "Vui lòng nhập mật khẩu",
			email: "Vui lòng nhập email",
			fullname: "Vui lòng nhập họ tên",
			address: "Vui lòng nhập địa chỉ",
			phone: {
				required: "Vui lòng nhập số điện thoại",
				minlength: "Ngắn thế chém gió à ?? Độ dài 11 số !"
			}
		}
	});
});
</script>
</body>
</html>