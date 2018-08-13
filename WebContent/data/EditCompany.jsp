<%@page import="model.etity.Company"%>
<%@page import="model.CompanyModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
			<%
				String codeCompany = request.getParameter("codeCompany");
				CompanyModel cModel = new CompanyModel();
				Company c = cModel.getAllCompanyById(codeCompany);
			%>
	<form action="./CompanyEditAction?codeCompany=<%=c.getCodeCompany() %>" method="post">
		<table class="table table-responsive table-hover table-striped table-condensed">
			<tr align="center">
				<th>Mã hãng sản xuất</th>
				<th>Tên hãng sản xuất</th>
			</tr>
			<tr>
				<td><%=c.getCodeCompany()%></td>
				<td><input type ="text" name="nameCompany" value="<%=c.getNameCompany()%>"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="./admin.jsp?f=company"><input type="button" value="Trở về"></a>
				<input type = "submit" value = "Cập nhật"></td>
			</tr>
		</table>
	</form>
</body>
</html>