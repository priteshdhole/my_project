<%@page import="org.nlt.model.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="style.jsp"></jsp:include>
<div class="head-top">
                    	<%
                 			Users user=(Users)session.getAttribute("login");
	                    	if(user==null)
	                    	{
	                    		response.sendRedirect("login.jsp");
	                    	}
	                    	
                    	%>
                   <div class="container">
                        <div class="row">
                            <div class="col-xl-4 col-lg-4 col-md-4 col-sm-4">
                                <div class="email">
                                    <a ><img src='images/mail_icon1.jpg' /> Email :<%=user.getEmail() %></a>
                                </div>
                                <div class="email">
                                   <div class="col-md-4"><a href="./student?page=LogOutPage" class="logout"><img src="images/user1.jpg"/>LogOut</a> </div>
                                </div>
                            </div>
                            <div class="col-xl-4 col-lg-4 col-md-4 col-sm-4">
                                <div class="logo">
                                    <a href="index.html"><img src="images/logo1.png" /></a>
                                </div>
                            </div>
                            <div class="col-md-4">
                            	<div class="user">
		                                <div class="contact_nu">
		                                    <a href="#"><%=user!=null?"<img src='images/user1.jpg' />:"+user.getName().toUpperCase():""%></a>
		                                </div>
		                         </div>
		                         <div class="phone">
		                                <div class="contact_nu">
		                                   <a href="#"><img src='images/user1.jpg' />:<%=user.getContact()%></a>
		                                </div>
		                         </div>
                            </div>
                        </div>
                    </div>
                </div>