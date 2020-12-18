<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>
<title>Insert title here</title>
</head>
<body>
<header class="jumbotron" >
				<h1>BookMyShow</h1>
				<p>Login to see if your favourite movie is playing!!<br />
				</p>
			</header>
<div class="container">

<form action="sendmail.do">
<div class="row">
<div class="col-4">



</div>
<div class="col-4">
<c:if test="${ invalidmail.equals(\"yes\")}">
<p style="color: #ff2361;">No such mail id has been registered!!</p>
</c:if>

<label for="email">Enter your email to reset password:</label>
	<input type="email" class="form-control" name="mailsend">
	</div>

</div>
	<br>
<div class="row">
<div class="col offset-4">
	<input type="submit" value="Reset">
	</div>
	</div>
</form>

</div>
</body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
	
</html>