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
	<form action="./NewsAction?action=insert" method="post" enctype="multipart/form-data">
		<h3 style="text-align: left;">Tiêu đề</h3>
		<input type="text" name="title" size="50">
		<h3 style="text-align: left;">Image</h3>
		<input type="file" name="image">
		<h3 style="text-align: left;">Nội Dung</h3>
		<textarea rows="10" cols="10" id="editor" name="contents" style="width: 100%; height: 200px"></textarea>
		
		<input type="submit" value="Xác Nhận">
	</form>
	<a href="./admin.jsp?f=new"><input type="button" value="Trở lại"/></a>
	
<script>
	CKEDITOR.replace('editor');
</script>
</body>
</html>