<%@include file="AdminHeader.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid">

<c:if test="${newcategory==true}">
<div class="row">
<div class="col-sm-3"></div>
<div class="col-sm-6">
<form:form class="form" action="addcategory" method="post" commandName="category">
<div class="form-group">
<label for="categoryName">Category Name</label>
<form:input path="categoryName" class="form-control" />
<form:errors path="categoryName"></form:errors>
</div>
<input type="submit" value="Add Category" class="btn btn-primary">
</form:form>
</div>
<div class="col-sm-3"></div>


</div> 

</c:if>
<c:if test="${editcategory==true }"> 
<div class="row">
<div class="col-sm-3"></div>
<div class="col-sm-6">
<form:form class="form" action="updatecategory" method="post" commandName="category">
<%-- <form:input type="hidden" path="categoryId"/> --%>
<div class="form-group">
<label for="categoryName">Category Name</label>
<form:input path="categoryName" class="form-control" />
<form:errors path="categoryName"></form:errors>
</div>
<form:input type="hidden" path="categoryId"/>
<input type="submit" value="Update Category" class="btn btn-primary">
</form:form>
</div>
<div class="col-sm-3"></div>


</div>
</c:if>
</div>