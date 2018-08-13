<%@page import="model.etity.Orders"%>
<%@page import="java.util.List"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<table class="table table-responsive table-hover table-striped table-condensed" style="font-size: 12;">
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
				
				List<Orders> list = (List<Orders>)request.getAttribute("listOrder");
				
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
				if(list.get(i).getStatuss() == 2 || list.get(i).getStatuss() == 1) {
			
				} else {
			%>
				<tr>
					<td align ="center"><%out.print(list.get(i).getCodeOrder()); %></td>
					<td><%out.print(list.get(i).getDateOrder()); %></td>
					<td><%out.print(list.get(i).getReceivedDate()); %></td>
					<td><%out.print(list.get(i).getFullname()); %></td>
					<td><%out.print(list.get(i).getAddress()); %></td>
					<td><%out.print(list.get(i).getEmail()); %></td>
					<td><%=fomat.format(list.get(i).getPrice_order()) %><%= " VNĐ" %></td>
					<td><a href ="./admin.jsp?codeOrder=<%=list.get(i).getCodeOrder()%>&f=orderDetail"class="btn btn-success btn-xs"><i class="far fa-edit"></i>&nbsp Chi tiết</a></td>
					<td><a href ="./OrderDeleteAction?codeOrder=<%=list.get(i).getCodeOrder()%>" onclick="return confirmDelete()"class="btn btn-danger btn-xs"><i class="fas fa-trash-alt"></i>&nbsp Delete</a></td>
				</tr>
			<%
				}
			%>
				
			<%
					}
				}
			%>
		</table>