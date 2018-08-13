<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.etity.Product"%>
<%@page import="java.util.List"%>
<%@page import="model.ProductModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	DecimalFormat fomat = new DecimalFormat("###,###,###");

	ProductModel pModel = new ProductModel();
	List<Product> dsSanPham = new ArrayList<>();
	dsSanPham = (List<Product>)request.getAttribute("dsSanPham");
	for (int i = 0; i < dsSanPham.size(); i++) {
%>
<div class="boxSanPham">
	<a
		href="./InformationProduct.jsp?codeProduct=<%=dsSanPham.get(i).getCodeProduct()%>"
		title="<%=dsSanPham.get(i).getNameProduct()%>">
		<div class="boxImageSP">
			<img src="./data/img/smartphone/<%=dsSanPham.get(i).getImage()%>">
		</div>
		<h3><%=dsSanPham.get(i).getNameProduct()%></h3>
		<h5><%=fomat.format(dsSanPham.get(i).getPrice())%><sup>đ</sup></h5> <%
 	// Sửng dụng hàm format của đối tượng fomat để hiện thị mệnh giá
 %>
	</a>
	<div class="butMuaNgay">
		<input type="button" class="btn btn-success butMuaNgay" value="Mua ngay" onclick="LoadFormCart(<%=dsSanPham.get(i).getCodeProduct()%>)" />
	</div>
</div>
<%
	}
%>

