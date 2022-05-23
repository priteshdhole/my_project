package org.nlt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.nlt.database.Config;
import org.nlt.model.Courses;

public class CourseController extends HttpServlet implements Config
{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		service(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		service(req, resp);
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession httpSession=req.getSession();
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
		String pageName=req.getParameter("page");
		System.out.println(pageName);
		if(pageName.equals("AddCourse"))
		{
			String name=req.getParameter("name").toUpperCase();
			String fees=req.getParameter("fees");
			
			if(name.equals("")||fees.equals(""))
			{
				RequestDispatcher rd=req.getRequestDispatcher("courses.jsp");
				out.println("Invalid Entry");
				rd.include(req, resp);
			}
			else
			{
				Courses course=new Courses();
				course.setName(name);
				course.setCreated(new Date());
				course.setFees(Integer.parseInt(fees));
				course.setModified(new Date());
				course.setStatus(1);
				
				if(!courseMap.containsKey(name))
				{
					courseServices.addCourse(course);
					courseServices.getCourseList();
					RequestDispatcher rd = req.getRequestDispatcher("courses.jsp");
					out.println("Course Registred Successfully");
					rd.include(req, resp);
				}
				else
				{
					RequestDispatcher rd = req.getRequestDispatcher("courses.jsp");
					out.println("Course Already Registred....");
					rd.include(req, resp);
				}
			}
		}
		else if(pageName.equals("UpdateCourse"))
		{
			 String oldName=req.getParameter("oldCourseName");
			 
			 String name=req.getParameter("name").toUpperCase();
			 String fees=req.getParameter("fees");
			 
			 if(name.equals("")||fees.equals(""))
			 {
				 RequestDispatcher rd=req.getRequestDispatcher("courses.jsp");
				 out.println("Invalid Entry...Please Try Again...");
				 rd.include(req, resp);
			 }
			 else
			 {
				 Courses course=Config.courseMap.get(oldName);
				 
				 course.setName(name);
				 course.setFees(Integer.parseInt(fees));
				 course.setModified(new Date());
				 
				 
				 if(!courseMap.containsKey(name))
				 {
					 courseServices.updateCourse(course);
					 courseServices.getCourseList();
					 RequestDispatcher rd=req.getRequestDispatcher("courses.jsp");
					 out.println("Course Updated Successfully");
					 rd.include(req, resp);
				 }
				 else
				 {
					 RequestDispatcher rd=req.getRequestDispatcher("courses.jsp");
					 out.println("Duplicate Entry....");
					 rd.include(req, resp);
				 }
			 }
		}
		else if(pageName.equals("DeleteCourse"))
		{
			String oldName=req.getParameter("oldCourseName");
			
			Courses course=courseMap.get(oldName);
			course.setModified(new Date());
			course.setStatus(0);
			
			courseServices.updateCourse(course);
			courseServices.getCourseList();
			RequestDispatcher rd=req.getRequestDispatcher("courses.jsp");
			out.println("Course Deleted Successfully");
			rd.include(req, resp);
		}
	}
}

