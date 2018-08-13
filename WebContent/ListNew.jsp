<%@page import="model.etity.News"%>
<%@page import="java.util.List"%>
<%@page import="model.NewsModel"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
	<meta charset="utf-8">
	<title> Tin tức công nghệ</title>
	<link rel = "icon" href = "data/img/logo-9.png">
	<link rel="stylesheet" type = "text/css" href="data/css/style-DanhSachTinTuc.css">
	<link rel="stylesheet" type="text/css" href="data/css/style-Header.css">
	<link rel="stylesheet" type="text/css" href="data/css/style-index.css">
	<link rel="stylesheet" type="text/css" href="data/css/style-PhanTrang.css">

	<link rel="stylesheet" href= "../js/bootstrap.min.css">

	<script src = "../js/jquery-3.3.1.min.js"></script>

	<script src= "../js/bootstrap.min.js"></script>
	<style type="text/css">
body {
	margin: 0 auto;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<div class = "boxLeft">
					<h2> THÔNG TIN CÔNG NGHỆ </h2>
					<%
					int pageid;
					
					if(request.getParameter("page") == null) {
						pageid = 1;
					} else {
						pageid = Integer.parseInt(request.getParameter("page"));
					}
					int cpage = pageid;
					int count = 2;
					
					if(pageid == 1) {
						
					} else {
						pageid = pageid - 1;
						pageid = pageid * count + 1;
					}
					
					NewsModel nModel = new NewsModel();
					List<News> dsTinTuc = nModel.getNewPage(pageid - 1, count);
					
					for (int i = 0; i < dsTinTuc.size(); i++) {
					%>
					
						<ul>
						<li><a href = "./PageNew.jsp?id=<%=dsTinTuc.get(i).getCodeNews() %>">
							<img src = "data/img/TinTuc/<%=dsTinTuc.get(i).getImage()%>">
							<h3><%out.print(dsTinTuc.get(i).getTitle()); %></h3>
							<p><%out.print(dsTinTuc.get(i).getContents().substring(0, 65) + "..."); %></p>
						</li></a>
					</ul>
					<%
						}
					%>
					<%
						//out.print(nModel.getCountNew()); 
						int row = nModel.getCountNew();
						
						int sumrow = row / count;
					%>
				</div>
				<div class = "pagination">
					<ul class = "page-numbers">
						<%
						if(pageid == 1) {
						%>
						<li ><a style="cursor: point" class="page-number">&laquo;</a></li>
						<%} else {%>
						<li><a href ="./ListNew.jsp?page=<%=pageid = cpage - 1 %>" class="page-number">&laquo; </a></li>
						<%
						}
							int i;
							for(i = 1; i <= sumrow; i++) {
						%>
						
						<li><a href ="./ListNew.jsp?page=<%=i %>" class="page-number"><%=i %></a></li>
						<%
							}
						%>
						<%
						if(sumrow == pageid + 1) {
						%>
						<li style="display: none"><a href ="./ListNew.jsp?page=<%=pageid = cpage + 1 %>" class="page-number">&raquo;</a></li>
						<%
						} else {
						%>
						<li><a href ="./ListNew.jsp?page=<%=pageid = cpage + 1 %>" class="page-number">&raquo;</a></li>
						<%
						}
						%>
					</ul>
				</div>
			</div>
			<div class="col-md-3">
				<div class = "boxRight" style="background: grey">
					
				</div>
			</div>
		</div>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>