<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.niit.mobilestoreapps.model.*" %>
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
	<h1>Add Product</h1>
	<br>
	<form:form method="post" action="${pageContext.request.contextPath}/saveproduct" enctype="multipart/form-data" modelAttribute=""
		commandName="save_product">
		<table align="center">
			<tr>
				<td>Product Model</td>
				<td><input type="text" name="product_model" value="${productDetail.getProduct_model()}"/>
				<input type="hidden" name="product_id" value="${productDetail.getProduct_id()}"/>
				</td>
			</tr>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="product_name" value="${productDetail.getProduct_name()}"/></td>
			</tr>
			<tr>
				<td>Product Brand</td>
				<td><select name="brand_id">
						<c:forEach items="${brands}" var="id">
    					<option value="${id.brand_id}">${id.brand_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Product Description1</td>
				<td><textarea name="product_description1">${productDetail.getProduct_description1()}</textarea></td>
			</tr>
			<tr>
				<td>Product Description2</td>
				<td><textarea name="product_description2">${productDetail.getProduct_description2()}</textarea></td>
			</tr>
			<tr>
				<td>Product Price</td>
				<td><input type="text" name="product_price" value="${productDetail.getProduct_price()}"/></td>
			</tr>
			<tr>
				<td>Product Discount</td>
				<td><input type="text" name="product_discount" value="${productDetail.getProduct_discount()}"/></td>
			</tr>
			<tr>
				<td>Product Supplier</td>
				<td><select name="supp_id">
						<c:forEach items="${supplier}" var="id">
    					<option value="${id.supp_id}">${id.supp_name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Product Image</td>
				<td><input type="file" name="prod_file" /></td>
			</tr>
			<tr>
			<td>
				<c:if test="${!empty productDetail.getProduct_name()}">
						<input type="submit" value="Edit" />
					</c:if>
					<c:if test="${empty productDetail.getProduct_name()}">
						<input type="submit" value="Add"/>
					</c:if>
					</td>
			</tr>
		</table>

	</form:form>
<br>
<c:if test="${empty productDetail.getProduct_name()}">
<table class="table table-bordered" style="width: 66%;" align="center">
		<tr style="background-color: #BDC3C7;">
			<th>Product Id</th>
			<th>Product Model</th>
			<th>Product Name</th>
			<th>Product Brand</th>
			<th>Product Description1</th>
			<th>Product Description2</th>
			<th>Product Price</th>
			<th>Product Supplier</th>
			<th>Product Image</th>
			<th>Operation</th>
			<th>Operation</th>
		</tr>
		<c:forEach items="${ProductLists}" var="prd">
			<tr>
				<td>${prd.product_id}</td>
				<td>${prd.product_model}</td>
				<td>${prd.product_name}</td>
				<td>
					${prd.product_name}
				</td>
				<td>${prd.product_description1}</td>
				<td>${prd.product_description2}</td>
				<td>${prd.product_price}</td>
				<td>${prd.product_price}</td>
				<td><img src="${prd.product_image}"></td>
				<td><a href="<c:url value='/editProduct/${prd.product_id}' />">Edit</a></td>
				<td><a href="<c:url value='/delProduct/${prd.product_id}' />">Delete</a></td>
			</tr>
		</c:forEach>
	</table>	 
	</c:if>
</body>
</html>