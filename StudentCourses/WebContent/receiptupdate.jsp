<%@page import="org.nlt.model.receipts"%>
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
		receipts receipt=Config.receiptMap.get(courseDetails);
	%>

<jsp:include page="style.jsp"></jsp:include>
<!-- body -->

<body>

    <jsp:include page="loader.jsp"></jsp:include>
    <jsp:include page="title.jsp"></jsp:include>
    <jsp:include page="menubar.jsp"></jsp:include>
             
			           	 
         <div class="containerU">
            	<div class="row title">
            		<div class="col-md-12">STUDENT REGISTRATION</div>
            	</div>  
            <div class="row">
            	<div class="col-md-6">
            		<form action="./receipt" method="post">
            			<div class="container">
            				<div class="row">
	          					<div class="col-md-3"><input type="hidden" name="page" value="updateReceipt" class="form-control form-control-sm"/></div>
	          					<div class="col-md-3"><input type="hidden" name="receiptDetail" value="<%=receipt.getPhone() %>-<%=receipt.getCourse()%>" /></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Name</div>
	          					<div class="col-md-6"><input type="text" name="name" value="<%=receipt.getName() %>" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Age</div>
	          					<div class="col-md-6"><input type="text" name="age" value="<%=receipt.getAge() %>" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Phone</div>
	          					<div class="col-md-6"><input type="text" name="phone" value="<%=receipt.getPhone() %>"  class="form-control form-control-sm"/></div>
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
	          								<option <%=receipt.getCourse().equals(courseName)?"Selected":""%> value="<%=courseName %>"><%=courseName %></option>
	          							<%
	          								}
	          							%>
	          						</select>
	          					</div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Fees</div>
	          					<div class="col-md-6"><input type="text" name="fees" value="<%=receipt.getTotalfees() %>" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Fees</div>
	          					<div class="col-md-6"><input type="text" name="pfees" value="<%=receipt.getPaidfess()%>" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6"><input type="submit" value="UPDATE" class="btn btn-secondary"/></div>
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