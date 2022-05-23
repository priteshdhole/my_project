package org.nlt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nlt.database.Config;
import org.nlt.model.Courses;
import org.nlt.model.Students;
@WebServlet("/AjaxController")
public class AjaxController extends HttpServlet  implements Config
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		service(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		service(request, response);
	}
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		String pageName=request.getParameter("page");
		
		if(pageName.equals("studentcourse"))
		{
			String courseName=request.getParameter("course");
			Courses course=courseMap.get(courseName);
			out.println(course.getFees());
		}
		else if(pageName.equals("studentreceipt"))
		{
			String studentdetail=request.getParameter("studentdetail");
			//System.out.println(studentdetail);
			if(studentdetail!=null || !studentdetail.isEmpty())
			{
				String[] split = studentdetail.split("-",2);
				Students student=studentMap.get(split[1]);
				out.println(student.getAge()+"-"+student.getPhone()+"-"+student.getCourse()+"-"+student.getFees());
			}
		}
	}
}
