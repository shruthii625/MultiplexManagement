<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		<form action="bookfinal.doo">
		<input type="hidden" value="${showseatsobj.showId}" name="id">
		<div class="container">
		
		<div class="row">
		<div class="col-1"></div>
		<div class="col-10">
		<h1>AVAILABLE SEATS</h1>
		<table class="table">
		
		<thead>
		<tr>
			<th scope="col">Standard Seats(Rs. 200 per seat)</th>
			<th scope="col">Gold Seats(Rs. 300 per seat)</th>
			
			<th scope="col">Premium Seats(Rs. 400 per seat)</th>
			</tr>
			</thead>
		
			<tbody>
			
		<tr>
			<td>
				<select  id="sseat" class="form-control" name="sseat" value="0" >
						
						 <c:forEach var = "i" begin = "0" end = "${showseatsobj.sseats}">
        
						<option value="${i}">${i}</option>
						
						</c:forEach>
						</select>
			</td>
			<td><select  id="sseat" class="form-control" name="gseat" value="0" >
						
						 <c:forEach var = "i" begin = "0" end = "${showseatsobj.gseats}">
        
						<option value="${i}">${i}</option>
						
						</c:forEach>
						</select></td>
			<td><select  id="sseat" class="form-control" name="pseat" value="0">
						
						 <c:forEach var = "i" begin = "0" end = "${showseatsobj.pseats}">
        
						<option value="${i}">${i}</option>
						
						</c:forEach>
						</select></td>
			</tr>
			
			</tbody>
			</table>
			</div>
			</div>
			<div class="row">
			<div class="col"></div>
			<div class="form-group col">
						<input type="submit" class="form-control btn btn-primary" value="Book">
						
						
			</div>
			<div class="form-group col">
						
						<input type="submit" class="form-control btn btn-primary" value="Cancel">
						
			</div>
			<div class="col"></div>
			</div>
			
			</div>
			
			
			</form>
			
</body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>

</html>