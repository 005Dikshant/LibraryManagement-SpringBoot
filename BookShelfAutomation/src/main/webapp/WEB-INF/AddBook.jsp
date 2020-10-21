<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center">Add Book</h1>
	<div class = "col-10 text-right">
	<a href="adminpage" class = "btn btn-primary">home</a>
	</div>
	<hr />
	
	<div class = " col-5 mx-auto alert alert-success">${requestScope.msg }</div>
	<form action="addbook" method = "post">
		<table class = "col-5 mx-auto table table-striped table-primary">
  <tbody>
    <tr>
      <th>Book Id</th>
      <!--value ="${requestScope.emodel.empId}" this is ki value register nhe huie
      toh bachi huie rehjaie  -->
      <td><input type="number" name="book_id" required value ="${requestScope.bmodel.book_id}" /></td>
    </tr>
    <tr>
      <th>Book Title</th>
      <td><input type="text" name="book_title" required value ="${requestScope.bmodel.book_title}" /></td>
    </tr>
    <tr>
      <th>Book Author</th>
      <td><input type="text" name="book_author" required value ="${requestScope.bmodel.book_author}" ></td>
    </tr>
    <tr>
      <th>Book Publisher</th>
      <td><input type="text" name="book_publisher" required value ="${requestScope.bmodel.book_publisher}"></td>
    </tr>
    <tr>
    <tr>
      <th>Book genre</th>
      <td><input type="text" name="book_genre" required value ="${requestScope.bmodel.book_genre}"></td>
    </tr>
    <tr>
      <th>Book Price</th>
      <td><input type="number" name="book_price" required value ="${requestScope.bmodel.book_price}"></td>
    </tr>
    <tr>
      <th>Book Qty</th>
      <td><input type="number" name="book_qty" required value ="${requestScope.bmodel.book_qty}"></td>
    </tr>
    <tr>
      <th>Book Available</th>
      <td><input type="number" placeholder="0/1" name="book_isAvail" required value ="${requestScope.bmodel.book_isAvail}"></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="Add Book"></td>
    </tr>
  </tbody>
</table>
	</form>
</body>
</html>