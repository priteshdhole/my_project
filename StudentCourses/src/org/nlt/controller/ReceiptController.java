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
import org.nlt.model.receipts;

public class ReceiptController  extends HttpServlet implements Config
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
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession httpSession=req.getSession();
		PrintWriter out=resp.getWriter();
		resp.setContentType("text/html");
		
		String pageName=req.getParameter("page");
		if(pageName.equals("AddReceipt"))
		{
			String name=req.getParameter("name").toUpperCase();
			String age=req.getParameter("age");
			String phone=req.getParameter("phone");
			String course=req.getParameter("course");
			String Tfees=req.getParameter("Tfees");
			String Pfees=req.getParameter("pfees");
			
			if(name.equals("")||age.equals("") ||phone.equals("") || course.equals("") ||Tfees.equals("")|Pfees.equals(""))
			{
				RequestDispatcher rd=req.getRequestDispatcher("receipt.jsp");
				out.println("Please Select All Records");
				rd.include(req, resp);
			}
			else
			{
				receipts receipt=new receipts();
				receipt.setName(name);
				receipt.setAge(Integer.parseInt(age));
				receipt.setPhone(phone);
				receipt.setCourse(course);
				receipt.setTotalfees(Integer.parseInt(Tfees));
				receipt.setPaidfess(Integer.parseInt(Pfees));
				receipt.setModified(new Date());
				receipt.setCreated(new Date());
				receipt.setStatus(1);
				
				if(!receiptMap.containsKey(phone+"-"+course))
				{
					receiptServices.addReceipt(receipt);
					receiptServices.getReceiptList();
					RequestDispatcher rd = req.getRequestDispatcher("receipt.jsp");
					out.println("Receipt Generated Successfully");
					rd.include(req, resp);
				}
				else
				{
					RequestDispatcher rd = req.getRequestDispatcher("receipt.jsp");
					out.println("Duplicate Receipt...Please Try Again..");
					rd.include(req, resp);
				}
			}
			
		}
		else if(pageName.equals("updateReceipt"))
		{
			 String receiptDetail=req.getParameter("receiptDetail");
			 
			 
			 String name=req.getParameter("name").toUpperCase();
			 System.out.println(name);
			 String age=req.getParameter("age");
			 System.out.println(age);
			 String phone=req.getParameter("phone");
			 System.out.println(phone);
			 String course=req.getParameter("course");
			 System.out.println(course);
			 String pfees=req.getParameter("pfees");
			 System.out.println(pfees);
			 String tfees=req.getParameter("fees");
			 System.out.println(tfees);
			 
			 if(name.equals("")||pfees.equals("")||tfees.equals("")||age.equals("")||phone.equals("")||course.equals(""))
			 {
				 RequestDispatcher rd=req.getRequestDispatcher("receipt.jsp");
				 out.println("Invalid Entry...Please Try Again...");
				 rd.include(req, resp);
			 }
			 else
			 {
				 receipts receipt=receiptMap.get(receiptDetail);
				 
				 receipt.setName(name);
				 receipt.setAge(Integer.parseInt(age));
				 receipt.setPhone(phone);
				 receipt.setCourse(course);
				 receipt.setPaidfess(Integer.parseInt(pfees));
				 receipt.setTotalfees(Integer.parseInt(tfees));
				 receipt.setModified(new Date());
				 receipt.setStatus(1);
				 
				 		
				 receiptServices.updateReceipt(receipt);
				 receiptServices.getReceiptList();
				 RequestDispatcher rd=req.getRequestDispatcher("receipt.jsp");
				 out.println("Receipt Updated Successfully");
				 rd.include(req, resp);
				 resp.sendRedirect("receiptupdate.jsp");
					
			}
		 }
		else if(pageName.equals("DeleteReceipt"))
		{
			 String receiptDetail=req.getParameter("receiptDetail");
			
			 receipts receipt=receiptMap.get(receiptDetail);
			 receipt.setStatus(0);
			
			receiptServices.updateReceipt(receipt);
			receiptServices.getReceiptList();
			RequestDispatcher rd=req.getRequestDispatcher("receipt.jsp");
			out.println("Receipt Deleted Successfully");
			rd.include(req, resp);
			resp.sendRedirect("receipt.jsp");
		}
	}
		
	}


