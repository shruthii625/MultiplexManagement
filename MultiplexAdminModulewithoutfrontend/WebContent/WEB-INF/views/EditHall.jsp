<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		
<div class="container">
<div class="row">
<div class="col-3"></div>
<div class="col-6">
<form action="edithalltodb.do">
	<h1>Edit hall details</h1>
	<div class="form-group">
	<label for="edithname" >Hall name: </label>
	<input type="text" value="${Editthis.hallName}" name="edithname" class="form-control">
	</div>
	<div class="form-group">
	<label for="editsnum" >Standard Seats: </label>
	<input type="text" class="form-control" value="${Editthis.standardNum}" name="editsnum">
	</div>
	<div class="form-group">
	<label for="editgnum" >Gold Seats: </label>
	<input type="text" class="form-control" value="${Editthis.goldNum}" name="editgnum">
	</div>
	<div class="form-group">
	<label for="editpnum" >Premium Seats: </label>
	<input type="text" class="form-control" value="${Editthis.premiumNum}" name="editpnum">
	</div>
	
	<input type="hidden" value="${Editthis.hallId}" name="editid">
	<div class="form-group">
						<div class="row">
						<div class="col">
						<input type="submit" class="form-control btn btn-primary" value="Save">
						</div>
						<div class="col">
						<a href="justlisthall.do" class="form-control btn btn-primary">Cancel</a>
						</div>
						</div>
						</div>

</form>
</div>
</div>
</div>
</body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
</html>