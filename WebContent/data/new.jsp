<%@page import="model.etity.News"%>
<%@page import="java.util.List"%>
<%@page import="model.NewsModel"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html">
<html>
<head>
<title>Quản trị Tin Tức</title>
<link rel="icon" href="data/img/logo-9.png">

</head>
<body>
	<h3>Tin tức</h3>
	<a href="./admin.jsp?f=InsertNews">Thêm tin tức</a>
	<table class="table table-responsive table-hover table-striped table-condensed">
		<tr>
			<th>ID</th>
			<th>Tiêu đề</th>
			<th>Hình ảnh</th>
			<th colspan="3">Content</th>

		</tr>
		<%
				NewsModel nModel = new NewsModel();
				List<News> listNew = nModel.getNews();

				for (int i = 0; i < listNew.size(); i++) {
			%>
		<tr>
			<td align="center">
				<%
						out.print(listNew.get(i).getCodeNews());
					%>
			</td>
			<td>
				<%
						out.print(listNew.get(i).getTitle());
					%>
			</td>
			<td><img src="data/img/TinTuc/<%=listNew.get(i).getImage()%>"
				width="70" height="50"></td>
			<td>
				<%
						out.print(listNew.get(i).getContents().substring(0, 65) + "...");
				%>
			</td>
			<td><a
				href="./admin.jsp?id=<%=listNew.get(i).getCodeNews()%>&f=EditNew"class="btn btn-success btn-xs"><i class="far fa-edit"></i>&nbsp Edit</a></td>
			<td><a
				href="./NewDeleteAction?id=<%=listNew.get(i).getCodeNews()%>"
				onclick="return confirmDelete()"class="btn btn-danger btn-xs"><i class="fas fa-trash-alt"></i>&nbsp Delete</a></td>
		</tr>
		<%
				}
			%>
	</table>

</body>
</html>