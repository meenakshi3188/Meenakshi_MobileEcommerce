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
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
	
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
	<!--  <a href="BrandOpt">Show Brands</a>
	<a href="addBrand">Add Brands</a>
	<a href="product">Product</a>
	<a href="supplier">Supplier</a>-->
	<br>
	<br>
	<h2>${message}</h2>
	<h2>${msg}</h2>

	<div class="row">
		<!--  <div class="col-sm-2">
			<a href="#">All Brands</a><br>
			<c:forEach items="${brandsLst1}" var="id">
				<a href="brandWiseProduct/${id.brand_id}">${id.brand_name}</a>
				<br>
			</c:forEach>
		</div>-->
		<c:forEach items="${prdLst}" var="prd">
			<div class="col-sm-4 col-lg-4 col-md-4">
				<div class="thumbnail">
					<img src="${prd.product_image}" alt="" width="90px" height="90px">
					<div class="caption">
						<h4 class="pull-right">Rs ${prd.product_price}</h4>
						<h4>
							<a href="#">${prd.product_name}</a>
						</h4>
						<a href="cart?id=${prd.product_id}">Add To Cart</a>
					</div>

				</div>
			</div>
		</c:forEach>
	</div>

<jsp:include page="footer.jsp"></jsp:include>
	



</body>
</html>