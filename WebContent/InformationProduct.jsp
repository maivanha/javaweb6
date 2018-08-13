<%@page import="model.etity.Rating"%>
<%@page import="java.util.List"%>
<%@page import="model.RatingModel"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.etity.Product"%>
<%@page import="model.ProductModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> Samsung Galaxy S9 </title>
<link rel = "icon" href = "./data/img/logo-9.png">
<link rel="stylesheet" type="text/css"
	href="./data/css/style-SanPham.css">

<style type="text/css">
body {
	margin: 0 auto;
	background-color: #f5f5f5 !important;
}

.checked {
    color: orange;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%
		
	
	
		DecimalFormat fomat = new DecimalFormat("###,###,###");
		String id = request.getParameter("codeProduct");
		ProductModel pModel = new ProductModel();
		Product p = pModel.getProductById(Integer.parseInt(id));
		
		RatingModel rModel = new RatingModel();
		Rating r = rModel.getRating(p.getCodeProduct(), (String)session.getAttribute("username"));
		
		double rating = rModel.getRatingValue(p.getCodeProduct());
	%>
	<div class="container" style="background-color: #f5f5f5;">
		<div class="row" style="margin: 0px">
			<div class="col-md-4" style="padding-left: 0px">
				<div id = "content">
					<div class = "picture">
						<img src = "./data/img/smartphone/<%=p.getImage()%>"/>
						<div class="boxitem">
							<div class = "item1">
								<img src = "data/img/icon/icon1.png"/> 
								<h5>Mở hộp, k.mãi</h5>		
							</div>
							<div class = "item2">
								<img src = "data/img/icon/icon2.png"/> 
								<h5>Chụp từ camera</h5>		
							</div>
							<div class = "item3">
								<img src = "data/img/icon/icon3.png"/> 
								<h5>Hình 360 độ</h5>		
							</div>
							<div class = "item4">
								<img src = "data/img/icon/icon4.png"/> 
								<h5>Video</h5>		
							</div>
						</div>				
					</div>
				</div>
			</div>
			<div class="col-md-8" style="height: 440px; background-color: white;">
				<h3><%=p.getNameProduct() %></h3>
				<h4 style="color: red"><%=fomat.format(p.getPrice()) %><sup>đ</sup></h4>
				<hr color = "#dfdfdf"/>
				<div>
					<h4>Đánh giá:<%=rating%></h4>
					<div>
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star checked"></span> 
					<span class="fa fa-star"></span> 
					<span class="fa fa-star"></span>
					</div>
				</div>

				<form action="./RatingAction?codeProduct=<%=p.getCodeProduct() %>" method="post">
					<input type="number" min="0" max="5" name="rating" value="<%=r.getValueRating()%>">
					<button type="submit">Đánh giá</button>
				</form>
				<hr color = "#dfdfdf"/>
					<h4>Hàng sẵn có: <%=p.getNumberOfpro() %></h4>
				<hr color = "#dfdfdf"/>
				<input type="button" value="Mua Ngay" class="btn btn-success" onclick="LoadFormCart(<%=p.getCodeProduct()%>)">
			</div>

		</div>
		<div class="description">
			<p> Siêu phẩm Samsung Galaxy S9 chính thức ra mắt mang theo hàng loạt cải tiến, tính năng cao cấp như camera thay đổi khẩu độ, quay phim siêu chậm 960 fps, AR Emoji... nhanh chóng gây sốt làng công nghệ.
			Galaxy S9 vẫn đi theo triết lí thiết kế tương tự như Galaxy S8 với khung viền kim loại cứng cáp cùng mặt lưng kính bóng bẩy bo cong mềm mại. Đặc biệt, phần khung viền của Galaxy S9 được hoàn thiện bằng kim loại nhám giúp bám tay tốt hơn hẳn, chứ không bóng loáng như thời S8.</p>
		</div>
		

	</div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>