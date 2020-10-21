<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!DOCTYPE html>
<html lang="en">
<head>
  <title>Return Book Form</title>
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
	  <li><a href = "displayissuebook">Issue Book</a></li>
	  <li><a href = "issuebookview">View Issued Books</a></li>
	  <li><a href = "displaybookform">View Book</a></li>
	  <li><a href = "displayprofile">View Profile</a></li>
	  <!-- <li><a href = "displayreturnbook" class="active">Return Book</a><br></li>
	  <li><a href = "displaywishlistform">Add Into Wish list</a></li> -->
	  <li><a href = "displaywishlist">Show Wish list</a></li>
	  <li><a href="signout">LogOut</a></li>
    </ul>
  </div>
</nav>

	  
<div class="container" style="margin-top:100px"  style="height:40%">
<div class = "alert alert-success">${requestScope.username}</div>
	<form action = "returnbook" method = "post">
	
	<div class = "form-row">
               <div class = "form-group col-md-6">
                  <h4><label for = "inputBId">Book Id</label></h4>
                  <input type = "text" name = "txtbid"  required class =" form-control" 
                      placeholder = "Book Id"/>
               </div>
               
               <div class = "form-group col-md-6">
                 <h4> <label for = "inputMId">Member Id</label></h4>
                  <input type = "text" name = "txtmid" required   class =" form-control" 
                      placeholder = "Book Id"/>
               </div>
		     <div class = "form-group col-md-6">
			<button type = "submit" class = "btn btn-primary" >Return Book</button>
			</div>	</div>
	
	</form>
	</div>
</body>
</html>

			