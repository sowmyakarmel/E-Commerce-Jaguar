$(document).ready(function(){
	var path="http://localhost:8080/carwebapp/resources/images/";
  $("#productstable").DataTable({
	
	  "ajax": {
		    "url": "http://localhost:8080/carwebapp/adminproducts/all",
		    "dataSrc": ""
		  },
	  "columns": [
		
		  { "data": "productName" },
		  {"data":"",
          
        	  "render":function(data,type,row)
        	  {
        		  return "&#8360;."+row.productPrice+"";
        	  }
          },
          
          {"data":"quantity"},
          
          {data:"productName",
          mRender:function(data,type,row){
          return '<img src="'+path+data+'.jpg" width="25px" height="25px"></img>';
          }
          },
          {"data":"productId",
         "render":function(data,type,row){
          return "<a href='http://localhost:8080/carwebapp/"+row.productId+"/viewproduct' class='btn btn-primary'>view</a>";
         }
          },
          {"data":"",
          "render":function(data,type,row){
          return "<a href='http://localhost:8080/carwebapp/customer/"+row.productId+"/Addtocart' class='btn btn-primary'>AddCart</a>";
        			  
        		  }
        	  }
  ]
  });
});