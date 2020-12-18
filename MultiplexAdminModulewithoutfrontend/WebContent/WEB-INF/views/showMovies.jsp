<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*,java.io.*"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Show Movies</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>
  <meta name="viewport" content="width=device-width, initial-scale=1">
 </head>
<body>
<% if(session.getAttribute("validadmin").equals("yes")){ %>
<header>
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
<c:when test="${movielist.isEmpty()}">
	
	
	<c:choose>
		<c:when test = "${addistrue.equals(\"yes\")}">
		<div class="container ">
			<div class="row">
			<div class="col-1"></div>
			<div class="col-10">
		<form action="addmovtotab.do">
			<table class="table" >
    			<thead>
      				<tr>
        				<th>Movie</th>
        				
						<th>Description</th>
						
						<th>Genre</th>
						
		
      				</tr>
   				 </thead>
		<tr>
		<td><input type="text" name="addname"></td>
		<td><input type="text" name="adddesc"></td>
		<td><input type="text" name="addgen"></td>
		<td><input type="submit" value="add" onclick="submitForm('addmovtotab.do')"/></td>
		</tr>
		</table>
		</form>
		</div>
		</div>
		</div>
		</c:when>
		<c:otherwise>
		<h1>NO MOVIES TO SHOW!</h1>
		<div>
	
	<a href="addmov.do">Add</a>
	</div>
		</c:otherwise>
		</c:choose>
	
</c:when>
<c:otherwise>
<div class="container ">
			<div class="row">
			<div class="col-1"></div>
			<div class="col-10">

	<table class="table">
    <thead>
      <tr>
        <th>Movie</th>
		<th>Description</th>
		<th>Genre</th>
		<th>Edit</th>
		<th>Delete</th>
	
      </tr>
    </thead>
       <tbody>
     
	<c:forEach items="${movielist}" var="movie">
	
		<tr>
			<td>${movie.movieName}</td>			
			<td>${movie.movieDetails }</td>
			<td>${movie.movieGenre }</td>
			<input type="hidden" value="${movie.movieID }" name="mid">
			 
			<td><a href="editmovie.do?movietobeedited=${movie.movieID}" >edit</a></td>
		
			<td><a href="delmovie.do?movietobedel=${movie.movieID}" >Del</a></td>
			
			
			</tr>
		
	</c:forEach>

	
		
	</tbody>
	</table>
	
	
	<c:choose>
	<c:when test = "${addistrue.equals(\"yes\")}">
		<form action="addmovtotab.do" >
		<tr>
		<td><input type="text" name="addname"></td>
		<td><input type="text" name="adddesc" placeholder="Enter description"></td>
		<td><input type="text" name="addgen"></td>
		<td><input type="submit" value="add" class="btn btn-sm btn-primary" ></td>
		<td><a href="listmov.do" class="btn btn-sm btn-primary" >cancel</a></td>
		
		</tr>
		</form>
		</c:when>
	<c:otherwise>
		<div>
	
	<a href="addmov.do">Add</a>
	</div>
		</c:otherwise>
		</c:choose>
	</div>
	</div>
	</div>
	</c:otherwise>
	</c:choose>
	
	<%}
else{
	RequestDispatcher dispatcher 
    = this.getServletContext().getRequestDispatcher("/WEB-INF/views/signIn.jsp");
}
%>
</body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>

</html>