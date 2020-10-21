<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
   
<html lang="en">
<head>
  <title>Issue Book View</title>
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
	  <li><a href = "issuebookview" class="active">View Issued Books</a></li>
	  <li><a href = "displaybookform" >View Book</a></li>
	  <li><a href = "displayprofile" >View Profile</a></li>
	  <!-- <li><a href = "displayreturnbook" >Return Book</a><br></li>
	  <li><a href = "displaywishlistform">Add Into Wish list</a></li> -->
	  <li><a href = "displaywishlist">Show Wish list</a></li>
	  <li><a href="signout">LogOut</a></li>
    </ul>
  </div>
</nav>


	<c:if test="${requestScope.msg ne null}" >
		<div class = "alert alert-danger">${requestScope.msg}</div>
	</c:if>
	
	<div class="container" style="margin-top:100px"  >
	<div class = "alert alert-success">${requestScope.username}</div>
		<h1 class = "text-center">Issue Book</h1>
	
	 <table class="table table-primary table-striped table-hover mx-auto col-5">
         <thead class="thead-dark">
         <tr class = "bg-danger text-white">
       		  <th>Entry</th>
       		 <th>Book Id</th>
             <th>Member Id</th>            
             <th>Book Condition</th>           
             <th>Issue Date</th> 
             <th>Option</th>
                           
     	 </tr>
   		 </thead>

	<c:forEach items="${requestScope.bclist}" var="bc">
    <tbody>
      <tr>
           <td>${bc.sub_book_id}</td>
           <td>${bc.books_id.book_id}</td>
			<td>${bc.member_id.id}</td>
			<td>${bc.item_condition}</td>
			<td>${bc.issueDate}</td>
			<td>
				  <a class="btn btn-primary" href="return?id=${bc.books_id.book_id}&&mid=${bc.member_id.id}&&date=${bc.issueDate}" role="button">Return</a>
				  
			</td>
			
      </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>