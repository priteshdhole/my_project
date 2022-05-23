<%@page import="org.nlt.model.Courses"%>
<%@page import="java.util.Collection"%>
<%@page import="org.nlt.database.Config"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
<jsp:include page="style.jsp"></jsp:include>
<!-- body -->
<body>

    <jsp:include page="loader.jsp"></jsp:include>
    <jsp:include page="title.jsp"></jsp:include>
    <jsp:include page="menubar.jsp"></jsp:include>
             
			    	 
            <div class="containerC">
            <div class="row title">
            		<div class="col-md-12">Courses</div>
            </div> 
                    
            <div class="row">
            	<div class="col-md-6">
            		<form action="./course" method="post">
            			<div class="container">
            				<div class="row">
	          					<div class="col-md-3"><input type="hidden" name="page" value="AddCourse" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Course Name</div>
	          					<div class="col-md-6"><input type="text" name="name" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Course Fees</div>
	          					<div class="col-md-6"><input type="text" name="fees" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6"><input type="submit" value="SUBMIT" class="btn btn-primary"/></div>
	          				</div>
            			</div>
            		</form>
            	</div>
            	<div class="col-md-6">
            		<div class="row detailsC">
			         	<div class="col-md-12">
			         		<div class="overflow-auto">
				          		<table class="table table-striped">
				          			<tr>
										<th align="center">ACTION</th>
										<th align="center">NAME</th>
										<th align="center">COURSE</th>
									</tr>
									<%
										Collection<Courses> courseList=Config.courseMap.values();
										for(Courses course:courseList)
										{
									%>
											<tr>
											<td ><a href="courseupdate.jsp?name=<%=course.getName()%>"><img src="images/edit.png"></a> || <a href="coursedelete.jsp?name=<%=course.getName()%>"><img src="images/drop.png"></a></td>
											<td ><%=course.getName() %></td>
											<td ><%=course.getFees() %></td>
											</tr>
									<%
										}
	 								%> 
				          		</table>
							</div>
		           		</div>
            		</div>
            	</div>
       </div>
       </div>
     <!-- end footer -->
    	<jsp:include page="footer.jsp"></jsp:include>
    <!-- end footer -->
   
    <jsp:include page="script.jsp"></jsp:include>

</body>

</html>