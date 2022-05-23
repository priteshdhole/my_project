
<!DOCTYPE html>
<html>
<head>
	<title>Login Page</title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
 	
</head>

<%

Object loginObj=session.getAttribute("loginUserName");

if(loginObj!=null)
{
	response.sendRedirect("index.jsp");
}

%>

<style type="text/css">

.card{

height: 350px;
margin-top:11%;
margin-bottom: 50%;
width: 550px;

}

.card-header h3{
color: red;
}

.remember{
color: black;
}
.remember input
{
width: 20px;
height: 20px;
margin-left: 15px;
margin-right: 5px;
}

.login_btn{
color: red;
background-color:green;
width: 100px;
}
.card-header h1
{
 color:red;
}
</style>
<body>
<div class="container" >
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				<h1 align="center">LogIn</h1>
				<div class="d-flex justify-content-end social_icon">
				</div>
			</div>
			<div class="card-body">
				<form action="./aadhar" method="post">
					<div>
						<input type="hidden" name="page" value="LoginPage"/>
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
						</div>
						<input type="text" name="username" class="form-control" placeholder="username">
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend"></div>
						
						<input type="password" name="password" class="form-control" placeholder="password">
					</div>
					<div class="row align-items-center remember ">
						<input class="remeber" value=remeber type="checkbox" value="remeber"> Remember Me
					</div>
					<div class="form-group">
						<input type="submit" value="LogIn" class="btn float-right login_btn">
						<input type="submit" value="Reset" class="btn float-right login_btn">
					</div>
				</form>
			</div>
			<div class="card-footer">
				
				<div class="d-flex justify-content-center">
					<a href="#">Forgot your password?</a>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>