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
      <a class="nav-item nav-link " href="listshows.do">Shows</a>
      <a class="nav-item nav-link" href="justlisthall.do">Halls</a>
      <a class="nav-item nav-link" href="listmov.do">Movies</a>
      
    </div>
     <div class="navbar-nav ml-auto">
    <a class="nav-item nav-link ml-auto" href="logout.do">Logout</a>
    </div>
    </div>
                  </nav>
		</header>
		
<c:choose>
	<c:when test="${showlist.isEmpty()}">
		<c:choose>
			<c:when test = "${addistrue.equals(\"yes\")}">
			
			<div class="container ">
			<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
				<form action = "addshowtotab.do">
							<br>
							<h1>Add a new show!</h1>
				<div class="form-group">
				
						<label for="movie" >Movie: </label>
						<select  id="movieshow" class="form-control" name="movieshow" >
						
						<c:forEach items="${movielist}" var="movie">
						<option value="${movie.movieID}">${movie.movieName}</option>
						
						</c:forEach>
						</select>
						
						</div>
						
						<div class="form-group">
						<label for="stime" >Start time: </label>
					<input type="time" name="stime" class="form-control">
						</div>
						<div class="form-group">
						<label for="stime" >End time: </label>
						<input type="time" name="etime" class="form-control">
						</div>
						<div class="form-group">
						<label for="hall" >Hall: </label>
						<select id="hallshow" name="hallshow" class="form-control" >
						<c:forEach items="${halllist}" var="hall">
						<option value="${hall.hallId}" >${hall.hallName}</option>
						
						</c:forEach>
						</select>
						</div>
						<div class="form-group">
						<label for="date" >Date of show: </label>
						<input type="date" name="sdate" class="form-control">
						
						</div>
						<div class="form-group">
						<input type="submit" class="form-control btn btn-primary" value="Create Show">
						<br>
						<a href class="form-control btn btn-primary" > Cancel</a>
						</div>
		</form>
		</div>
		</div>
		</div>
		</c:when>
	
		<c:otherwise>
		<div class="container">
		<div class="row">
		<div class="col-1"></div>
		<div class="col-10">
		<br>
		<h1>NO SHOWS HAVE BEEN SCHEDULED YET!</h1>
		<a href="addshow.do">Add a new show</a>
		</div>
		</div>
		</div>
		</c:otherwise>
		</c:choose>
		</c:when>
		<c:otherwise>
		
			
		<c:choose>
			<c:when test = "${addistrue.equals(\"yes\")}">
			<div class="container ">
			<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
		<form action="addshowtotab.do">
								<br>
							<h1>Add a new show!</h1>
				<div class="form-group">
				
						<label for="movie" >Movie: </label>
						<select  id="movieshow" class="form-control" name="movieshow" >
						
						<c:forEach items="${movielist}" var="movie">
						<option value="${movie.movieID}">${movie.movieName}</option>
						
						</c:forEach>
						</select>
						
						</div>
						
						<div class="form-group">
						<label for="stime" >Start time: </label>
					<input type="time" name="stime" class="form-control">
						</div>
						<div class="form-group">
						<label for="stime" >End time: </label>
						<input type="time" name="etime" class="form-control">
						</div>
						<div class="form-group">
						<label for="hall" >Hall: </label>
						<select id="hallshow" name="hallshow" class="form-control" >
						<c:forEach items="${halllist}" var="hall">
						<option value="${hall.hallId}" >${hall.hallName}</option>
						
						</c:forEach>
						</select>
						</div>
						<div class="form-group">
						<label for="date" >Date of show: </label>
						<input type="date" name="sdate" class="form-control">
						
						</div>
						<div class="form-group">
						<div class="row">
						<div class="col">
						<input type="submit" class="form-control btn btn-primary" value="Create Show">
						</div>
						<div class="col">
						<a href="listshows.do" class="form-control btn btn-primary">Cancel</a>
						</div>
						</div>
						</div>
		</form>
		</div>
		</div>
		</div>
		</c:when>
		
		<c:otherwise>
		<br>
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
			<th scope="col">Edit</th>
			<th scope="col">Delete</th>
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
			 
			<td><a href="editshow.do?showtobeedited=${sho.showId}" >Edit</a></td>
		
			<td><a href="delshow.do?showtobedel=${sho.showId}" >Delete</a></td>
			
			  
			</tr>
			</c:forEach>
			</tbody>
			</table>
			</div>
			
			</div>
			<div class="offset-1">
		<a href="addshow.do">Add a new show</a>
		</div>
			</div>
		
		
		</c:otherwise>
	</c:choose>
			
		</c:otherwise>
		</c:choose>
		</body>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
		</html>