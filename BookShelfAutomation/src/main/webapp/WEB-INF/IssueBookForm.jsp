<!DOCTYPE html>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>
  <title>Issue Book</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" integrity="sha256-MfvZlkHCEqatNoGiOXveE8FIwMzZg4W85qfrfIFBfYc= sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
<style>

.active {
  background-color: #666;
  color: white;
}
</style>
</head>
<body style="height:100%">

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid" >
    <div class="navbar-header">
      <a class="navbar-brand" class="active" style="font-size:29px">Book Shelf</a>
    </div>
    <ul class="nav navbar-nav" style="font-size:15px">
    <li><a href = "homi">Home</a></li>
      <li><a href = "displaysearchbook" >Search Book</a></li>
	  <li><a href = "displayissuebook" class="active">Issue Book</a></li>
	  <li><a href = "issuebookview" >View Issued Books</a></li>
	  <li><a href = "displaybookform">View Book</a></li>
	  <li><a href = "displayprofile">View Profile</a></li>
	  
	  
	  <li><a href = "displaywishlist">Show Wish list</a></li>
	  <li><a href="signout">LogOut</a></li>
    </ul>
  </div>
</nav>

	
     
<div class="container" style="margin-top:100px" >
	<div class = "alert alert-success">${requestScope.username}</div>
         <form action = "issuebook" method = "post">
     
     <c:if test="${requestScope.msg ne null }">
	<div class = "alert  alert-danger">${requestScope.msg}</div>
	</c:if>
	    
     <c:if test="${requestScope.error ne null }">
	<div class = "alert  alert-danger">${requestScope.error}</div>
	</c:if>
	
            
             <div class = "form-row">
               <div class = "form-group col-md-6">
                  <h4><label for = "inputRecord">Entry Record</label></h4>
                  <input type = "text" name = "txtid"  required class =" form-control" 
                      placeholder = "Entry Record" />
               </div>
               
               <div class = "form-group col-md-6">
                 <h4> <label for = "inputBId">Book Id</label></h4>
                  <input type = "text" name = "txtbid" required class = "form-control" 
                    placeholder = "Book Id"   required value ="${requestScope.bid}"/>
               </div>
               
               <div class = "form-group col-md-6">
                 <h4><label for = "inputMId">Member Id</label></h4> 
                 <input type = "text" name = "txtmid" required class = "form-control" 
                    placeholder = "Member Id"  required value ="${requestScope.mid}" />
               </div>
            
            
           <div class = "form-group col-md-6">
              <h4> <label for = "inputDate">Date</label></h4>
               <input type = "date" name = "txtdate"  required class = "form-control" 
                  placeholder = "Date"  required value ="${requestScope.date}">
            </div>
          
               <div class = "form-group col-md-6">
                <h4>  <label for = "inputCndition">Book Condition</label></h4>
                  <input type = "text" name = "txtcond" class = "form-control"  placeholder = "Book Condition" />
               </div> 
           
            <div class = "form-group col-md-6" style="margin-top:26px">
            <button type = "submit" class = "btn btn-primary" >Issue Book</button>
            </div>
             </div>
         </form>
      </div>
      
      <!-- jQuery first, then Popper.js, then Bootstrap JS -->
      <script src = "https://code.jquery.com/jquery-3.3.1.slim.min.js" 
         integrity = "sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" 
         crossorigin = "anonymous">
      </script>
      
      <script src = "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" 
         integrity = "sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" 
         crossorigin = "anonymous">
      </script>
      
      <script src = "https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" 
         integrity = "sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" 
         crossorigin = "anonymous">
      </script>
      
   </body>
</html>