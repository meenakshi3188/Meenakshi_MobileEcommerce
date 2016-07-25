<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<br><br>
	<div class="span9 center margin-bottom">
		<h3>Product Details</h3>
	</div>
	<div class="container">
		<div class="row">
			<div class="span3">
				<img src="${ProductDetail.product_image}" alt="image" />
			</div>
			<div class="span5">
				<div class="spanAddress">
					<address>
						<strong>Name:</strong> <span>${ProductDetail.product_name}</span><br>
						<strong>Model:</strong> <span>${ProductDetail.product_model}</span><br>
						<strong>Description 1:</strong> <span>${ProductDetail.product_description1}</span><br>
						<strong>Description 2:</strong> <span>${ProductDetail.product_description2}</span><br>
					</address>
				</div>
				<div class="span6">
					<h2>
						<strong>Price: Rs. ${ProductDetail.product_price}</strong> <br>
						<br>
					</h2>
					<a href="cart?id=${ProductDetail.product_id}">Add To Cart</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>