<!DOCTYPE html>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html lang="en">
<head>
  <title>Welcome</title>
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
  img{
  width: 100%;
  height: 400px;
  background-repeat: no-repeat;
  background-size: contain;
  border: 1px solid red;
}
  .social:hover {
     -webkit-transform: scale(1.1);
     -moz-transform: scale(1.1);
     -o-transform: scale(1.1);
 }
 .social {
     -webkit-transform: scale(0.8);
     /* Browser Variations: */
     
     -moz-transform: scale(0.8);
     -o-transform: scale(0.8);
     -webkit-transition-duration: 0.5s;
     -moz-transition-duration: 0.5s;
     -o-transition-duration: 0.5s;
 }

/*
    Multicoloured Hover Variations
*/
 
 #social-fb:hover {
     color: #3B5998;
 }
 #social-tw:hover {
     color: #4099FF;
 }
 #social-gp:hover {
     color: #d34836;
 }
 #social-em:hover {
     color: #f39c12;
 }



  </style>
</head>
<body style="height:100%">

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-fluid" >
    <div class="navbar-header">
      <a class="navbar-brand" class="active" style="font-size:28px">Book Shelf</a>
    </div>
    <ul class="nav navbar-nav" style="font-size:15px">
      <li><a href = "displaysearchbook">Search Book</a></li>
	  <li><a href = "displayissuebook">Issue Book</a></li>
	  <li><a href = "issuebookview">View Issued Books</a></li>
	  <li><a href = "displaybookform">View Book</a></li>
	  <li><a href = "displayprofile">View Profile</a></li>
	  <li><a href = "displayreturnbook">Return Book</a><br></li>
	  <!-- <li><a href = "displaywishlistform">Add Into Wish list</a></li> -->
	  <li><a href = "displaywishlist">Show Wish list</a></li>
	  <li><a href="signout">LogOut</a></li>
    </ul>
  </div>
</nav>
  
<div class="container" style="margin-top:100px"  style="height:40%">

  <div  class="font-italic" style="font-size:39px" >
      <p class="text-center">Welcome ${requestScope.username} to the Book Shelf Automation.</p>
      <p class="text-center">Enjoy the functionalities</p>
  </div>
  
  <c:if test="${requestScope.fine ne null }">
	<div class = "alert  alert-danger">${requestScope.fine }</div>
	</c:if>
     
     	
     	<img src="https://c4.wallpaperflare.com/wallpaper/839/50/541/library-cartoon-books-candles-wallpaper-preview.jpg"/>
     	 <div class="push"></div>
     </div>


<div class="container" >
 
    <hr>
        <div class="text-center center-block" >
            <p class="txt-railway">- BookShelf.com -</p>
            <br />
                <a href="https://www.facebook.com/bootsnipp"><i id="social-fb" class="fa fa-facebook-square fa-3x social"></i></a>
	            <a href="https://twitter.com/bootsnipp"><i id="social-tw" class="fa fa-twitter-square fa-3x social"></i></a>
	            <a href="https://plus.google.com/+Bootsnipp-page"><i id="social-gp" class="fa fa-google-plus-square fa-3x social"></i></a>
	            <a href="mailto:bootsnipp@gmail.com"><i id="social-em" class="fa fa-envelope-square fa-3x social"></i></a>
		</div>
    <hr>
</div>




</body>
</html>
