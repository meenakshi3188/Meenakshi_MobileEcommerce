<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="org.springframework.web.context.request.RequestScope,com.niit.mobilestoreapps.model.*"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<jsp:include page="header.jsp"></jsp:include>
<br><br><br>
  <c:if test="${empty cartForm or empty cartForm.cartLines}">
        <h2>There is no items in Cart</h2>
        <a href="${pageContext.request.contextPath}">Show
            Product List</a>
    </c:if>
	 
    <c:if test="${not empty cartForm and not empty cartForm.cartLines   }">
        <form:form method="POST" modelAttribute="cartForm"
            action="${pageContext.request.contextPath}/viewCart">
 
 			<table class="table table-striped table-bordered" style="width: 80%; vertical-align: middle; margin-left: 10%;">
 				<tr>
 					<td colspan="7" style="font-size: 18px; font-weight: bold;">
 						My Cart
 					</td>
 				</tr>
			  	<tr style="vertical-align: middle;">
			  		<td>Image</td>
			  		<td>Product Code</td>
			  		<td>Product Name</td>
			  		<td>Price</td>
			  		<td>Quantity</td>
			  		<td>Sub Total</td>
			  		<td>Operation</td>
			  	</tr>
 
            <c:forEach items="${cartForm.cartLines}" var="cartLineInfo" varStatus="varStatus">
            	<tr>
					<td>        
                        <img class="product-image" height="60px" width="50px"
                            src="${cartLineInfo.productInfo.imgname}" />
                    </td>
                    <td>${cartLineInfo.productInfo.code} <form:hidden path="cartLines[${varStatus.index}].productInfo.code" /></td>
 					<td>${cartLineInfo.productInfo.name}</td>
 					<td><fmt:formatNumber value="${cartLineInfo.productInfo.price}" type="number"/></td>
 					<td>
 						<form:input path="cartLines[${varStatus.index}].quantity" />
 						<input type="submit" value="Modify"  class="btn btn-info"/>
 					</td>
 					<td><fmt:formatNumber value="${cartLineInfo.amount}" type="number"/></td>
                    <td>
                    	<a href="${pageContext.request.contextPath}/shoppingCartRemoveProduct?code=${cartLineInfo.productInfo.code}" 
                    	   class="btn btn-info" role="button">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
            	<td colspan="7">
		            <a href="${pageContext.request.contextPath}/shoppingCartCustomer" class="btn btn-primary" role="button">Enter
        		        Customer Info</a>
            		<a href="${pageContext.request.contextPath}" class="btn btn-primary" role="button">Continue Buy</a>
            	</td>
            </tr>
            </table>
            <div style="clear: both"></div>
        </form:form>
    </c:if> 
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>