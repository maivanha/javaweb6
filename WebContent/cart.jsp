<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.etity.Product"%>
<%@page import="model.ProductModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>



<center>
	<%
	// Khởi tạo đối tượng để định dạng mệnh giá tiền
	DecimalFormat fomat = new DecimalFormat("###,###,###");
	%>
	<form action="./SaveOrders" method="post">
		<input type="button" class="btn btn-primary" value="Mua thêm" onclick="hidepopup('p1')">

		<table class="table table-responsive table-hover table-striped table-condensed">
			<tr style="background-color: lightblue;">
				<th>Mã Sản phẩm</th>
				<th>Tên Sản phẩm</th>
				<th>Hình ảnh</th>
				<th>Hàng sẵn có</th>
				<th>Số Lượng</th>
				<th>Giá</th>
				<th>Thao Tác</th>
			</tr>
			<%
					List<Product> dsGioHang = new ArrayList();
					int PriceTotal = 0;
					// Kiểm tra giỏ hàng nếu trong
					if (request.getAttribute("listGioHang") == null) {
			%>
				<tr>
					<td colspan="6" style="text-align: center">Chưa có sản phẩm nào trong giỏ hàng</td>
				</tr>
			<%		
					} else {
							//dsGioHang = (List<Product>) session.getAttribute("dsGioHang");
							dsGioHang = (List<Product>) request.getAttribute("listGioHang");
					}
				%>
			<%
					for (int i = 0; i < dsGioHang.size(); i++) {
				%>
			<tr>
				<td>
					<%
							out.print(dsGioHang.get(i).getCodeProduct());
						%>
				</td>
				<td>
					<%
							out.print(dsGioHang.get(i).getNameProduct());
						%>
				</td>
				<td><img
					src="data/img/smartphone/<%=dsGioHang.get(i).getImage()%>"
					style="width: 50px; height: 50px;"></td>
				<td>
					<%out.print(dsGioHang.get(i).getNumberOfpro()); %>
				</td>
				<td>
						<input type="number" name="countbuy" min="1" value="<%=dsGioHang.get(i).getCountbuy()%>" onchange="changeCountBuy('<%=dsGioHang.get(i).getCodeProduct()%>','<%=i%>')"/>
				</td>
				<td>
					<%
							out.print(fomat.format(dsGioHang.get(i).getPrice()));
						%><%=" VNĐ"%>
				</td>
				<td><a class="btn btn-danger btn-xs" onclick = "showpopup('p1','DeleteOneProduct?codeProduct=<%=dsGioHang.get(i).getCodeProduct()%>')"><i class="fas fa-trash-alt"></i>&nbsp
						Delete</a>
				</td>
			</tr>
			<%
					PriceTotal += dsGioHang.get(i).getCountbuy() * dsGioHang.get(i).getPrice();
					}
			%>
			<tr>
				<td colspan="4" align="right"
					style="font-weight: bold; padding-right: 50px;">Tổng tiền:</td>
				<td colspan="2">
					<%
							out.print(fomat.format(PriceTotal));
					%><%=" VNĐ"%></td>
			</tr>
		</table>
		<input type="submit" class="btn btn-success" value="Đặt hàng">
	</form>
</center>

