<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center">Edit Books</h1>
	<div class = "col-10 text-right">
	<a href="adminpage" class = "btn btn-primary">home</a>
	</div>
	<hr />
	<c:if test="${requestScope.msg ne null }">
	<div class = "alert  alert-danger">${requestScope.msg }</div>
	</c:if>
	<!-- taglib for server side coding tags -->
	<div class="search-container">
    

<form action="update" method = "post">
		<table class = "table table-primary table-stripped table-hover mx-auto col-10">
  <tbody>
	<tr>
	<th class = "bg-danger text-white">Book Id </th>
	<td><input type = "number" name = "book_id" value = "${requestScope.book.book_id}" ></td>
	</tr>
	<tr>
	<th class = "bg-danger text-white">Book Title  </th>
	<td><input type = "text" name="book_title" value =  "${requestScope.book.book_title}"></td>
	</tr>
	<tr>
	<th class = "bg-danger text-white">Book Author </th>
	<td><input type = "text" name="book_author" value =  "${requestScope.book.book_author}"></td>
	</tr>
	<tr>
	<th class = "bg-danger text-white">Book Publisher </th>
	<td><input type = "text" name="book_publisher" value =  "${requestScope.book.book_publisher}"></td>
	</tr>
	<tr>
	<th class = "bg-danger text-white">Book Genre </th>
	<td><input type = "text"  name="book_genre"  value =  "${requestScope.book.book_genre}"></td>
	</tr>
	<tr>
	<th class = "bg-danger text-white">Book Price </th>
	<td><input type = "number" name="book_price" value =  "${requestScope.book.book_price}"></td>
	</tr>
	<tr>
	<th class = "bg-danger text-white">Book Qty </th>
	<td><input type = "number" name="book_qty" value =  "${requestScope.book.book_qty}"></td>
	</tr>
	<tr>
	<th class = "bg-danger text-white">Book Availability </th>
	<td><input type = "text" value = "${requestScope.book.book_isAvail}"></td>
	</tr>
	 <tr>
      <td colspan="2"><input type="submit" style="margin-left: 50%" value="Update Value"></td>
    </tr>
	</tbody>
	</table>
	</form> 
	</div>
</body>
</html>