<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Trang Quản trị viên</title>
<link rel="icon" href="data/img/logo-9.png">
<link rel="stylesheet" type="text/css" href="./data/css/style-admin.css">

<script src="js/admin.js"></script>

<link rel="stylesheet" href="js/bootstrap.min.css">

<script src="js/jquery-3.3.1.min.js"></script>

<script src="js/bootstrap.min.js"></script>

<script src="js/index.js"></script>

<script src="js/all.js"></script>
<link rel="stylesheet" href="js/add.css">

<style type="text/css">
body {
	margin: 0 auto;
}

</style>
</head>
<body>
	<div id="content">
		<div class="left">
			<h3>Menu</h3>
			<ul>
				<a href="./index.jsp"><li><i class="fas fa-home"></i>&nbsp Trang chủ</li></a>
				<a href="./admin.jsp?f=account"><li><i class="far fa-address-card"></i>&nbsp Quản lý tài khoản</li></a>
				<a href="./admin.jsp?f=order"><li><i class="fas fa-shopping-cart"></i>&nbsp Đơn Hàng</li></a>
				<a href="./admin.jsp?f=product"><li>&nbsp<i class="fas fa-mobile-alt"></i>&nbsp Sản phẩm</li></a>
				<a href="./admin.jsp?f=new"><li><i class="fas fa-newspaper"></i>&nbsp Tin tức</li></a>
				<a href="./admin.jsp?f=company"><li><i class="fas fa-archive"></i>&nbsp Hãng sản xuất</li></a>
				<a href="./admin.jsp?f=ProductType"><li><i class="fas fa-boxes"></i>&nbsp Loại sản phẩm</li></a>
			</ul>
		</div>
		<div class="right">
			<%
				String f = request.getParameter("f");
				//out.print("f: " + f);
				if (f == null) {
					f = "account";
				}
				switch (f) {
				case "account":
			%>
			<jsp:include page="./data/account.jsp"></jsp:include>
			<%
				break;
				case "new":
			%>
			<jsp:include page="./data/new.jsp"></jsp:include>
			<%
				break;
				case "product":
			%>
			<jsp:include page="./data/product.jsp"></jsp:include>
			<%
				break;
				case "order":
			%>
			<jsp:include page="./data/order.jsp"></jsp:include>
			<%
				break;
				case "orderDetail":
			%>
			<jsp:include page="./data/orderDetail.jsp"></jsp:include>
			<%
				break;
				case "EditOrder":
			%>
			<jsp:include page="./data/EditOrder.jsp"></jsp:include>
			<%
				break;
				case "company":
			%>
			<jsp:include page="./data/company.jsp"></jsp:include>
			<%
				break;
				case "EditCompany":
			%>
			<jsp:include page="./data/EditCompany.jsp"></jsp:include>
			<%
				break;
				case "InsertCompany":
			%>
			<jsp:include page="./data/InsertCompany.jsp"></jsp:include>
			<%
				break;
				case "ProductType":
			%>
			<jsp:include page="./data/ProductType.jsp"></jsp:include>
			<%
				break;
				case "InsertProductType":
			%>
			<jsp:include page="./data/InsertProductType.jsp"></jsp:include>
			<%
				break;
				case "EditProductType":
			%>
			<jsp:include page="./data/EditProductType.jsp"></jsp:include>
			<%
				break;
				case "EditAccount":
			%>
			<jsp:include page="./data/EditAccount.jsp"></jsp:include>
			<%
				break;
				case "InsertProduct":
			%>
			<jsp:include page="./data/InsertProduct.jsp"></jsp:include>
			<%
				break;
				case "EditProduct":
			%>
			<jsp:include page="./data/EditProduct.jsp"></jsp:include>
			<%
				break;
				case "InsertNews":
			%>
			<jsp:include page="./data/InsertNews.jsp"></jsp:include>
			<%
				break;
				case "EditNew":
			%>
			<jsp:include page="./data/EditNew.jsp"></jsp:include>
			<%
				break;
				case "EditPassword":
			%>
			<jsp:include page="./data/EditPassword.jsp"></jsp:include>
			<%
				break;
				default:
			%>
			<jsp:include page="./data/account.jsp"></jsp:include>
			
			<%
				}
			%>
		</div>
	</div>

</body>
</html>