<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" type="text/css" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body>
<h1>Person Registration</h1>

<form action="./person" method="post">
	 Name      <input type="text" name="name"/><br><br>
	 Age       <input type="text" name="age"/><br><br>
	 Phone     <input type="text" name="phone"/><br><br>
	 Email_id  <input type="text" name="email"><br><br>
	 
	 <button type="submit" class="w-auto" >SUBMIT</button>
			 <button><a href="index.html" type="button" class="w-auto">BACK</a></button>
			 <button><a href="city.jsp" type="button" class="w-auto">City Registration</a></button>


</form>	


</body>
</html>