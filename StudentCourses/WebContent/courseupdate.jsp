<%@page import="org.nlt.model.Courses"%>
<%@page import="java.util.Collection"%>
<%@page import="org.nlt.database.Config"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html lang="en">

<link href="css/style.css" type="text/css" rel="stylesheet">



<jsp:include page="head.jsp"></jsp:include>
<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">

	<%
		String name=request.getParameter("name");
		Courses cour=Config.courseMap.get(name);
	%>

<jsp:include page="style.jsp"></jsp:include>
<!-- body -->

<body>

    <jsp:include page="loader.jsp"></jsp:include>
    <jsp:include page="title.jsp"></jsp:include>
    <jsp:include page="menubar.jsp"></jsp:include>
             
	            	 
  	<div class="container1">
  	<div class="row title">
    	<div class="col-md-12">Courses</div>
    </div> 
            
		<div class="row">
		    <div class="col-md-6">
			    <form action="./course" method="post">
				    <div class="container">
					    <div class="row">
							<div class="col-md-3">
								<input type="hidden" name="page" value="UpdateCourse" class="form-control form-control-sm"/>
								<input type="hidden" name="oldCourseName" value="<%=cour.getName() %>" class="form-control form-control-sm"/>
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-6">Enter Course Name</div>
							<div class="col-md-6"><input type="text" name="name" value="<%=cour.getName() %>" class="form-control form-control-sm"/></div>
						</div>
						
						<div class="row">
							<div class="col-md-6">Enter Course Fees</div>
							<div class="col-md-6"><input type="text" name="fees" value="<%=cour.getFees() %>" class="form-control form-control-sm"/></div>
						</div>
						
						<div class="row">
							<div class="col-md-6"><input type="submit" value="UPDATE" class="btn btn-secondary"/></div>
						</div>
				    </div>
			    </form>
		    </div>
	    </div>
   </div>
    
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- end footer -->
    <jsp:include page="script.jsp"></jsp:include>

</body>

</html>