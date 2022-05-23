<%@page import="org.nlt.model.Students"%>
<%@page import="java.util.Collection"%>
<%@page import="org.nlt.database.Config"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>
<jsp:include page="style.jsp"></jsp:include>

<body>

    <jsp:include page="loader.jsp"></jsp:include>
    <jsp:include page="title.jsp"></jsp:include>
    <jsp:include page="menubar.jsp"></jsp:include>
                
    <div class="container1">
	    <div class="row detailsI">
		    <div class="col-md-12">
		    	<div class="overflow-auto">
				    <table class="table table-striped">
					    <tr>
						<th>ACTION</th>
						<th>NAME</th>
						<th>CONTACT</th>
						<th>COURSE</th>
						</tr>
						<%
							Collection<Students> studentsList=Config.studentMap.values();
							for(Students std:studentsList)
							{
						%>
								<tr>
								<td><a href="studentupdate.jsp?detail=<%=std.getPhone()%>-<%=std.getCourse()%>"><img src="images/edit.png"></a> || <a href="studentdelete.jsp?detail=<%=std.getPhone()%>-<%=std.getCourse()%>"><img src="images/drop.png"></a></td>
								<td><%=std.getName() %></td>
								<td><%=std.getPhone() %></td>
								<td><%=std.getCourse() %></td>
								</tr> 
						<%
							}
						%>         					
				    </table>
				  </div>
			</div>
	    </div>
    </div>
    
    <jsp:include page="footer.jsp"></jsp:include>
    <jsp:include page="script.jsp"></jsp:include>
    
    <!-- google map js -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA8eaHt9Dh5H57Zh0xVTqxVdBFCvFMqFjQ&callback=initMap"></script>
    <!-- end google map js -->

</body>

</html>