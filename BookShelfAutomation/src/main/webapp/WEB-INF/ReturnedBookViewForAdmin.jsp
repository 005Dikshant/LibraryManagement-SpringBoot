<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
   
<html lang="en">
<head>
  <title>Admin Book View</title>
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
* {box-sizing: border-box;}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #e9e9e9;
}


.topnav .search-container {
  float: right;
}

.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}

.topnav .search-container button, .btn {
  float: right;
  padding: 6px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.topnav .search-container button:hover {
  background: #ccc;
}

@media screen and (max-width: 600px) {
  .topnav .search-container {
    float: none;
  }
   .topnav input[type=text], .topnav .search-container button,.btn {
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }
  .topnav input[type=text] {
    border: 1px solid #ccc;  
  }
}
</style>

</head>
<body style="height:100%">

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid" >
    <div class="navbar-header">
      <a class="navbar-brand" class="active text-center" style="font-size:39px">Book Shelf</a>
    </div>
    <ul class="nav navbar-nav" style="font-size:15px">
    <li><a href = "adminpage">Home</a></li>
      <li><a href = "adminmemberhome" >View Member</a></li>
	  <li><a href = "issuebookadmin" >Issued Books</a></li>
	  <li><a href = "returned" >Returned Book</a></li>
	  <li><a href="signout">LogOut</a></li>
    </ul>
  </div>
</nav>
 <br/>

	<hr/>
	<c:if test="${requestScope.msg ne null}" >
		<div class = "alert alert-danger">${requestScope.msg}</div>
	</c:if>
	<br/>
	

	
	<div class="container" style="margin-top:100px"  >
		<h1 class = "text-center">Returned Book</h1>
	
	 <table class="table table-primary table-striped table-hover mx-auto col-5">
         <thead class="thead-dark">
         <tr class = "bg-danger text-white">
       		  <th>Entry</th>
       		  <th>Member Id</th>
       		 <th>Book Id</th>
                         
             <th>Book Condition</th>           
             <th>Issue Date</th> 
             <th>Options</th>             
     	 </tr>
   		 </thead>

	<c:forEach items="${requestScope.bclist}" var="bc">
    <tbody>
      <tr>
           <td>${bc.sub_book_id}</td>
			<td>${bc.member_id.id}</td>
			<td>${bc.books_id.book_id}</td>
			<td>${bc.item_condition}</td>
			<td>${bc.issueDate}</td>
			<td>
	 		 	  
	 		 	  <a class="btn btn-primary" href="deletesR?id=${bc.sub_book_id}"role="button">Delete</a>
	 		 </td>
	 </tr>
      </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>