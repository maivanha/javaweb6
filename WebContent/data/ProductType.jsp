
<%@page import="model.etity.ProductType"%>
<%@page import="java.util.List"%>
<%@page import="model.ProductTypeModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loại sản phẩm</title>
</head>
<body>
	<%
		ProductTypeModel pdModel = new ProductTypeModel();
		List<ProductType> list = pdModel.getAllProductType();
		
	%>
	<a href ="./admin.jsp?f=InsertProductType">Thêm loại sản phẩm</a>
	<h3>Loại sản phẩm</h3>
	<table class="table table-responsive table-hover table-striped table-condensed">
		<tr align ="center">
			<th>Mã loại sản phẩm</th>
			<th colspan="3" >Tên loại sản phẩm</th>
		</tr>
		<%
			for(int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td><%=list.get(i).getCodeSP() %></td>
			<td><%=list.get(i).getNameSP() %></td>
			<td><a href ="./admin.jsp?codeSP=<%=list.get(i).getCodeSP()%>&f=EditProductType"class="btn btn-success btn-xs"><i class="far fa-edit"></i>&nbsp Edit</a></td>
				<td><a href ="./ProductTypeAction?action=delete&codeSP=<%=list.get(i).getCodeSP()%>" onclick="return confirmDelete()"class="btn btn-danger btn-xs"><i class="fas fa-trash-alt"></i>&nbsp Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
</body>
</html>