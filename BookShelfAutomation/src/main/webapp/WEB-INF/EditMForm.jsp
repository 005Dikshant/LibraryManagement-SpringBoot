<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Member Form</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center">Edit Member</h1>
	<div class = "col-10 text-right">
	<a href="adminpage" class = "btn btn-primary">home</a>
	</div>
	<hr />
	<c:if test="${requestScope.msg ne null }">
	<div class = "alert  alert-danger">${requestScope.msg }</div>
	</c:if>
	<!-- taglib for server side coding tags -->
	<div class="search-container">
    

<form action="updating" method = "post">
		<table class = "table table-primary table-stripped table-hover mx-auto col-10">
  <tbody>
	<tr>
	<th class = "bg-danger text-white">Member Id </th>
	<td><input type = "number" name = "id" value = "${requestScope.Member.id}" ></td>
	</tr>
	<tr>
	<th class = "bg-danger text-white">Password  </th>
	<td><input type = "text" name="pass" value =  "${requestScope.Member.pass}"></td>
	</tr>
	<tr>
	<th class = "bg-danger text-white">DOB</th>
	<td><input type = "date" name="dob" value =  "${requestScope.Member.dob}"></td>
	</tr>
	<tr>
	<th class = "bg-danger text-white">Address </th>
	<td><input type = "text" name="address" value =  "${requestScope.Member.address}"></td>
	</tr>
	<tr>
	<th class = "bg-danger text-white">Fine</th>
	<td><input type = "text"  name="fine"  value =  "${requestScope.Member.fine}"></td>
	</tr>
	<tr>
	<th class = "bg-danger text-white">Email</th>
	<td><input type = "text" name="email" value =  "${requestScope.Member.email}"></td>
	</tr>
	<tr>
	<th class = "bg-danger text-white">Suspended </th>
	<td><input type = "number" name="suspended" value =  "${requestScope.Member.suspended}"></td>
	</tr>
	
	 <tr>
      <td colspan="2"><input type="submit" style="margin-left: 50%" value="Update Member"></td>
    </tr>
	</tbody>
	</table>
	</form> 
	</div>
</body>
</html>