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
<h1>Contact Information Portal</h1>

<form action="./aadhar" method="post">
	<table width="600px" cellpadding="5px"; cellspacing="5px">
	
		<tr>
			<td>
				<input type="hidden" name="page" value="contactInfo">
			</td>
		</tr>

		<tr>
			<td>Enter Phone Number</td>
			<td>
				<input type="text" class="form-selec form-control-sm" name="phone"/>
			</td>
		</tr>
		
		<tr>
			<td>Email_ID</td>
			<td>
				<input type="text" class="form-selec form-control-sm" name="email"/>
			</td>
		</tr>
		
		<tr>
			<td>Enter Address</td>
			<td>
				<textarea class="form-selec form-control-sm" name="address" rows="6" cols="40"></textarea>
			</td>
		</tr>
		
		<tr>
			<td>
				<button class="w-auto">Next>></button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>