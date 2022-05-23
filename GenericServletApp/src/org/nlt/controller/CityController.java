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

public class CityController extends GenericServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		String cname =req.getParameter("cityname");	
		String sname=req.getParameter("statename");
		
		PrintWriter out=res.getWriter();
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/genericservlet","root","");
			Statement smt=con.createStatement();
			smt.execute("insert into city(city,state,status) values ('"+cname+"','"+sname+"',1)");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			out.println("<h3>City Registered Successfully<h3>");
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
