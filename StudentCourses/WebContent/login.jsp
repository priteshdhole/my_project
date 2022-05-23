<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

	<jsp:include page="head.jsp"></jsp:include>
	<link href="css/bootstrap.min.css" type="text/css" rel="stylesheet">
	<jsp:include page="style.jsp"></jsp:include>

	
	<%
		Object loginObj=session.getAttribute("login");
	
		if(loginObj!=null)
		{
			response.sendRedirect("index.jsp");
		}
	%>
<body>

    <jsp:include page="loader.jsp"></jsp:include>
            
    <form action="./login" method="post">
	    <div class="containerL">
			<div class="row titleL">
				<div class="col-md-6">Login Here.....</div>
			</div>
					
			<div class="row"> <!-- UserName row start -->
				<div class="col-md-6">User Name</div><!-- UserName col End -->
				<div class="col-md-6"><input type="text" class="form-control" name="username"  placeholder="Enter User Name Here"/></div>
			</div> <!-- UserName row End -->
					
			<div class="row"> <!-- password row start -->
				<div class="col-md-6">Password</div> <!-- password col start -->
				<div class="col-md-6"><input type="password" class="form-control" name="password"  placeholder="Enter Password Here"/></div>
			</div> <!-- password row End -->
			
			<div class="row">
				<div class="col-md-2"><input class="btn btn-primary active btn-md" type="submit" value="LogIn"/></div>
				<div class="col-md-2"><input class="btn btn-primary active btn-md" type="submit" value="Reset"/></div>
			</div>																				
		</div>
	</form>
            
     <!-- footer -->
    	<jsp:include page="footer.jsp"></jsp:include>
    <!-- end footer -->
    <jsp:include page="script.jsp"></jsp:include>
</body>
</html>