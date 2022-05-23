package org.nlt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AadharController  extends HttpServlet
{
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	 {
		 service(req, resp);
	 }
	 
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	 {
		 service(req, resp);
	 }
	 
	 @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	 {
		 resp.setContentType("text/html");
		 String pageName= req.getParameter("page");
		// System.out.println(pageName);
		 PrintWriter out=resp.getWriter();
		 
		 HttpSession ses=req.getSession();
		 
		 String userAgent=req.getHeader("user-agent");
		 String user=userAgent.toString();
		 
//		 System.out.println("Session ID :"+ses);
//		 System.out.println("Browser & Machine :"+userAgent);
//		 System.out.println("Ip Address : "+req.getRemoteAddr());
		 String ip=req.getRemoteAddr();
		 
		 String os=""; // to get a od detail from which os request get fire.
		 
		 if (userAgent.toLowerCase().indexOf("windows") >= 0 )
         {
             os = "Windows";
         } else if(userAgent.toLowerCase().indexOf("mac") >= 0)
         {
             os = "Mac";
         } else if(userAgent.toLowerCase().indexOf("x11") >= 0)
         {
             os = "Unix";
         } else if(userAgent.toLowerCase().indexOf("android") >= 0)
         {
             os = "Android";
         } else if(userAgent.toLowerCase().indexOf("iphone") >= 0)
         {
             os = "IPhone";
         }else{
             os = "UnKnown, More-Info: "+userAgent;
         }
		 
		// System.out.println("Operating System :"+os);
		 
		 
		 String browser=""; //to get browser detail from browser request is fire.
		 
		 if (user.contains("msie"))
	        {
	            String substring=userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
	            browser=substring.split(" ")[0].replace("MSIE", "IE")+"-"+substring.split(" ")[1];
	        } else if (user.contains("safari") && user.contains("version"))
	        {
	            browser=(userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
	        } else if ( user.contains("opr") || user.contains("opera"))
	        {
	            if(user.contains("opera"))
	                browser=(userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0]+"-"+(userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
	            else if(user.contains("opr"))
	                browser=((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-")).replace("OPR", "Opera");
	        } else if (user.contains("chrome"))
	        {
	            browser=(userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
	        } else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)  || (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1) || (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1) )
	        {
	            //browser=(userAgent.substring(userAgent.indexOf("MSIE")).split(" ")[0]).replace("/", "-");
	            browser = "Netscape-?";
	                  
	        } else if (user.contains("firefox"))
	        {
	            browser=(userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
	        } else if(user.contains("rv"))
	        {
	            browser="IE-" + user.substring(user.indexOf("rv") + 3, user.indexOf(")"));
	        } else
	        {
	            browser = "UnKnown, More-Info: "+userAgent;
	        }
		 
		 
			 if(pageName.equals("personalInfo"))
			 {
				String pName= req.getParameter("name");
				String DOB= req.getParameter("dob");
				String Gender= req.getParameter("gender");
				
				
		//				System.out.println(pName);
		//				System.out.println(DOB);
		//				System.out.println(Gender);
						
						ses.setAttribute("n", pName);
						ses.setAttribute("d", DOB);
						ses.setAttribute("g", Gender);
						
												
						resp.sendRedirect("contactinfo.jsp");
			 }
			 else if(pageName.equals("contactInfo"))
			 {	
				 
				String phone= req.getParameter("phone");
				String Email= req.getParameter("email");
				String Address= req.getParameter("address");
				
//				System.out.println(phone);
//				System.out.println(Email);
//				System.out.println(Address);
				
				ses.setAttribute("p", phone);
				ses.setAttribute("e", Email);
				ses.setAttribute("ad", Address);
				
				resp.sendRedirect("educationinfo.jsp");
			 }
				 else if(pageName.equals("educationInfo"))
				 {
					String education= req.getParameter("education");
					String[] hobbiesArray= req.getParameterValues("hobbies");
					String[] languagesArray= req.getParameterValues("languages");
					
	//				System.out.println(Education);
	//				System.out.println(Hobbies);
	//				System.out.println(Languages);
					
					String hobbies="";
					for(String h:hobbiesArray)
					{
						hobbies=hobbies.concat(h)+" ";
					}
					String languages="";
					for(String lan:languagesArray)
					{ 
						languages=languages.concat(lan)+" ";
					}
					
					String name=ses.getAttribute("n").toString();
					String dob=ses.getAttribute("d").toString();
					String gender=ses.getAttribute("g").toString();
				    String phone=ses.getAttribute("p").toString();
					String email=ses.getAttribute("e").toString();
					String address=ses.getAttribute("ad").toString();
				
					
					
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Aadhars","root","");
						Statement smt=con.createStatement();
						smt.execute("insert into records(name,dob,gender,phone,email,address,education,hobbies,languages,os,ip,browser,status)values('"+name+"','"+dob+"','"+gender+"','"+phone+"','"+email+"','"+address+"','"+education+"','"+hobbies+"','"+languages+"','"+os+"','"+ip+"','"+browser+"',1)");
					
						resp.sendRedirect("index.jsp");
						out.println("<h3>Record Submitted Successfully<h3>");
						
						smt.close();
						con.close();
						
					}
					catch(Exception ex)
					{
						System.err.println("<h2>'"+ex+"'</h2>");
					}
				
				}
			 
				 else if(pageName.equals("LoginPage"))
				 {
					 String uName=req.getParameter("username");
					 String pWord= req.getParameter("password");
					
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/aadhars","root","");
						Statement smt=con.createStatement();
						ResultSet rs=smt.executeQuery("select * from users where Username='"+uName+"' and Password='"+pWord+"' and Status=1");
					
						if(rs.next())
						{
							String loginUser=rs.getString("Name");
							rs.close();
							smt.close();
							con.close();
							ses.setAttribute("loginUserName", loginUser);
							resp.sendRedirect("index.jsp");
						}
						else
						{
							rs.close();
							smt.close();
							con.close();
							
							RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
							out.println("<h2>Invalid Login....Pleaser Try Again...</h2>");
							rd.include(req, resp);						
						}
					}
					catch(Exception ex)
					{
						out.println(ex);
					}
				 }
		 }
}
	 

