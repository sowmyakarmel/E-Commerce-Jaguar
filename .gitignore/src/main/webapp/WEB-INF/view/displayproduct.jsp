<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid">

<c:if test="${newproduct==true}">
<div class="row">
<div class="col-sm-3"></div>
<div class="col-sm-6">
<form:form class="form" action="addproduct" method="post" modelAttribute="product"
commandName="product" enctype="multipart/form-data">
<div class="form-group">
<label for="categoryname">Category</label>
<form:select path="category" name="category" class="form-control" id="categoryitem" >
<form:options items="${categorieslist}"/>
</form:select>
</div>
<div class="form-group">
<label for="categoryName">Product Name</label>
<form:input path="productName" class="form-control" />
<form:errors path="productName"></form:errors>
</div>
<div class="form-group">
<label for="productPrice">Product Price</label>
<form:input path="productPrice" class="form-control" />
<form:errors path="productPrice"></form:errors>
</div>
<div class="form-group">
<label for="quantity">Product Quantity</label>
<form:input path="quantity" class="form-control" />
<form:errors path="quantity"></form:errors>
</div>
<div class="form-group">
<label class="radio-inline"><form:radiobutton
path="status" name="optradio" value="true" />Available</label> <label
class="radio-inline"><form:radiobutton name="optradio"
path="status" value="false" />Out of Stock</label>
</div>
<div class="form-group">
<label for="prodcutDescription">Product Description</label>
<form:textarea path="productDescription" class="form-control" />
<form:errors path="productDescription"></form:errors>
</div>
<div class="form-group">
<label for="image">Image Upload</label>
<form:input path="image" type="file" />
</div>

<input type="submit" value="Add Product" id="adding" class="btn btn-primary">

</form:form>


</div>

<div class="col-sm-3"></div>


</div>
</c:if>
<c:if test="${editproduct==true }">
<div class="row">
<div class="col-sm-3"></div>
<div class="col-sm-6">
<form:form class="form" action="updateproduct" method="post" modelAttribute="product"
commandName="product">

<div class="form-group">
<label for="categoryName">Product Name</label>
<form:input path="productName" class="form-control" />
<form:hidden path="productId"/>
<form:errors path="productName"></form:errors>
</div>
<div class="form-group">
<label for="productPrice">Product Price</label>
<form:input path="productPrice" class="form-control" />
<form:errors path="productPrice"></form:errors>
</div>
<div class="form-group">
<label class="radio-inline"><form:radiobutton
path="status" name="optradio" value="true" />Available</label> <label
class="radio-inline"><form:radiobutton name="optradio"
path="status" value="false" />Out of Stock</label>
</div>
<div class="form-group">
<label for="quantity">Product Quantity</label>
<form:input path="quantity" class="form-control" />
<form:errors path="quantity"></form:errors>
</div>
<div class="form-group">
<label for="ProdcutDescription">Product Description</label>
<form:textarea path="productDescription" class="form-control" />
<form:errors path="productDescription"></form:errors>
</div>

<input type="submit" value="Update Product" class="btn btn-primary">

</form:form>

</div>

<div class="col-sm-3"></div>


</div>
</c:if>
</div>

