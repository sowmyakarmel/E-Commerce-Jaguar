<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>CarWeb</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
   <%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <c:set var="contextPath" value="${pageContext.request.contextPath }"></c:set>
<spring:url value="/resources/js" var="js"/>
<spring:url value="/resources/jquery" var="jq"/>
<spring:url value="/resources/css" var="css"/>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/aja''5'+x/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="${jq}/jquery.dataTables.js"></script>
  <link href="${css}/dataTables.bootstrap.css" >
  
  
</head>
<body>


<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">CarJagur</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">AdminHome</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">AdminProduct <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="${contextPath}/adminprod">ManageProduct</a></li>
          
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">AdminCategory <span class="caret"></span></a>
        <ul class="dropdown-menu">
      <li><a href="${contextPath}/mgrcat">ManageCategory</a></li>
      </ul>
      </li>
      </ul>
    <ul class="nav navbar-nav navbar-right">

      <li><a href="${contextPath}/admin/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
    </ul>
  </div>
</nav>
  

