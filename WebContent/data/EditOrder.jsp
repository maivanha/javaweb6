<%@page import="java.text.DecimalFormat"%>
<%@page import="model.etity.Orders"%>
<%@page import="model.OrdersModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<center>
		<form action="./OrderEditAction" method="post">
			<table>
				<%
					// Khởi tạo đối tượng để định dạng mệnh giá tiền
					DecimalFormat fomat = new DecimalFormat("###,###,###");
				%>
				<%
					String codeOrder = request.getParameter("codeOrder");
					out.print(codeOrder);
					OrdersModel oModel = new OrdersModel();
					Orders o = new Orders();
					o = oModel.getOrderByIdString(codeOrder);
				%>
				<tr>
					<td>ID</td>
					<td><input type = "text" name="codeOrder" value="<%=o.getCodeOrder()%>"></td>
				</tr>
				<tr>
					<td>Ngày đặt hàng</td>
					<td><%=o.getDateOrder()%></td>
				</tr>
				<tr>
					<td>Ngày nhận hàng</td>
					<td><input type="date" name="receiveddate" value="<%=o.getReceivedDate()%>"></td>
				</tr>
				<tr>
					<td>Người đặt</td>
					<td><input type = "text" name="fullname" value="<%=o.getFullname()%>"></td>
				</tr>
				<tr>
					<td>Địa chỉ</td>
					<td><input type = "text" name ="address" value ="<%=o.getAddress()%>"></td>
				</tr>
				<tr>
					<td>email</td>
					<td><input type = "text" name ="email" value ="<%=o.getEmail()%>"></td>
				</tr>
				<tr>
					<td>Tổng tiền</td>
					<td><%=fomat.format(o.getPrice_order()) %><%=	" VNĐ"%></td>
				</tr>
			</table>
			<a href="./admin.jsp?codeOrder=<%=o.getCodeOrder()%>&f=order""><input type="button" value="Trở về"></a>
			<input type="submit" value="Cập nhật">
		</form>
	</center>
</body>
</html>