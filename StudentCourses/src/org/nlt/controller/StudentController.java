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
import org.nlt.model.Students;

public class StudentController extends HttpServlet implements Config
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
		if(pageName.equals("AddStudent"))
		{
			String name=req.getParameter("name").toUpperCase();
			String age=req.getParameter("age");
			String phone=req.getParameter("phone");
			String course=req.getParameter("course");
			String fees=req.getParameter("fees");
			
			if(name.equals("")||age.equals("") ||phone.equals("") || course.equals("") ||fees.equals(""))
			{
				RequestDispatcher rd=req.getRequestDispatcher("StudentsRegistration.jsp");
				out.println("Invalid Entry");
				rd.include(req, resp);
			}
			else
			{
				Students student=new Students();
				student.setName(name);
				student.setAge(Integer.parseInt(age));
				student.setPhone(phone);
				student.setCourse(course);
				student.setFees(Integer.parseInt(fees));
				student.setStatus(1);
				
				if(!studentMap.containsKey(phone+"-"+course))
				{
					studentServices.addStudent(student);
					studentServices.getStudentList();
					RequestDispatcher rd = req.getRequestDispatcher("StudentsRegistration.jsp");
					out.println("Record Submitted Successfully");
					rd.include(req, resp);
				}
				else
				{
					RequestDispatcher rd = req.getRequestDispatcher("StudentsRegistration.jsp");
					out.println("Duplicate Entry...Please Try Again..");
					rd.include(req, resp);
				}
			}
		}
		else if(pageName.equals("UpdateStudent"))
		{
			 
			 String name=req.getParameter("name").toUpperCase();
			 String fees=req.getParameter("fees");
			 String age=req.getParameter("age");
			 String course=req.getParameter("course");
			 String phone=req.getParameter("phone");
			 String studentDetail=req.getParameter("studentDetail");
			 
			 if(name.equals("")||fees.equals("")||age.equals("")|phone.equals("")||course.equals(""))
			 {
				 RequestDispatcher rd=req.getRequestDispatcher("StudentsRegistration.jsp");
				 out.println("Invalid Entry...Please Try Again...");
				 rd.include(req, resp);
			 }
			 else
			 {
				 Students student=studentMap.get(studentDetail);
				 student.setName(name);
				 student.setFees(Integer.parseInt(fees));
				 student.setAge(Integer.parseInt(age));
				 student.setCourse(course);
				 student.setPhone(phone);
				 
				studentServices.updateStudent(student);
				studentServices.getStudentList();;
				RequestDispatcher rd=req.getRequestDispatcher("StudentsRegistration.jsp");
				out.println("Student Record Updated Successfully");
				rd.include(req, resp);
				resp.sendRedirect("StudentsRegistration.jsp");
			 }
		}
		else if(pageName.equals("DeleteStudent"))
		{
			 String studentDetail=req.getParameter("studentDetail");
			
			 Students student=studentMap.get(studentDetail);
			 student.setStatus(0);
			
			studentServices.updateStudent(student);
			studentServices.getStudentList();
			RequestDispatcher rd=req.getRequestDispatcher("StudentsRegistration.jsp");
			out.println("student Deleted Successfully");
			rd.include(req, resp);
			resp.sendRedirect("StudentsRegistration.jsp");
		}
		else if(pageName.equals("LogOutPage"))
		{
			httpSession.invalidate();
			resp.sendRedirect("login.jsp");
		}
	}
}

