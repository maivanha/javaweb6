<%@page import="java.util.Locale"%>
<%@page import="ulti.PropertiesReader"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="model.etity.News"%>
<%@page import="model.NewsModel"%>
<%@page import="model.ProductModel"%>
<%@page import="model.etity.Product"%>
<%@page import="java.util.List"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld1.tld" prefix="ct"%>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<title>Nabee Trang Chủ</title>
<link rel="icon" href="./data/img/logo-9.png">
	
<!-- Chạy JS ngay khi load trang -->
<body onload="LoadPage(1)">


<!-- include header vào page -->	<!-- bên trong chứa thẻ mở body và html -->
	<jsp:include page="header.jsp"></jsp:include>

	
	<!-- Phần nội dung trang -->
	<div class="container" style="margin-top: 10px;">
		<div id="main">
			<div class="row">
				<div class="col-md-9" style="background: white; min-height: 400px; max-width: 810px">
					<div style="text-align: center;">
						<div class="showCase">
							<span class="sts-bold">ĐIỆN THOẠI</span> <span class="sts-empty">NỔI BẬT</span>
						</div>
					</div>
					
					
					
					<div id ="p"></div>
					<div style="height: 650px;">
<!-- Show Product -->
						<div id="sp" align="center"></div>

<!-- Pagination -->
					<%
						ProductModel pModel = new ProductModel();
						int quantity = pModel.getQuantityProduct();
						int count = 8;
						int row = quantity / count;
						if(quantity % 2 != 0){
							row = row + 1;
						}
					%>
						<div id="Pagi" style="width: 100%; height: 40px; display: inline-block; text-align: center; padding-top: 5px">
					<%
						for(int i = 1; i <= row; i++) {
							if(i == 1) {
					%>
							<button onclick="LoadPage(<%=i %>)" class="btn activePanation"><%=i %></button>
					<%
							} else {
					%>
							<button onclick="LoadPage(<%=i %>)"  class="btn"><%=i %></button>
					<%
							}
						}
					%>
						</div>
					</div>
				</div>


<!-- News -->
				<div class="col-md-3" style="background: white; float: left; max-width: 360px">
					<div class="boxBot">
						<h2 class="nav">
							<a href="./ListNew.jsp?page=1">THÔNG TIN CÔNG NGHỆ</a>
						</h2>
						<ul>
							<%
								NewsModel nModel = new NewsModel();
								List<News> dsTinTuc = nModel.getNews();
								for (int i = 0; i < 6; i++) {
							%>
							<li><a
								href="./PageNew.jsp?page=1&id=<%=dsTinTuc.get(i).getCodeNews()%>">
									<img src="./data/img/TinTuc/<%=dsTinTuc.get(i).getImage()%>">
									<h3><%=dsTinTuc.get(i).getTitle()%></h3>
							</a></li>
							<%
								}
							%>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- Xử lý JS and AJAX -->

	<script type="text/javascript">
	<!-- Pagination-->
		var header = document.getElementById("Pagi");
		var btns = header.getElementsByClassName("btn");
		var i;
		for (i = 0; i < btns.length; i++) {
		  btns[i].addEventListener("click", function() {
		    var current = document.getElementsByClassName("activePanation");
		    current[0].className = current[0].className.replace(" activePanation", "");
		    this.className += " activePanation";
		  });
		}
	
		function LoadPage(para) {
			var xhttp;
			//alert(para);
			var p = para;
			var url = "PaginationAction?page=" + p;

			if (window.XMLHttpRequest) {
				xhttp = new XMLHttpRequest();
			} else {
				xhttp = new ActiveXObject("microsoft.XMLHttp");
			}
			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4) {
					var data = xhttp.responseText;
					document.getElementById("sp").innerHTML = data;
				}
			}
			xhttp.open("POST", url, true);
			xhttp.send();

		}
		
		
		

		
		/*function checkProduct() {
			alert("a");
			var xhttp;
			//alert(para);
			var url = "BuyProduct";

			if (window.XMLHttpRequest) {
				xhttp = new XMLHttpRequest();
			} else {
				xhttp = new ActiveXObject("microsoft.XMLHttp");
			}
			xhttp.onreadystatechange = function() {
				if (xhttp.readyState == 4) {
					var data = xhttp.responseText;
					document.getElementById("test").innerHTML = data;
				}
			}
			xhttp.open("GET", url, true);
			xhttp.send();
			
		}*/
		
		
		
		
	</script>
	
<!-- Footer -->		<!-- bên trong chứa thẻ đóng body và html -->
	<%@ include file="footer.jsp"%>
	
	<%
		String Mess = (String)request.getAttribute("Mess");
		if(Mess != null) {
	%>
		<script>
				alert("<%=Mess%>");
		</script>
		<%
		}
		%>

