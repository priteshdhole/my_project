package org.nlt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/TestController")
public class TestController extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		service(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		service(request, response);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String pageName=request.getParameter("page");
		
		if(pageName.equals("button1"))
		{
			String name=request.getParameter("name");
			out.println("Your Name is:"+name);
		}
		else if(pageName.equals("button2"))
		{
			try
			{
			String amo=request.getParameter("amount");
			int amt=Integer.parseInt(amo);
			amt=amt*10;
			Thread.sleep(5000);
			out.println("Your Amount Is :"+amt);
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}

}
