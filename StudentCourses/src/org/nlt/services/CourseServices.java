package org.nlt.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.nlt.database.Config;
import org.nlt.model.Courses;

public class CourseServices implements Config
{
	public boolean addCourse(Courses course)
	{
		Session ses=getConnection();
		ses.beginTransaction();
		ses.save(course);
		ses.getTransaction().commit();
		return true;
	}
	
	public boolean updateCourse(Courses course)
	{
		Session ses=getConnection();
		ses.beginTransaction();
		ses.update(course);
		ses.getTransaction().commit();
		return true;
	}
	
	public void getCourseList()
	{
		Session ses=getConnection();
		ses.beginTransaction();
		Query query=ses.createQuery("from Courses where status=1");
		List<Courses>courseList=query.list();
		courseMap.clear();
		for(Courses course: courseList)
		{
			courseMap.put(course.getName(), course);
		}
	}
	
	public boolean isCoursePresent(String name)
	{
		Session ses=getConnection();
		ses.beginTransaction();
		
		Query query=ses.createQuery("from Courses where name='"+name+"' and status=1");
		List<Courses> courseList=query.list();
		
		ses.getTransaction().commit();
		
		if(courseList.size()==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
