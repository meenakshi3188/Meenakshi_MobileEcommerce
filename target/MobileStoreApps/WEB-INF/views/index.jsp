<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="~/"> Logo</a>
				<div class="col-md-6 col-sm-8 col-xs-11 navbar-left">
					<div class="navbar-form " role="search">
						<div class="input-group">
							<input type="text" placeholder="Search" name="srch-term">
							<div class="input-group-btn">
								<button class="btn btn-info" value="Search" type="submit">Search</button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About Us</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Product <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="android.jsp">Android</a></li>
							<li><a href="ios.jsp">IOS</a></li>
							<li><a href="windows.jsp">Windows</a></li>
						</ul></li>
					<li><a href="service.jsp">Services</a></li>
					<li><a href="contact.jsp">Contact Us</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="login.jsp">Login</a></li>
					<li><a href="login.jsp">Register</a></li>
				</ul>
			</div>
		</div>
	</div>


	<!-- <div class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="panel panel-default panel-screen">
			<div class="panel-heading">Logo
			<input type="text" value="" placeholder="Search" >Search
			</div>
			<div class="panel-body">
			<nav class="navbar navbar-inverse navbar-static-top">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="about.jsp">About Us</a></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Product <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="android.jsp">Android</a></li>
							<li><a href="ios.jsp">IOS</a></li>
							<li><a href="windows.jsp">Windows</a></li>
						</ul></li>
					<li><a href="service.jsp">Services</a></li>
					<li><a href="contact.jsp">Contact Us</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
					<li><a href="login.jsp">Login</a></li>
					<li><a href="login.jsp">Register</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>
	
</div>-->
	<div id="myCarousel" class="carousel slide" style="margin-top: -20px;">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>

		</ol>

		<div class="carousel-inner">
			<div class="item active">
				<div class="fill">
					<img src="resources/images/img1.jpg"
						style="width: 100%; height: 400px;">
				</div>
			</div>
			<div class="item">
				<div class="fill">
					<img src="resources/images/img2.jpg"
						style="width: 100%; height: 400px;">
				</div>
			</div>

			<div class="item">
				<div class="fill">
					<img src="resources/images/img3.jpg"
						style="width: 100%; height: 400px;">
				</div>
			</div>

		</div>

		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>

	</div>

</body>
</html>
