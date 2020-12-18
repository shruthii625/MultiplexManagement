<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Multiplex</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>
		
		</head>
	<body >
	
			<header class="jumbotron" >
				<h1>BookMyShow</h1>
				<p>Login to see if your favourite movie is playing!!<br />
				</p>
			</header>
			
		
		<div class="container">
		<p style="color:#228B22;">${SUCCESS}</p>
		<p style="color: #ff2361;">${errorString}</p>
	<h2>Sign In</h2>
	<div class="row">
	<div class="col">
			<form id="signup-form" method="post" action="login.do">
			<div class="form-group row">
			<div class="col">
    		<label for="username" >User Name : </label>
				<input type="text" class="form-control" name="uname" id="uname" placeholder="Username" />
			</div>
			<div class="col">
    	<label for="password">Password : </label>
				<input type="password" class="form-control" name="pwd" id="pwd" placeholder="password" />
				</div>
				</div>
				<div class="row">
				<div class="col">
				</div>
			<div class="col">
			<a href="forgot.do">forgot password?</a>
			</div>
			
			</div>
				
				<input type="submit" value="Sign In" />
			</form>
			</div>
			</div>
			<div>
			<br>
			<p>Not a user? <a href="signshow.do">Sign up</a></p>
			</div>
			</div>
		
	</body>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
	
</html>