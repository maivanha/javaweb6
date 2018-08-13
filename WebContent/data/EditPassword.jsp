<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
		String username = request.getParameter("username");
	%>
<form action="./AccountEditPassAction?username=<%=username %>"
	method="post">
	<div class="form-group">
		<label>Mật khẩu cũ</label> <input type="password" name="passOld"
			class="form-control">
	</div>
	<div class="form-group">
		<label>Mật khẩu mới:</label> <input type="password" name="passNew"
			class="form-control">
	</div>


	<a href="./admin.jsp?f=account"><input type="button"
		value="Trở lại"></a> <input type="submit" name="submit"
		value="Cập nhật">
</form>