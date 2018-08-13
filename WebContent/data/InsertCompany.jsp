<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<form action="./CompanyAction" method="post">
		<table class="table table-responsive table-hover table-striped table-condensed">
			<tr align="center">
				<th>Mã hãng sản xuất</th>
				<th>Tên hãng sản xuất</th>
			</tr>
			<tr>
				<td><input type ="text" name="codeCompany"></td>
				<td><input type ="text" name="nameCompany"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="./admin.jsp?f=company"><input type="button" value="Trở về"></a>
				<input type = "submit" value = "Đồng ý"></td>
			</tr>
		</table>
	</form>
</body>
</html>