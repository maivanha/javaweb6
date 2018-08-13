<%@page import="model.etity.Company"%>
<%@page import="model.CompanyModel"%>
<%@page import="model.etity.ProductType"%>
<%@page import="java.util.List"%>
<%@page import="model.ProductTypeModel"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Quản trị sản phẩm</title>
<link rel="icon" href="data/img/logo-9.png">

</head>
<body>

	<h3>Thêm Sản Phẩm</h3>
		<form action="./ProductAction?action=insert" method="post" enctype="multipart/form-data">
			<table style="border: 1">
				<tr>
					<td>Tên sản phẩm</td>
					<td><input type="text" name="nameProduct"></td>
				</tr>
				<tr>
					<td>Giá tiền</td>
					<td><input type="text" name="price"></td>
				</tr>
				<tr>
					<td>Số lượng nhập</td>
					<td><input type="text" name="numberOfpro"></td>
				</tr>
				<tr>
					<td>Hình ảnh</td>
					<td><input type="file" name="image"></td>
				</tr>
				<%
					ProductTypeModel pdModel = new ProductTypeModel();
					List<ProductType> listpd = pdModel.getAllProductType();
				%>
				<tr>
					<td>Mã loại sản phẩm</td>
					<td><select name="codeSP">
				<%
					for(int i = 0; i < listpd.size(); i++) {
				%>
						<option value="<%=listpd.get(i).getCodeSP()%>"><%=listpd.get(i).getCodeSP()%> - <%=listpd.get(i).getNameSP()%></option>
				<%
					}
				%>
					</select></td>
				</tr>
				<%
					CompanyModel cModel = new CompanyModel();
					List<Company> listCom = cModel.getAllCompany();
				%>
				<tr>
					<td>Mã hãng sản xuất</td>
					<td><select name="codeCompany">
				<%
					for(int i = 0; i < listCom.size(); i++) {
				%>
						<option value="<%=listCom.get(i).getCodeCompany()%>"><%=listCom.get(i).getCodeCompany()%> - <%=listCom.get(i).getNameCompany()%></option>
				<%
					}
				%>
					</select></td>
				</tr>
			</table>
			<input type="submit" value="Xác nhận">
		</form>
		<a href="./admin.jsp?f=product"><input type="button" value="Trở lại" /></a>

</body>
</html>