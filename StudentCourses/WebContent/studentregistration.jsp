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
 <script language="javascript">
 
 $(document).ready(function(){
 	$("#course").change(function()
 			
 	{
 		var courseName=$("#course").val();
 		if(courseName!="Select")
 			{
 				$.ajax({
 					url:"ajax?page=studentcourse&course="+courseName,
 					contentType:"text/html",
 					type:"GET",
 					success: function(result){
 						$("#fees").val(result);	
 					},
 					error:function(result)
 					{
 						alert("Error");
 					}
 				});
 			}//if close
 	});//change eventS
 });
</script>

<jsp:include page="style.jsp"></jsp:include>
<!-- body -->

<body>

    <jsp:include page="loader.jsp"></jsp:include>
    <jsp:include page="title.jsp"></jsp:include>
    <jsp:include page="menubar.jsp"></jsp:include>
             
			 
                        	 
         <div class="container1">
         	<div class="row title">
            	<div class="col-md-12">STUDENT REGISTRATION</div>
             </div> 
            <div class="row">
            	<div class="col-md-6">
            		<form action="./student" method="post">
            			<div class="containerS">
            				<div class="row">
	          					<div class="col-md-3"><input type="hidden" name="page" value="AddStudent" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Name</div>
	          					<div class="col-md-6"><input type="text" name="name" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Age</div>
	          					<div class="col-md-6"><input type="text" name="age" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Phone</div>
	          					<div class="col-md-6"><input type="text" name="phone" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Select Course</div>
	          					<div class="col-md-6">
	          						<select name="course"  id="course" class="form-control form-control-sm">
	          							<option value="Select">Select</option>
	          							<%
	          								Set<String> courseSet=Config.courseMap.keySet();
	          								for(String courseName:courseSet)
	          								{
	          							%>
	          								<option value="<%=courseName%>"> <%=courseName%></option>
	          							<%
	          								}
	          							%>
	          						</select>
	          					</div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6">Enter Fees</div>
	          					<div class="col-md-6"><input type="text" name="fees" id="fees" class="form-control form-control-sm"/></div>
	          				</div>
	          				<div class="row">
	          					<div class="col-md-6"><input type="submit" value="SUBMIT" class="btn btn-primary"/></div>
	          				</div>
            			</div>
            		</form>
            	</div>
            	<div class="col-md-6">
            		<div class="row detailsS">
			         		<div class="col-md-12">
			         		<div class="overflow-auto">
				          		<table class="table table-striped">
				          			<tr>
										<th >ACTION</th>
										<th>NAME</th>
										<th>CONTACT</th>
										<th >COURSE</th>
									</tr>
									<%
										Collection<Students> studentList=Config.studentMap.values();
										for(Students studnet:studentList)
										{
									%>
											<tr>
											<td><a href="studentupdate.jsp?detail=<%=studnet.getPhone()%>-<%=studnet.getCourse()%>"><img src="images/edit.png"></a> || <a href="studentdelete.jsp?detail=<%=studnet.getPhone()%>-<%=studnet.getCourse()%>"><img src="images/drop.png"></a></td>
											<td ><%=studnet.getName() %></td>
											<td><%=studnet.getPhone()%></td>
											<td ><%=studnet.getCourse() %></td>
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
    <!-- footer -->
   	 <jsp:include page="footer.jsp"></jsp:include>
    <!-- end footer -->
    <jsp:include page="script.jsp"></jsp:include>
</body>

</html>