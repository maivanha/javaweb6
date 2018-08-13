<%@page import="model.etity.News"%>
<%@page import="model.NewsModel"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html">
<html>
<head>
<title>Quản trị Tin Tức</title>
<link rel="icon" href="data/img/logo-9.png">

<script type="text/javascript" src="<%=request.getContextPath()%>/libckeditor/ckeditor/ckeditor.js"></script>

</head>
<body>
<%
	int codeNew = Integer.parseInt(request.getParameter("id"));
	NewsModel nModel = new NewsModel();
	News n = nModel.getNewById(codeNew);
%>
	<form action="./NewsAction?action=edit&id=<%=codeNew%>" method="post" enctype="multipart/form-data">
		<h3 style="text-align: left;">Tiêu đề</h3>
		<input type="text" name="title" size="50" value="<%=n.getTitle() %>" width="400">
		<h3 style="text-align: left;">Image</h3>
		<img src="data/img/TinTuc/<%=n.getImage()%>" width="300"; height="200">
		<input type="file" name="image" size="50" value="<%=n.getImage()%>"><%=n.getImage()%></input>
		<h3 style="text-align: left;">Nội Dung</h3>
		<textarea rows="10" cols="10" id="editor" name="contents" style="width: 100%; height: 200px"><%=n.getContents() %></textarea>
		
		<input type="submit" value="Xác Nhận">
	</form>
	<a href="./admin.jsp?f=new"><input type="button" value="Trở lại"/></a>
	
<script>
	CKEDITOR.replace('editor');
</script>
</body>
</html>