<%@page import="model.etity.ProductType"%>
<%@page import="model.ProductTypeModel"%>
<%@page import="model.etity.Company"%>
<%@page import="java.util.List"%>
<%@page import="model.CompanyModel"%>
<%@page import="model.etity.Product"%>
<%@page import="model.ProductModel"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Quản trị sản phẩm</title>
<link rel="icon" href="data/img/logo-9.png">

</head>
<body>
	
	<h3>Thêm Sản Phẩm</h3>
	<%
		int codeProduct = Integer.parseInt(request.getParameter("codeProduct"));
		ProductModel pModel = new ProductModel();
		Product p = pModel.getProductById(codeProduct);
		
	%>
		<form action="./ProductEditAction?codeProduct=<%=p.getCodeProduct() %>" method="post" enctype="multipart/form-data">
			<table style="border: 1">
				<tr>
					<td>Mã Sản phẩm</td>
					<td><%out.print(p.getCodeProduct()); %></td>
				</tr>
				<tr>
					<td>Tên sản phẩm</td>
					<td><input type="text" name="nameProduct" value="<%=p.getNameProduct() %>"></td>
				</tr>
				<tr>
					<td>Giá tiền</td>
					<td><input type="text" name="price" value="<%=p.getPrice()%>"></td>
				</tr>
				<tr>
					<td>Số lượng dư</td>
					<td><input type="text" name="numberOfpro" value="<%=p.getNumberOfpro()%>"></td>
				</tr>
				<tr>
					<td>Hình ảnh</td>
					<td>
						<input type="file" name="image" placeholder="<%=p.getImage()%>" title="<%=p.getImage()%>">
						<img src="./data/img/smartphone/<%=p.getImage()%>" style="height: 100px; width: 100px" name="imageshow" value="<%=p.getImage()%>">
						
						
						
					</td>
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
						if(listpd.get(i).getCodeSP().equals(p.getCodeSP())) {
							
						
				%>
						<option selected="selected" value="<%=listpd.get(i).getCodeSP()%>"><%=listpd.get(i).getCodeSP()%> - <%=listpd.get(i).getNameSP()%></option>
				<% 		} else { %>
						<option value="<%=listpd.get(i).getCodeSP()%>"><%=listpd.get(i).getCodeSP()%> - <%=listpd.get(i).getNameSP()%></option>
				<%
						}
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
						if(listCom.get(i).getCodeCompany().equals(p.getCodeCompany())) {
							
						
				%>
						<option selected="selected" value="<%=listCom.get(i).getCodeCompany()%>"><%=listCom.get(i).getCodeCompany()%> - <%=listCom.get(i).getNameCompany()%></option>
				<% 		} else { %>
						<option value="<%=listCom.get(i).getCodeCompany()%>"><%=listCom.get(i).getCodeCompany()%> - <%=listCom.get(i).getNameCompany()%></option>
				<%
						}
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