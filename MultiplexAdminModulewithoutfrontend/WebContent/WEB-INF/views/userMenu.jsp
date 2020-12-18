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
<div class="container ">
			<div class="row">
			<div class="col-1"></div>
			<div class="col-10">

	<table class="table">
    <thead>
      <tr>
        <th>Movie</th>
		<th>Summary</th>
		<th>Genre</th>
		<th>Click to book!</th>
		
	
      </tr>
    </thead>
       <tbody>
     
	<c:forEach items="${movielist}" var="movie">
	
		<tr>
			<td>${movie.movieName}</td>			
			<td>${movie.movieDetails }</td>
			<td>${movie.movieGenre }</td>
			
			
			
			<td><a href="bookmov.doo?mid=${movie.movieID }">x</a></td>
			</tr>
		
	</c:forEach>

	
		
	</tbody>
	</table>
	
	</div>
	</div>
	</div>
	
</body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
</html>