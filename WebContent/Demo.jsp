<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String Mess = (String)request.getAttribute("Mess");
	if(Mess != null) {
		out.print(Mess);
		
	}
%>
	
	
