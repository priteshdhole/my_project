package org.nlt.controller.services;

import java.util.List;

import org.hibernate.Query;
import org.nlt.main.ParentInterface;
import org.nlt.model.Persons;
import org.springframework.stereotype.Service;

@Service
public class PersonServices implements ParentInterface
{
	public PersonServices()
	{
		System.out.println("Object Created");
	}
	
	public boolean addPerson(Persons person)
	{
		
		ses.beginTransaction();
		System.out.println("Database Created1");
		ses.save(person);
		System.out.println("Database Created2");
		ses.beginTransaction().commit();
		return true;
		
	}
}
