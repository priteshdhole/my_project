<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${action}" method="post">
		<table width="50%" cellpadding="5px" cellspacing="5px">	
			<tr>
				<td width="20%"><input type="hidden" name="id" value="${idValue}"/></td>
			</tr>
			<tr>
				<td width="20%">Enter Name</td>
				<td width="20%"><input type="text" name="name" value="${nameValue}"/></td>
				<td style="color:red">${nameError}</td>
			</tr>
			<tr>
				<td width="20%">Enter Age</td>
				<td width="20%"><input type="text" name="age" value="${ageValue}"/></td>
				<td style="color:red">${ageError}</td>
			</tr>
			<tr>
				<td width="20%">Enter Phone</td>
				<td width="20%"><input type="text" name="phone" value="${phoneValue}"/></td>
				<td style="color:red">${phoneError}</td>
			</tr>
			
			<tr>
				<td><input type="submit" value="${buttonValue}"/></td>
			</tr>
			<tr>
				<td style="color:green"><h5>${message}</h5></td>
			</tr>
			<tr>
				<td style="color:green"><h5>${errorMessage}</h5></td>
			</tr>
		</table>
	</form>
	
	<table width="50%" height="auto" border='1'>
		<tr>
			<th>ACTION</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>PHONE</th>
		</tr>
		<c:forEach items="${personList}" var="person">
		<tr>
			<td><a href="getEditPerson?pid=${person.id}">Edit</a>||<a href="getDeletePerson?pid=${person.id}">Delete</a></td>
			<td>${person.name}</td>
			<td>${person.age}</td>
			<td>${person.phone}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>