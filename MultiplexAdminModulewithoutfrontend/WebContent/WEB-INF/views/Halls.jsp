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
	<c:when test="${halllist.isEmpty()}">
		<c:choose>
			<c:when test = "${addistrue.equals(\"yes\")}">
			<div class="container">
			<div class="row">
			<div class="col-1"></div>
			<div class="col-10">
			<br>
			<h1>Add a new hall</h1>
				<form action = "addhalltotab.do">
				<table>
					<tr>
						<th>Name</th>
						<th>Standard Seats</th>
						<th>Gold Seats</th>
						<th>Premium Seats</th>
					</tr>	
					<tr>
						<td><input type="text" name="addname" ></td>
						<td><input type="number" name="addstan" value="0"></td>
						<td><input type="text" name="addgold" value="0"></td>
						<td><input type="text" name="addprem" value="0"></td>
						<td><input type="submit" value="add" class="btn btn-sm btn-primary" ></td>
						<td><a href="justlisthall.do" class="btn btn-sm btn-primary" >cancel</a></td>
					</tr>
				</table>
				</form>
				</div>
				</div>
				</div>
		</c:when>
		<c:otherwise>
		<div class="container">
		<div class="row">
		<div class="col-3"></div>
		<div class="col-6">
		<br>
		<h1>NO HALLS TO SHOW!</h1>
		<a href="addhall.do">Add a new hall</a>
		</div>
		</div>
		</div>
		</c:otherwise>
		</c:choose>
		</c:when>
		
		<c:otherwise>
		<div class="container">
		<div class="row">
		<div class="col-1"></div>
		<div class="col-10">
		
		<table class="table">
		<thead>
			<tr>
			<th>Name</th>
			<th>Standard Seats</th>
			<th>Gold Seats</th>
			<th>Premium Seats</th>
			<th>Edit</th>
			<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${halllist}" var="onehall">
	
		<tr>
			<td>${onehall.hallName}</td>
			<td>${onehall.standardNum }</td>
			<td>${onehall.goldNum}</td>
			<td>${onehall.premiumNum}</td> 
			<td><a href="edithall.do?halltobeedited=${onehall.hallId}" >Edit</a></td>

			<td><a href="delhall.do?halltobedel=${onehall.hallId}" >Delete</a></td>
			
				<input type="hidden" value="${onehall.hallId}" name="mid">
			</tr>
			</c:forEach>
			
		

		</tbody>
		</table>
		
		<c:choose>
		
			<c:when test = "${addistrue.equals(\"yes\")}">
			<form action = "addhalltotab.do">
			<tr>
						<td><input type="text" name="addname" ></td>
						<td><input type="number" name="addstan" value="0"></td>
						<td><input type="text" name="addgold" value="0"></td>
						<td><input type="text" name="addprem" value="0"></td>
						<td><input type="submit" value="add" class="btn btn-sm btn-primary" ></td>
						<td><a href="justlisthall.do" class="btn btn-sm btn-primary" >cancel</a></td>
			</tr>
		</form>	
			</c:when>
			
			<c:otherwise>
			<a href="addhall.do">Add a new hall</a>
			</c:otherwise>
					
			
			</c:choose>
		</div>
		</div>
		</div>
	
		</c:otherwise>
</c:choose>


</body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
</html>