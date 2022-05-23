package org.nlt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PersonController extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{	res.setContentType("text/html");
		String Name=req.getParameter("name");
		String Age=req.getParameter("age");
		String Phone=req.getParameter("phone");
		String Email=req.getParameter("email");
		
		PrintWriter out=res.getWriter();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/genericservlet","root","");
			Statement smt=con.createStatement();
			smt.execute("insert into person(Name,Age,Phone,Email,status) values ('"+Name+"','"+Age+"','"+Phone+"','"+Email+"',1)");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			out.println("<h3>Person Registered Successfully<h3>");
			rd.include(req, res);
			
			smt.close();
			con.close();
		}
		catch(Exception ex)
		{
			out.println("<h3>'"+ex+"'</h3>");
			
		}	
	}
}
