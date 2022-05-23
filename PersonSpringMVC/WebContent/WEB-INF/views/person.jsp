<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%> 
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="head.jsp"></jsp:include>
<style type="text/css">
body{
    font-family: sans-serif;
}
.login-box{
    width: 800px;
    height: 600px;
    background: rgba(0, 0, 0, 0.5);
    color: #fff;
    top: 50%;
    left: 50%;
    position: absolute;
    transform: translate(-50%,-50%);
    box-sizing: border-box;
    padding: 70px 30px;
}
.avatar{
    width: 100px;
    height: 100px;
    border-radius: 50%;
    position: absolute;
    top: -50px;
    left: calc(50% - 50px);
}
h1{
    margin: 0;
    color:red;
    padding: 0 0 20px;
    text-align: center;
    font-size: 22px;
}
.login-box p{
    margin: 0;
    padding: 0;
    font-weight: bold;
}
.login-box input{
    width: 100%;
    margin-bottom: 20px;
}
.login-box select{
    width: 80%;
    height:30px;
    margin-bottom: 30px;
    background: transparent;
    margin-top: 10px;
    color: #fff;
    border-bottom: 2px solid #fff;
    font-size: 16px;
}
.login-box input[type="text"], input[type="password"]
{
    border: none;
    border-bottom: 2px solid #fff;
    background: transparent;
    outline: none;
    height: 40px;
    color: #fff;
    font-size: 16px;
}
.login-box input[type="submit"]
{
    border: none;
    outline: none;
    height: 40px;
    background: #1c8adb;
    color: #fff;
    font-size: 18px;
    border-radius: 20px;
}
.login-box input[type="submit"]:hover
{
    cursor: pointer;
    background: #39dc79;
    color: #000;
}

.login-box a{
    text-decoration: none;
    font-size: 14px;
    color: #fff;
}
.login-box a:hover
{
    color: #39dc79;
}

</style>

<body>
    <div class="login-box">
    <img src="res/images/avatar.png" class="avatar">
        <h1>Person Registration Portal</h1>
          <form action="${action}" method="post">
            <p>Enter Name</p>
            <input type="text" name="name" placeholder="Enter Username">
            <p>Enter Age</p>
            <input type="text" name="age" placeholder="Enter age">
            <p>Enter Phone</p>
            <input type="text" name="phone" placeholder="Enter phone"> 
            <p>Select City</p>
            <select  name="city">
            	<option value="select">Select</option>
            	<c:forEach items="${cityList}" var="city">
            		<option value="${city.name}" ${city.name eq cityValue ? 'selected' : ''}>${city.name}</option>
            	</c:forEach>
            </select>
            <p>
            <input type="submit" name="submit" value="${buttonValue}">
            </p>
            <p>${message}</p>   
          </form>
     </div>
 </body>
</html>