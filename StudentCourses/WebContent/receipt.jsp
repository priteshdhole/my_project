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
 <jsp:include page="style.jsp"></jsp:include>
 
<%
	Collection<Students> studentValues=Config.studentMap.values();//get key values set(phone and course and store in collection)
	String str="";
		for(Students student:studentValues)
		{
			str=str.concat("\""+student.getName()+"-"+student.getPhone()+"-"+student.getCourse()+"\",");//("\"" is used for to get data in double code)
		}
		if(!str.isEmpty())
		{
		str=str.substring(0,str.length()-1);
		}
%>
	
  <script>
      $(document).ready(function()
  {
    	  
	    	$(function() {
	    	var availableTags =[<%=str%>];
		    $( "#receiptname" ).autocomplete({
		      source: availableTags
		    });
		  });
  		
	    $("#go").click(function(){
	    	var sd=$("#receiptname").val();
	    	
	    	$.ajax({
	    		url:"ajax?page=studentreceipt&studentdetail="+sd,
	    		contentType:"text/html",
	    		type:"GET",
	    		
	    		success:function(result)
	    		{
	    			var splitArray=result.split("-");
	    			if(splitArray.length!=0)
	    				{
	    					$("#age").val(splitArray[0]);
	    					$("#phone").val(splitArray[1]);
	    					$("#course").val(splitArray[2]);
	    					$("#fees").val(splitArray[3]);
	    				}
	    		},
	    		error: function(result)
	    		{
	    			alert("Can Not Send Request");
	    		}
	    	});
	    });
 });
	   </script>
<body>

<%--     <jsp:include page="loader.jsp"></jsp:include> --%>
    <jsp:include page="title.jsp"></jsp:include>
    <jsp:include page="menubar.jsp"></jsp:include>
             
			 
               	 
<div class="container1">
	<div class="row title">
		<div class="col-md-12">RECIEPTS</div>
	</div> 
	<div class="row">
		<div class="col-md-6">
			<form action="./receipt" method="post">
				<div class="containerS">
					<div class="row">
						<div class="col-md-3"><input type="hidden" name="page" value="AddReceipt" class="form-control form-control-sm"/></div>
					</div>
					<div class="row">
						<div class="col-md-4">DATA</div>
						<div class="col-md-8"><div class="input-group"><input type="text" name="name" id="receiptname" class="form-control form-control-sm"/><input type="button" value="GO" id="go" class="btn btn-success"></div></div>
					</div>
					
					<div class="row">
						<div class="col-md-4">Enter Age</div>
						<div class="col-md-8"><input type="text" name="age" id="age" class="form-control form-control-sm"/></div>
					</div>
					
					<div class="row">
						<div class="col-md-4">Enter Phone</div>
							<div class="col-md-8"><input type="text" name="phone" id="phone" class="form-control form-control-sm"/>
						</div>
					</div>					
					<div class="row">
						<div class="col-md-4">Enter Course</div>
							<div class="col-md-8"><input type="text" name="course" id="course" class="form-control form-control-sm"/>
						</div>
					</div>					
					<div class="row">
						<div class="col-md-4">Total Fees</div>
							<div class="col-md-8"><input type="text" name="Tfees" id="fees" class="form-control form-control-sm"/>
						</div>
					</div>	
									
					<div class="row">
						<div class="col-md-4">Paid Fees</div>
							<div class="col-md-8"><input type="text" name="pfees" id="pfees" class="form-control form-control-sm"/>
						</div>
					</div>					
					
					
					<div class="row">
						<div class="col-md-6"><input type="submit" value="SUBMIT" class="btn btn-primary"/></div>
					</div>
				</div>
			</form>
		</div>
		<div class="col-md-6">
            		<div class="row detailsR">
			         	<div class="col-md-12">
			         		<div class="overflow-auto">
				          		<table class="table table-striped">
				          			<tr>
										<th >ACTION</th>
										<th >NAME</th>
										<th >COURSE</th>
										<th >Paid Fees</th>
									</tr>
									<%
										
										Collection<receipts> receiptList=Config.receiptMap.values();
										for(receipts receipt:receiptList)
										{
									%>
											<tr>
											<td><a href="receiptupdate.jsp?detail=<%=receipt.getPhone()%>-<%=receipt.getCourse()%>"><img src="images/edit.png"></a> || <a href="receiptdelete.jsp?detail=<%=receipt.getPhone()%>-<%=receipt.getCourse()%>"><img src="images/drop.png"></a></td>
											<td ><%=receipt.getName()%></td>
											<td><%=receipt.getCourse() %></td>
											<td> <%=receipt.getPaidfess()%></td>
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
<%--     <jsp:include page="script.jsp"></jsp:include> --%>
</body>

</html>