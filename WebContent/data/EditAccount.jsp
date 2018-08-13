<%@page import="model.etity.Account"%>
<%@page import="model.etity.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.AccountModel"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Sửa thông tin user</title>
</head>
<body>
	<%
		AccountModel aModel = new AccountModel();
		String username = request.getParameter("username");
		Customer cus = aModel.getDetailAccountByName(username);
		Account acc = aModel.getAccount(cus.getUsername(), cus.getUserpass());
	%>
	<form
		action="./AccountUpdateAction?id=<%=cus.getId()%>&username=<%=cus.getUsername()%>"
		method="post">
		<div class="form-group">
			<label>ID</label>
			<%out.print(cus.getId()); %>
		</div>
		<div class="form-group">
			<label>Tài khoản</label>

			<%out.print(cus.getUsername());%>
		</div>
		<div class="form-group">
			<label>Họ Tên</label> <input type="text" class="form-control"
				name="fullname" value="<%=cus.getFullname()%>">
		</div>
		<div class="form-group">
			<label>Địa chỉ</label> <input type="text" class="form-control"
				name="address" value="<%=cus.getAddress()%>">
		</div>
		<div class="form-group">
			<label>Số điện thoại</label> <input type="text" class="form-control"
				name="mobile" value="<%=cus.getMobile()%>">
		</div>
		<div class="form-group">
			<label>Email</label> <input type="text" class="form-control"
				name="email" value="<%=cus.getEmail()%>">
		</div>
		<a href="./admin.jsp?f=account"><input type="button"
			value="Trở lại"></a> <a
			href="./admin.jsp?f=EditPassword&username=<%=cus.getUsername() %>"><input
			type="button" value="Đổi Mật khẩu"></a> <input type="submit"
			name="submit" value="Cập nhật">

	</form>
</body>
</html>