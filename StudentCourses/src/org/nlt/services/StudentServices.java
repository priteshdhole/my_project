package org.nlt.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nlt.database.Config;
import org.nlt.model.Students;

public class StudentServices implements Config
{
	public void getStudentList()
	{
		Session ses=getConnection();
		ses.beginTransaction();
		
		Query query=ses.createQuery("from Students where status=1");
		List<Students> studentList=query.list();
		studentMap.clear();
		
		for(Students student: studentList)
		{
			studentMap.put(student.getPhone()+"-"+student.getCourse(), student);
		}
	}
	
	public boolean addStudent(Students student)
	{
		Session ses=getConnection();
		ses.beginTransaction();
		ses.save(student);
		ses.getTransaction().commit();
		return true;
	}
	public boolean updateStudent(Students student)
	{
		Session ses=getConnection();
		ses.beginTransaction();
		ses.update(student);
		ses.getTransaction().commit();
		return true;
	}
	public boolean deleteStudent(Students student)
	{
		Session ses=getConnection();
		ses.beginTransaction();
		ses.update(student);
		ses.getTransaction().commit();
		return true;
	}
	
	
}
