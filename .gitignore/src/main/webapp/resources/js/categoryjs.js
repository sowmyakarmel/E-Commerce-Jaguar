$(document).ready(function(){
	
  $("#categorytable").DataTable({
	
	  "ajax": {
		    "url": "http://localhost:8080/carwebapp/categories/all",
		    "dataSrc": ""
		  },
	  "columns": [
		
		  { "data": "categoryName" },
		  {"data":"categoryId"},
          {"data":null,
        	  "render":function(data,type,row){
        		  return "<a href='http://localhost:8080/carwebapp/"+row.categoryId+"/editcategory' class='btn btn-primary'>Edit</a>";
        	  }
          },
          
          {"data":null,
        	  "render":function(data,type,row){
        		  return "<a href='http://localhost:8080/carwebapp/"+row.categoryId+"/deletecategory' class='btn btn-primary'>Delete</a>";
        	  }
          }
                
      ]
  });
    
    
});