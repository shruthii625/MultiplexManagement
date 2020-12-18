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
		

<div class="container ">
			<div class="row">
			<div class="col-3"></div>
			<div class="col-6">
		<form action="editshowtotab.do">
								<br>
							<h1>Edit show details</h1>
				<div class="form-group">
				
						<label for="movie" >Movie: </label>
						<select id="movieshow" name="movieshow" class="form-control" >
						<c:forEach items="${movielist}" var="movie" >
						<c:choose>
						<c:when test="${movie.movieID==Editthis.mid}">
						<option value="${movie.movieID}" selected>${movie.movieName}</option>
						</c:when>
						<c:otherwise>
						<option value="${movie.movieID}" >${movie.movieName}</option>
						</c:otherwise>
						</c:choose>
						</c:forEach>
						</select>
						
						</div>
						
						<div class="form-group">
						<label for="stime" >Start time: </label>
						<input type="time" name="stime" class="form-control" value="${Editthis.starttime}">
						</div>
						
						<div class="form-group">
						<label for="etime" >End time: </label>
						<input type="time" name="etime" class="form-control" value="${Editthis.endtime}">
						</div>
						
						<div class="form-group">
						<label for="hall" >Hall: </label>
						<select id="hallshow" name="hallshow" value="${Editthis.hid}" class="form-control">
						<c:forEach items="${halllist}" var="hall">
						<c:choose>
						<c:when test="${ hall.hallId==Editthis.hid}">
						<option value="${hall.hallId}" selected>${hall.hallName}</option>
						</c:when>
						<c:otherwise>
						<option value="${hall.hallId}" >${hall.hallName}</option>
						</c:otherwise>
						</c:choose>
						</c:forEach>
						</select>
						</div>
						<div class="form-group">
						<label for="date" >Date of show: </label>
						<input type="date" name="sdate" class="form-control" value="${Editthis.date}">
						</div>
						<input type="text" name="sidd" value="${Editthis.showId}">
						<div class="form-group">
						<div class="row">
						<div class="col">
						<input type="submit" class="form-control btn btn-primary" value="Save">
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


</body>
</body>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
</html>