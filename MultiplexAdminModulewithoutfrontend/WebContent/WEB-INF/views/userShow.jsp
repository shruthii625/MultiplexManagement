<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>
</head>
<body>
<header  >
				<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <div class="navbar-nav ">
    <a class="navbar-brand" href="#">BookMyShow</a>
    </div>
     <div class="navbar-nav ml-auto">
    <a class="nav-item nav-link ml-auto" href="logout.do">Logout</a>
    </div>
    </div>
                  </nav>
		</header>
<div class="container">
		<div class="row">
		<div class="col-1"></div>
		<div class="col-10">
		<table class="table">
		
		<thead>
		<tr>
			<th scope="col">Movie</th>
			<th scope="col">Start time</th>
			
			<th scope="col">End time</th>
			
			<th scope="col">Hall name</th>
			<th scope="col">Date</th>
			<th scope="col">Book</th>
		</tr>
			</thead>
			
			<tbody>
			<c:forEach items="${showlist}" var="sho">
	
		<tr>
			<td>${sho.mname}</td>
			
			<td>${sho.starttime}</td>
			
			
			<td>${sho.endtime}</td>
			
			<td>${sho.hname }</td>
			<td>${sho.date }</td>
			 
			<td><a href="selectedshow.doo?sel=${sho.showId}" >Book</a></td>
		
			  
			</tr>
			</c:forEach>
			</tbody>
			</table>
			</div>
			
			</div>
		
</body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
</html>