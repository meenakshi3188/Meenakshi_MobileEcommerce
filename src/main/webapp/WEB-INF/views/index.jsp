<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List,org.springframework.beans.factory.annotation.Autowired,
	com.niit.mobilestoreapps.dao.ProductImpl,com.niit.mobilestoreapps.service.ProductService,
	com.niit.mobilestoreapps.model.Product"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <meta http-equiv="refresh" content="0; URL=./onLoad1">-->

<title>Insert title here</title>
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<style>
.dropdown-submenu {
	position: relative;
}

.dropdown-submenu>.dropdown-menu {
	top: 0;
	left: 100%;
	margin-top: -6px;
	margin-left: -1px;
	-webkit-border-radius: 0 6px 6px 6px;
	-moz-border-radius: 0 6px 6px;
	border-radius: 0 6px 6px 6px;
}

.dropdown-submenu:hover>.dropdown-menu {
	display: block;
}

.dropdown-submenu>a:after {
	display: block;
	content: " ";
	float: right;
	width: 0;
	height: 0;
	border-color: transparent;
	border-style: solid;
	border-width: 5px 0 5px 5px;
	border-left-color: #ccc;
	margin-top: 5px;
	margin-right: -10px;
}

/*.dropdown-submenu:hover>a:after {
    border-left-color: #fff;
}*/

/*.dropdown-submenu.pull-left {
    float: none;
}*/
.dropdown-submenu.pull-left>.dropdown-menu {
	left: -100%;
	margin-left: 10px;
	-webkit-border-radius: 6px 0 6px 6px;
	-moz-border-radius: 6px 0 6px 6px;
	border-radius: 6px 0 6px 6px;
}
</style>
</head>
<body>
	<%!
ProductImpl prod_srv = new ProductImpl();
%>
	<br>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<!--<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>-->
				<a href="index.jsp" class="navbar-brand"><img
					src="resources/images/logo.jpg" style="width: 200px; height: 40px;"></a>

				<!--<div class="col-md-3 navbar-right">
					<div class="navbar-form" role="search">
						<div class="input-group">
							<input type="text" placeholder="Search" class="" name="srch-term" >
							<div class="input-group-btn">
								<button class="btn btn-default" value="Search" type="submit">
								<i class="glyphicon glyphicon-search"></i></button>
							</div>
						</div>
					</div>
				</div>-->
				<form class="navbar-form pull-right form-search">
					<div class="input-append">
						<input data-provide="typeahead" data-items="4" type="text"
							class="span2 search-query">
						<button class="btn">Search</button>
					</div>
				</form>
			</div>
			<br> <br> <br>

			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index">Home</a></li>
					<li><a href="about.jsp">About Us</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Brands <span class="caret"></span></a> <!--<ul class="dropdown-menu">
								<c:forEach items="${brandsLst1}" var="id">
									<li>${id.brand_name}</li>
								</c:forEach>--> <!-- <li><a href="htc.jsp">HTC</a></li>
							</ul>--> <!-- For display product sub menu -->

						<ul class="dropdown-menu multi-level" role="menu">
							<c:forEach items="${brandsLst1}" var="id">
								<li class="dropdown-submenu"><a href="#">${id.brand_name}</a>
									<ul class="dropdown-menu">
										<c:forEach items="${prdLst}" var="prd">
											<c:if test="${id.brand_id==prd.brand_id}">
												<li><a href="#">${prd.product_name}</a></li>
											</c:if>
										</c:forEach>
									</ul></li>
							</c:forEach>
						</ul>
					<li><a href="service.jsp">Services</a></li>
					<li><a href="contact.jsp">Contact Us</a></li>
				</ul>

				<ul class="nav navbar-nav navbar-right">
					<li><a href="login">Login</a></li>
					<li><a href="register">Register</a></li>
				</ul>
			</div>
		</div>
	</div>

	<div id="myCarousel" class="carousel slide">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>

		</ol>

		<div class="carousel-inner">
			<div class="item active">
				<div class="fill">
					<img src="resources/images/img1.jpg"
						style="width: 100%; height: 500px;">
				</div>
			</div>
			<div class="item">
				<div class="fill">
					<img src="resources/images/img2.jpg"
						style="width: 100%; height: 500px;">
				</div>
			</div>

			<div class="item">
				<div class="fill">
					<img src="resources/images/img3.jpg"
						style="width: 100%; height: 500px;">
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

	<a href="BrandOpt">Show Brands</a>
	<a href="addBrand">Add Brands</a>
	<a href="product">Product</a>
	<a href="supplier">Supplier</a>
	<br>
	<br>
	<div class="row">
		<div class="col-sm-2">
			<a href="#">All Brands</a><br>
			<c:forEach items="${brandsLst1}" var="id">
				<a href="#">${id.brand_name}</a>
				<br>
			</c:forEach>
		</div>

		<div class="col-sm-10">
			<c:forEach items="${prdLst}" var="prd">
				<img src="${prd.product_image}" width="120px" height="150px"/>
				${prd.product_model}
				${prd.product_name}
				Rs ${prd.product_price}
				<button type="button" class="btn btn-primary btn-xs">Add Cart</button>
			</c:forEach>
		</div>

	</div>

	<!--  <div class="navbar navbar-inverse navbar-fixed-bottom">
		<ul class="nav navbar-nav">
			<li class="active"><a href="index">Home</a></li>
			<li><a href="about.jsp">About Us</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-haspopup="true"
				aria-expanded="false">Brands <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="samsung.jsp">Samsung</a></li>
					<li><a href="apple.jsp">Apple</a></li>
					<li><a href="htc.jsp">HTC</a></li>
					<li><a href="sony.jsp">Sony</a></li>

				</ul></li>
			<li><a href="service.jsp">Services</a></li>
			<li><a href="contact.jsp">Contact Us</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="login">Login</a></li>
			<li><a href="register">Register</a></li>
		</ul>
	</div>-->

</body>
</html>