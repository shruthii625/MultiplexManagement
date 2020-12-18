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
<header class="jumbotron" >
				<h1>BookMyShow</h1>
				<p>Login to see if your favourite movie is playing!!<br />
				</p>
			</header>
			<div class="container">
<c:choose>
<c:when test="${wrongcode.equals(\"yes\")}">
<div class="container">
<form action="resendcode.do" >
<div class="row">
<div class="col-4"></div>
<div class="col-4">
<p style="color: #ff2361;">Uh-oh! 
That was not what we sent!</p>
</div>

</div>
<div class="row">

<div class="col-4">

</div>

<div class="col-4">
<br>
<input type="submit" value="Resend Code">
</div>

</div>

</form>
</div>

</c:when>

<c:otherwise>
<form action="checkcode.do" >
<div class="row">
<div class="col-4">
</div>
<div class="col-4">
<label for="code">Enter the 4 digit code sent to your mail:</label>
<input type="text" class="form-control" name="code">
</div>
</div>
<div class="row">
<div class="col-4"></div>

<div class="col-4">
<br>
<input type="submit">
</div>

</div>

</form>
</c:otherwise>
</c:choose>

</div>
</body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
	
</html>