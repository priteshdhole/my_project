package org.nlt.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseConnection
{
	public static SessionFactory getSessionFactory()
	{
		return new Configuration().configure("org/nlt/database/hibernate.cfg.xml").buildSessionFactory();
	}
}
