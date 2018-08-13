<%@page import="model.etity.Product"%>
<%@page import="model.ProductModel"%>
<%@page import="model.etity.Customer"%>
<%@page import="java.util.List"%>
<%@page import="model.AccountModel"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Trang Quản trị viên</title>
<link rel="icon" href="data/img/logo-9.png">
</head>
<body>
	<center>
	<h3>Sản phẩm</h3>
		<a href ="././admin.jsp?f=InsertProduct">Thêm sản phẩm</a>
		<table class="table table-responsive table-hover table-striped table-condensed">
			<tr align="center">
				<th>Mã sản phẩm</th>
				<th>Tên sản phẩm</th>
				<th>Giá tiền</th>
				<th>Số lượng dư</th>
				<th>Hình ảnh</th>
				<th>Mã loại sản phẩm</th>
				<th colspan="3">Mã hãng sản suất</th>
			</tr>
			<%
				ProductModel pModel = new ProductModel();
				List<Product> listpro = pModel.getProduct();
				
				for(int i = 0; i < listpro.size(); i ++) {
			%>
			<tr align="center">
				<td><%out.print(listpro.get(i).getCodeProduct()); %></td>
				<td align="left"><%out.print(listpro.get(i).getNameProduct()); %></td>
				<td><%out.print(listpro.get(i).getPrice()); %></td>
				<td><%out.print(listpro.get(i).getNumberOfpro()); %></td>
				<td><img src ="./data/img/smartphone/<%=listpro.get(i).getImage() %>" width="30" height="30"></td>
				<td><%out.print(listpro.get(i).getCodeSP()); %></td>
				<td><%out.print(listpro.get(i).getCodeCompany()); %></td>
				<td><a href ="./admin.jsp?f=EditProduct&codeProduct=<%=listpro.get(i).getCodeProduct()%>"class="btn btn-success btn-xs"><i class="far fa-edit"></i>&nbsp Edit</a></td>
				<td><a href ="./ProductAction?action=delete&codeProduct=<%=listpro.get(i).getCodeProduct()%>" onclick="return confirmDelete()"class="btn btn-danger btn-xs"><i class="fas fa-trash-alt"></i>&nbsp Delete</a></td>
			</tr>
			<%
				}
			%>
		</table>
	</center>
	
</body>
</html>