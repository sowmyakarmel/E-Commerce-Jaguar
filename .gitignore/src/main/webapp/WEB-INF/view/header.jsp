<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<!DOCTYPE html>
<html lang="en">
<head>
<c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<title>Jaguar</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/resources/js" var="js" />
<spring:url value="/resources/jquery" var="jq" />
<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/images" var="images" />

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${jq}/jquery.dataTables.js"></script>
<link href="${css}/dataTables.bootstrap.css">

<link rel="stylesheet" href="styles.css">
</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">

				<a class="navbar-brand" href="index.jsp" style="padding: 0px;">
					<img src="resources/images/logo2.png" style="height: 100%;">
				</a> </a>
			</div>

			<ul class="nav navbar-nav">
				<li class="active"><a href="hom">Home</a></li>
				<li><a href="cont">ContactUs</a></li>
				<li><a href="abt">AboutUs</a></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="products">Product <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:forEach items="${catlist}" var="cat">
							<a href="${contextPath}/categoryProducts/${cat.categoryId}"> <li>${cat.categoryName}</li>
							</a>
						</c:forEach>
					</ul></li>

	<ul class="nav navbar-nav navbar-right">
    <security:authorize access="isAuthenticated()">
    <li><a href="${contextPath}/customer/viewcart"><span>${cartcount}</span>View Cart</a></li>
    <li><a href="${contextPath}/admin/logout"><span class="glyphicon glyphicon-user"></span> Logout</a></li>
    </security:authorize>
   <security:authorize access="isAnonymous()">
      <li><a href="${contextPath }/reg"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="${contextPath }/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </security:authorize>
      
    </ul>
  </div>
</nav>