<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>
    <title>Sign Up</title>
</head>
<body>
    <header class="jumbotron">
        <h1>BookMyShow</h1>
        <p>Sign up to book your tickets now!!<br />
        </p>
    </header>
	<div class="container">
	
	<p style="color: #ff2361;">${accessdenied}</p>
	<p style="color: #ff2361;">${errorString}</p>
	<p style="color: #228B22">${success}</p>
	
	<h2>Sign Up</h2>
	<div class="row">
	<div class="col">
	    <form id="signup-form" method="post" action="home.do">
    	<div class="form-group" >
   		<div class="row">
    	<div class="col">
    	<label for="username" >User Name : </label>
        <input type="text" name="uname" class="form-control" id="uname" placeholder="Username" />
        </div>
        
        <div class="col">
    	<label for="password">Password : </label>
        <input type="password" class="form-control" name="pwd" id="pwd" placeholder="Password" />
        </div>
        </div>
        </div>
        
        <div class="form-group">
        <div class="row">
        
        <div class="col-sm-6">
    	<label for="phone">Phone Number:</label>
        <input type="text" name="phone" class="form-control" id="phone" placeholder="Mobile Number" />
        </div>
        
        <div class="col-sm-6">
        <label for="email">Email address:</label>
   		<input type="email" class="form-control" id="email"  name="email" placeholder="Email Address" >
        </div>
        
        </div>
        <br>
        <input type="submit" value="Sign Up" />
        </div>
        
    </form>
    </div>
    </div>
	
    
    <p>Already a user? <a href="loginpage.do" >Sign in</a></p>
    </div>
</body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js" integrity="sha384-LtrjvnR4Twt/qOuYxE721u19sVFLVSA4hf/rRt6PrZTmiPltdZcI7q7PXQBYTKyf" crossorigin="anonymous"></script>
</html>