<%@ include file="header.jsp" %>



<div class="row">

<c:forEach items="${catpros}" var="catpro">

  <div class="col-md-4">
    <div class="thumbnail">
      <a href="/w3images/hc.jpg">
       <img src="http://localhost:8080/carwebapp/resources/images/${catpro.productName}.jpg" alt="Lights" style="width:98%"/>
        <div class="caption">
          <p style="float:left">${catpro.productName}</p><p style="float:right"><a href="http://localhost:8080/carwebapp/customer/${catpro.productId}/AddtoCart"><button class="btn btn-primary">Add Cart</button></a></p>
        </div>
      </a>
    </div>
  </div>
  </c:forEach>
  

</div>