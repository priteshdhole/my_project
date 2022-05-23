<%@page import="org.nlt.model.Students"%>
<%@page import="java.util.Set"%>
<%@page import="org.nlt.model.Courses"%>
<%@page import="java.util.Collection"%>
<%@page import="org.nlt.database.Config"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">

<%
		String courseDetails=request.getParameter("detail");
		Students student=Config.studentMap.get(courseDetails);
	%>

<jsp:include page="style.jsp"></jsp:include>
<!-- body -->

<body class="main-layout">

    <jsp:include page="loader.jsp"></jsp:include>
    <jsp:include page="title.jsp"></jsp:include>
    <jsp:include page="menubar.jsp"></jsp:include>
             
			           	 
         <div class="containerD">
            	<div class="row title">
            		<div class="col-md-12">STUDENT REGISTRATION</div>
            	</div>  
            <div class="row">
            	<div class="col-md-6">
            		<form action="./student" method="post">
            			<div class="container">
            				<div class="row">
	          					<div class="col-md-3"><input type="hidden" name="page" value="DeleteStudent" class="form-control form-control-sm"/></div>
	          					<div class="col-md-3"><input type="hidden" name="studentDetail" value="<%=student.getPhone()%>-<%=student.getCourse()%>" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Name</div>
	          					<div class="col-md-6"><input type="text" name="name" value="<%=student.getName() %>" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Age</div>
	          					<div class="col-md-6"><input type="text" name="age" value="<%=student.getAge() %>" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Phone</div>
	          					<div class="col-md-6"><input type="text" name="phone" value="<%=student.getPhone() %>"  class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Select Course</div>
	          					<div class="col-md-6">
	          						<select name="course" class="form-control form-control-sm">
	          							<option value="Select">Select</option>
	          							<%
	          								Set<String> courseSet=Config.courseMap.keySet();
	          								for(String courseName:courseSet)
	          								{
	          							%>
	          								<option value=<%=student.getCourse().equals(courseName)?"Selected":""%> value="<%=courseName%>"><%=courseName %></option>
	          							<%
	          								}
	          							%>
	          						</select>
	          					</div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Fees</div>
	          					<div class="col-md-6"><input type="text" name="fees" value="<%=student.getFees() %>" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6"><input type="submit" value="DELETE" class="btn btn-danger"/></div>
	          				</div>
            			</div>
            		</form>
            	</div>
            </div>
          </div>
    <!-- footer -->
    	<jsp:include page="footer.jsp"></jsp:include>
    <!-- end footer -->
    
    <jsp:include page="script.jsp"></jsp:include>

</body>

</html>