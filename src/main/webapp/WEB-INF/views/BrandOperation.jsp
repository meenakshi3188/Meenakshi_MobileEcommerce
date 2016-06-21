<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script>

      var myApp = angular.module('myApp', []);
	  myApp.controller('MyController', function ($scope,$http){
        $http.get('BrandOpt').success(function(data) {
        $scope.brands = data;

        });

      });
    </script>
</head>

	<!-- Using AngularJS -->
<body ng-app="myApp">

	<div ng-controller="MyController">
	
	<table>
			<tr>
				<th>Brand Id</th> 
				<th>Brand Name</th> 	
			</tr>
			<tr ng-repeat="brnd in brands">
				<td>{{brnd.brand_id}}</td> 
				<td>{{brnd.brand_name}}</td> 
				
			</tr>
		</table>
		</div>
		
</body>

	<!-- Using Spring Form -->
	<!--<form:form action="BrandOpt">
		<table>
			<tr>
				<th>Brand Id</th>
				<th>Brand Name</th>
			</tr>
			<c:forEach items="${brands}" var="brnds1">
				<tr>
					<td>${brnds1.brand_id}</td>
					<td>${brnds1.brand_name}</td>
					
				</tr>
			
				</c:forEach>
				</table>
				</form:form>-->

</html>