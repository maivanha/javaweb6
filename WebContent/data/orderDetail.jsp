<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="model.OrdersDetailModel"%>
<%@page import="model.etity.OrdersDetail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<h3>Chi tiết Hóa đơn</h3>

	<a href = "./admin.jsp?f=order" style="float: right; margin-right: 140px"><input type="button" value="Quay lại"></a>
		<table class="table table-responsive table-hover table-striped table-condensed">
			<%
				// Khởi tạo đối tượng để định dạng mệnh giá tiền
				DecimalFormat fomat = new DecimalFormat("###,###,###");
			%>
			<tr>
				<th>ID</th>
				<th>Mã sản phẩm</th>
				<th>Tên sản phẩm</th>
				<th>Sổ lượng</th>
				<th>Giá tiền</th>
				<th>Tổng tiền</th>
			</tr>
			<%
				int codeOrder = Integer.parseInt(request.getParameter("codeOrder"));
				OrdersDetailModel odModel = new OrdersDetailModel();
				List<OrdersDetail> list = odModel.getOrdersDetailById(codeOrder);
				
				for(int i = 0; i < list.size(); i++) {
			%>
			<tr>
				<td align ="center"><%out.print(list.get(i).getCodeOrder()); %></td>
				<td><%out.print(list.get(i).getCodeProduct()); %></td>
				<td><%out.print(list.get(i).getNameProduct()); %></td>
				<td><%out.print(list.get(i).getQuantity()); %></td>
				<td><%out.print(fomat.format(list.get(i).getPrice()) + " VNĐ"); %></td>
				<td><%out.print(fomat.format(list.get(i).getPrice_total()) + " VNĐ"); %></td>
				
			</tr>
			<%
				} 
			%>
		</table>
</body>
</html>