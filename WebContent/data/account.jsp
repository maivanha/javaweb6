<%@page import="model.etity.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.AccountModel"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Trang Quản trị thành viên</title>

</head>
<body>
		<h3>Tài khoản</h3>
		<h4> Tìm kiếm</h4>
		<input type="text" name="search" id="search" placeholder="Tìm kiếm.." >
		<table class="table table-responsive table-hover table-striped table-condensed">
		
			<tr>
				<th>ID</th>
				<th>Tài khoản</th>
				<th>Họ Tên</th>
				<th>Địa chỉ</th>
				<th>Số điện thoại</th>
				<th colspan="3">Email</th>
			</tr>
			<%
				AccountModel aModel = new AccountModel();
				ArrayList<Customer> listCus = aModel.getAllDetailCustomers();
				
				for(int i = 0; i < listCus.size(); i++) {
			%>
			<tr>
				<td align ="center"><%out.print(listCus.get(i).getId()); %></td>
				<td><%out.print(listCus.get(i).getUsername()); %></td>
				<td><%out.print(listCus.get(i).getFullname()); %></td>
				<td><%out.print(listCus.get(i).getAddress()); %></td>
				<td><%out.print(listCus.get(i).getMobile()); %></td>
				<td><%out.print(listCus.get(i).getEmail()); %></td>
				<td><a href ="./admin.jsp?username=<%=listCus.get(i).getUsername()%>&f=EditAccount" class="btn btn-success btn-xs"><i class="far fa-edit"></i>&nbsp Edit</a></td>
				<td><a href ="./AccountDeleteAction?id=<%=listCus.get(i).getId()%>" onclick="return confirmDelete()" class="btn btn-danger btn-xs"><i class="fas fa-trash-alt"></i>&nbsp Delete</td>
			</tr>
			<%
				} 
			%>
		</table>

</body>
</html>