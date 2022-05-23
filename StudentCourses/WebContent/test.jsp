<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="js/jquery.min.js"></script>
<script language="javascript">
	$(document).ready(function(){
		
		$(".b1").click(function(){
			var name=$("#name").val();
			
			$.ajax({
					url :"test?page=button1&name="+name,
					contentType:"text/html",
					type:"GET",
					
					success:function(result)
					{
						alert(result);
					},
					error:function(result)
					{
						alert("Error");
					},
					beforeSend:function(result)
					{
						
					}
			});//ajax close
		});//b1 close
		
		$(".b2").click(function(){
			
			var amt=$("#amount").val();
			
			$.ajax({
				
				url:"test?page=button2&amount="+amt,
				contentType:"text/html",
				type:"GET",
				
				success: function(result)
				{	$("h2").fadeOut();	
					alert(result);
				},
				error:function(result)
				{
					alert("Error");
				},
				beforeSend:function(result)
				{
					$("h2").fadeIn();
				}
				
			});
		});
	});
</script>
</head>
<body>
	<input type="text" name="name" id="name"/> <input type="button" value="CLICK ME" class="b1"/>
	<input type="text" name="amount" id="amount"/> <input type="button" value="CLICK ME" class="b2"/>
	<h2 style="display: none; background-color: red">Request Sending</h2>
</body>
</html>