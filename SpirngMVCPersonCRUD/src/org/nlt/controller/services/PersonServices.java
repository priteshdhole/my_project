package org.nlt.controller.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.nlt.database.DatabaseConnection;
import org.nlt.model.Persons;
import org.springframework.stereotype.Service;

@Service
public class PersonServices 
{
	public PersonServices()
	{
		System.out.println("Object Created PS");
	}
	
	public boolean addPerson(Persons person)
	{
		Session ses=DatabaseConnection.getDatabaseSession();
		ses.beginTransaction();
		ses.save(person);
		ses.getTransaction().commit();
		return true;
	}
	public boolean updatePerson(Persons person)
	{
		Session ses=DatabaseConnection.getDatabaseSession();
		ses.beginTransaction();
		ses.update(person);
		ses.getTransaction().commit();
		return true;
	}
	
	public List<Persons> getPersonList()
	{
		Session ses=DatabaseConnection.getDatabaseSession();
		ses.beginTransaction();
		Query query = ses.createQuery("from Persons where status=1");
		List<Persons> personList=query.list();
		ses.getTransaction().commit();
		return personList;
	}
	
	public Persons getPerson(int id)
	{
		Session ses=DatabaseConnection.getDatabaseSession();
		ses.beginTransaction();
		Persons person=(Persons)ses.get(Persons.class, id);
		ses.getTransaction().commit();
		return person;
	}

}
