package org.nlt.database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class DatabaseConnection {
	public static SessionFactory sf=null;
	public static Session ses=null;
	
	private DatabaseConnection()
	{
		try
		{
			sf=new Configuration().configure("org/nlt/database/hibernate.cfg.xml").buildSessionFactory();
			ses=sf.openSession();
			ses.beginTransaction();
			ses.getTransaction().commit();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	
	public static Session getDatabaseSession()
	{
		if(ses==null)
		{
			new DatabaseConnection();
		}
		
		return ses;
	}
	
}
