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
<h1>City Registration</h1>

	<form action="./city" method="post">
	
	City Name <input type="text" name="cityname"/><br><br>
	State Name <input type="text" name="statename"/><br><br>
	
	 <button type="submit" class="w-auto" >SUBMIT</button>
			 <button><a href="index.html" type="button" class="w-auto">BACK</a></button>
			 <button><a href="person.jsp" type="button" class="w-auto">Person</a></button>

	
	</form>

</body>
</html>