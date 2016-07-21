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

<h2>Brand Wise Products</h2>
	<table class="table table-bordered" style="width: 66%;" align="center" >
		<tr style="background-color: #BDC3C7;">
			<th>Product Model</th>
			<th>Product Name</th>
			<th>Product Description1</th>
			<th>Product Description2</th>
			<th>Product Price</th>
			<th>Product Image</th>

		</tr>
		<c:forEach items="${prdLst}" var="prd">
			<tr>
				<td>${prd.product_model}</td>
				<td>${prd.product_name}</td>
				<td>${prd.product_description1}</td>
				<td>${prd.product_description2}</td>
				<td>${prd.product_price}</td>
				<td><img src="${prd.product_image}"></td>

			</tr>
		</c:forEach>
	</table>
</body>
</html>