<%@page import="model.etity.Company"%>
<%@page import="java.util.List"%>
<%@page import="model.CompanyModel"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		CompanyModel cModel = new CompanyModel();
		List<Company> ListCom = cModel.getAllCompany();
		
		
	%>
	<a href = "./admin.jsp?f=InsertCompany">Thêm hãng sản xuất</a>
	<h3>Hãng sản xuất</h3>
	<table class="table table-responsive table-hover table-striped table-condensed">
		<tr align ="center">
			<th>STT</th>
			<th>Mã hãng sản xuất</th>
			<th colspan="3">Tên hãng sản xuất</th>
		</tr>
		<%
			for(int i = 0; i < ListCom.size(); i++) {
		%>
		<tr>
			<td><%=i + 1 %></td>
			<td><%=ListCom.get(i).getCodeCompany() %></td>
			<td><%=ListCom.get(i).getNameCompany() %></td>
			<td><a href ="./admin.jsp?codeCompany=<%=ListCom.get(i).getCodeCompany()%>&f=EditCompany"class="btn btn-success btn-xs"><i class="far fa-edit"></i>&nbsp Edit</a></td>
				<td><a href ="./CompanyAction?action=delete&codeCompany=<%=ListCom.get(i).getCodeCompany()%>" onclick="return confirmDelete()"class="btn btn-danger btn-xs"><i class="fas fa-trash-alt"></i>&nbsp Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	
</body>
</html>