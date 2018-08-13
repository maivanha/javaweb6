<%@page import="model.etity.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style type="text/css">
.box {
	position: absolute;
	width: 200px;
	max-height: 500px;
	background: white;
	right: 0.4%;
	top: 101%;
	z-index: 1;
	border-radius: 5px;
}

.box ul {
	padding: 0px;
	margin: 0px;
}

.box ul a {
	text-decoration: none;
}

.box ul a li {
	float: none !important;
	min-height: 40px;
	line-height: 40px;
	margin-bottom: 3px;
	padding-left: 5px;
}

.box ul a li:hover {
	background: lightblue;
	border-radius: 5px;
}
</style>
<script src="./js/header.js"></script>

<div class="box">
	<ul>
		<%
			String ketqua = (String)request.getAttribute("Ketqua");
			
				
			if(ketqua != null) {
		%>
			<a><li><%out.print(ketqua); %></li></a>
		<%
			} else {
				List<Product> list = new ArrayList<>();
				list = (List<Product>)request.getAttribute("listproduct");
				for(int i = 0; i < list.size(); i++) {
		%>
			<a href="./InformationProduct.jsp?codeProduct=<%=list.get(i).getCodeProduct() %>"><li>
			<img src="./data/img/smartphone/<%=list.get(i).getImage()%>" style="width: 32px; height: 32px"><%=list.get(i).getNameProduct() %></li></a>
		<%		
				}
			}
		%>
	</ul>
</div>
