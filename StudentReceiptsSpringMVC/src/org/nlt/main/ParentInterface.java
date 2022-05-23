package org.nlt.main;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

public interface ParentInterface
{
	public SessionFactory sf=DatabaseConnection.getSessionFactory();
	public Session ses=sf.openSession();
}
