<%@include file="AdminHeader.jsp"%>


 I am in Admin Product Page
 
 
 <div class="container-fluid">
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-10">

<a href="newproduct" class='btn btn-primary'>Add New Product</a>

</div>
<div class="col-sm-1"></div>
</div>
</div>
<br>

<script type="text/javascript" src="${js}/productjs.js"></script>

<div class="container-fluid">
<div class="row">
<div class="col-sm-1"></div>
<div class="col-sm-10">
<table class="table table-hover" id="productstable">
<thead>
<tr>
<th>Product Name</th>
<th>Product Price </th>
<th>Quantity</th>
<th></th>
<th></th>
<th></th>
</tr>
</thead>
</table>
</div>
</div>
</div>