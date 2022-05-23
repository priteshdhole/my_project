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
<h1>Education Portal</h1>

<form action="./aadhar" method="post">
	<table>
		<tr>
			<td>
				<input type="hidden" name="page" value="educationInfo">
			</td>
		</tr>
		
		<tr>
			<td>Select Education
			<td>
				<select name="education" class="form-selec form-control-sm">
				<option selected>Choose....</option>
				<option value="SSC">SSC</option>
				<option value="HSC">HSC</option>				
				<option value="BE">BE</option>				
				<option value="B.TEch">B.TEch</option>				
				<option value="MBA">MBA</option>				
				<option value="BBA">BBA</option>				
				<option value="B.COM">B.COM</option>				
				<option value="Pharmacy">Pharmacy</option>				
				
				</select>				
			</td>
		</tr>

		<tr>
			<td>Select Hobbies</td>
			<td>
				<input type="checkbox" class="form-selec form-control-sm" name="hobbies" value="reading"/>Reading
				<input type="checkbox" class="form-selec form-control-sm" name="hobbies" value="writing"/>Writing
				<input type="checkbox" class="form-selec form-control-sm" name="hobbies" value="playing"/>Playing
				<input type="checkbox" class="form-selec form-control-sm" name="hobbies" value="dancing"/>Dancing
			</td>
		</tr>	
		
		<tr>
			<td>Languages Known</td>
			<td>
				<input type="checkbox" class="form-selec form-control-sm" name="languages" value="hindi"/>Hindi
				<input type="checkbox" class="form-selec form-control-sm" name="languages" value="marathi"/>Marathi
				<input type="checkbox" class="form-selec form-control-sm" name="languages" value="english"/>English
			</td>
		</tr>
		
		<tr>
			<td>
				<button class="w-auto">Submit</button>
			</td>
			
		</tr>
	</table>
</form>
</body>
</html>