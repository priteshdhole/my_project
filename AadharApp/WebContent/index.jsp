<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-eMNCOe7tC1doHpGoWe/6oMVemdAVTMs2xqW4mwXrXsW0L84Iytr2wi5v2QjrP/xp" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyniUwwAZgrzD06kc/tftFf19TOAs2zVinnD/C7E91j9yyk5//jjpt/" crossorigin="anonymous"></script>


</head>
<%
	Object loginObj=session.getAttribute("loginUserName");

	String loginName="";

	if(loginObj==null)
	{
		response.sendRedirect("login.jsp");
	}
	else
	{
		loginName=loginObj.toString();
	}
%>
<body>

<div class="container">
	<div class="row">
		<div class="col-md-8">
			<h2>Welcome To Aadhar Registration Portal</h2>
			<h4><a href="personalinfo.jsp">Click Here To New Aadhar Registration</a></h4>
		</div>
		<div class="col-md-4">
			<h4 align="right">Login : <%=loginName.toUpperCase() %></h4>
		</div>
	</div>

<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aadhars","root","");
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("select * from records where status=1");
%>
	<div class="row">
		<div class="col-md-12">
			<table class="table table-striped" border="4" width="100%"  cellpadding="4" cellspacing="3">

				<tr align="center">
					<th colspan="100px"><br><h3><b>AADHAR DATA</b></h3></th>
				</tr>
				<tr >
				<th>ID</th>
				<th>NAME</th>
			    <th>DOB</th>
				<th>GENDER</th>
				<th>PHONE</th>
				<th>ADDRESS</th>
				<th>EMAIL_ID</th>
				<th>EDUCATION</th>
				<th>HOBBIES</th>
				<th>LANGUAGES</th>
				
				</tr>
				
				
					<%
						while(rs.next())
						{  	
							out.println("<tr>");
							out.println("<td>"+rs.getInt("id")+" </td>");
							out.println("<td width='30%'>"+rs.getString("name").toUpperCase()+" </td>");
							out.println("<td width='50%'>"+rs.getDate("dob")+" </td>");
							out.println("<td>"+rs.getString("gender").toUpperCase()+" </td>");
							out.println("<td>"+rs.getString("phone")+" </td>");
							out.println("<td width='50%'>"+rs.getString("address").toUpperCase()+" </td>");
							out.println("<td>"+rs.getString("email").toUpperCase()+" </td>");
							out.println("<td >"+rs.getString("education").toUpperCase()+" </td>");
							out.println("<td>"+rs.getString("hobbies").toUpperCase()+" </td>");
							out.println("<td>"+rs.getString("languages").toUpperCase()+" </td>");
							out.println("</tr>");
							
							//out.println("<tr></tr>");
							//out.println("<td>"+rs.getString("name")+" </td>");
						}
					rs.close();
					smt.close();
					con.close();
					%>
				
			</table>
		</div>
	</div>
</div>
</body>
</html>
