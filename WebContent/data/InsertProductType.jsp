<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<form action="./ProductTypeAction" method="post">
		<table class="table table-responsive table-hover table-striped table-condensed">
			<tr align="center">
				<th>Mã loại sản phẩm</th>
				<th>Tên loại sản phẩm</th>
			</tr>
			<tr>
				<td><input type ="text" name="codeSP"></td>
				<td><input type ="text" name="nameSP"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="./admin.jsp?f=ProductType"><input type="button" value="Trở về"></a>
				<input type = "submit" value = "Đồng ý"></td>
			</tr>
		</table>
	</form>
</body>
</html>