package org.nlt.database;

import java.sql.DriverManager;
import java.util.LinkedHashMap;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.nlt.model.Courses;
import org.nlt.model.Students;
import org.nlt.model.receipts;
import org.nlt.services.CourseServices;
import org.nlt.services.ReceiptServices;
import org.nlt.services.StudentServices;
import org.nlt.services.UserServices;

public interface Config {
	
	public final UserServices userServices=new UserServices();
	public final StudentServices studentServices=new StudentServices();
	public final CourseServices courseServices=new CourseServices();
	public final ReceiptServices receiptServices= new ReceiptServices();
	
	public final LinkedHashMap<String, String> userMap=new LinkedHashMap<>(); 
	public final LinkedHashMap<String, Courses> courseMap=new LinkedHashMap<>();
	public final LinkedHashMap<String, Students> studentMap=new LinkedHashMap<>();
	public final LinkedHashMap<String, receipts> receiptMap=new LinkedHashMap<>();
	
	
	
	default Session getConnection()
	{
		try
		{
			SessionFactory sf = new Configuration().configure("org/nlt/database/hibernate.cfg.xml").buildSessionFactory();
			return sf.openSession();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return null;
	}
}
