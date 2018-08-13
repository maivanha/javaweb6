<%@page import="model.etity.News"%>
<%@page import="model.NewsModel"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" type = "text/css" href="./data/css/style-tintuc.css">

<%
	NewsModel nModel = new NewsModel();
	String id = request.getParameter("id");
	News n = nModel.getNewByIdString(id);
%>
<title><%=n.getTitle() %></title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container" style="max-width: 1000px; margin-top: 10px;">
		<div id = "contents">
		<h1><%=n.getTitle() %></h1>
		<img src="./data/img/TinTuc/<%=n.getImage() %>" alt="">
		<p><%=n.getContents() %></p>
	</div>
	</div>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>