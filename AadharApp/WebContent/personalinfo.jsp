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
<h1>Personal Information Portal</h1>


<form action="./aadhar" method="post">
	<table width="500px" cellpadding="5px"; cellspacing="5px";>
	
	<tr>
		<td>
			<input type="hidden" name="page" value="personalInfo"/>
		</td>
	</tr>
	
	<tr>
		<td>Enter Name </td>
		<td>
			<input type="text" class="form-control form-control-sm"  name="name"  placeholder="Enter First Name"/>
		</td>
	</tr>
	
	<tr>
		<td>Select DOB</td>
		 <td>	
			 <input type="date" class="form-control form-control-sm" name="dob"/>
		</td>
	</tr>
	
	<tr>
		<td>Select Gender </td>
			<td>
				<input type="radio" class="form-control form-control-sm" name="gender" value="male"/>Male
				<input type="radio" class="from-control form-control-sm" name="gender" value="female"/>Female			
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