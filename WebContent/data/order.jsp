<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.etity.Orders"%>
<%@page import="java.util.List"%>
<%@page import="model.OrdersModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<h3>Hóa đơn</h3>
		<table class="table table-responsive table-hover table-striped table-condensed">
			<%
				// Khởi tạo đối tượng để định dạng mệnh giá tiền
				DecimalFormat fomat = new DecimalFormat("###,###,###");
			%>
			<tr>
				<th>ID</th>
				<th>Ngày mua</th>
				<th>Ngày nhận</th>
				<th>Người mua</th>
				<th>Địa chỉ</th>
				<th>Email</th>
				<th colspan="4">Tổng tiền</th>
			</tr>
			<%
				OrdersModel oModel = new OrdersModel();
				List<Orders> list = oModel.getAllOrder();
				
				if(list.size() == 0) {
			%>
					<tr>
						<td colspan="7" align="center" style="color: blue"><%out.print("Hiện chưa có order nào !"); %></td>
					</tr>
			<%
				} else {
				for(int i = 0; i < list.size(); i++) {
					
			%>
			<%
				if(list.get(i).getStatuss() == 1) {
			%>
			<tr style="background-color: #80f384">
			<%
				} else if (list.get(i).getStatuss() == 2) {
			%>
			<tr style="background-color: #f3a180">
			<%
				} else {
			%>
			<tr>
			<%
				}
			%>
				<td align ="center"><%out.print(list.get(i).getCodeOrder()); %></td>
				<td><%out.print(list.get(i).getDateOrder()); %></td>
				<td><%out.print(list.get(i).getReceivedDate()); %></td>
				<td><%out.print(list.get(i).getFullname()); %></td>
				<td><%out.print(list.get(i).getAddress()); %></td>
				<td><%out.print(list.get(i).getEmail()); %></td>
				<td><%=fomat.format(list.get(i).getPrice_order()) %><%= " VNĐ" %></td>
				<td><a href ="./admin.jsp?codeOrder=<%=list.get(i).getCodeOrder()%>&f=orderDetail">Chi tiết</a></td>
				<td><a href ="./admin.jsp?codeOrder=<%=list.get(i).getCodeOrder()%>&f=EditOrder"class="btn btn-success btn-xs"><i class="far fa-edit"></i>&nbsp Edit</a></td>
				<td><a href ="./OrderDeleteAction?codeOrder=<%=list.get(i).getCodeOrder()%>" onclick="return confirmDelete()"class="btn btn-danger btn-xs"><i class="fas fa-trash-alt"></i>&nbsp Delete</a></td>
			</tr>
			<%
					}
				}
			%>
		</table>
</body>
</html>