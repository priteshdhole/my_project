package org.nlt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.nlt.database.Config;
import org.nlt.model.Users;
import org.nlt.services.UserServices;


public class LoginController extends HttpServlet implements Config
{
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		service(req, resp);
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession httpSession = req.getSession();
		PrintWriter out = resp.getWriter();
		
		resp.setContentType("text/html");
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		
		Users user=userServices.validateUser(username, password);
		
		if(user!=null)
		{
			studentServices.getStudentList();
			courseServices.getCourseList();
			receiptServices.getReceiptList();
			httpSession.setMaxInactiveInterval(6*50);
			httpSession.setAttribute("login", user);
			resp.sendRedirect("index.jsp");
		}
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			out.print("Invalid Login  Please Try Again");
			rd.include(req, resp);
		}
	}

}
