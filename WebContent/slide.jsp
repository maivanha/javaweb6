<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
	<!-- Silde -->
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<!-- Mấy cái chọn chấm chấm ở silde-->
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="data/img/Slide/5.png" alt="Image" style="width: 100%">
				</div>

				<div class="item">
					<img src="data/img/Slide/2.png" alt="Image" style="width: 100%">
				</div>
				<div class="item">
					<img src="data/img/Slide/3.png" alt="Image" style="width: 100%">
				</div>
				<div class="item">
					<img src="data/img/Slide/4.png" alt="Image" style="width: 100%">
				</div>
				<div class="item">
					<img src="data/img/Slide/1.png" alt="Image" style="width: 100%">
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
</body>
</html>