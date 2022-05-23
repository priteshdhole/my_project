package org.nlt.services;

import java.util.List;

import javax.servlet.RequestDispatcher;

import org.hibernate.Query;
import org.hibernate.classic.Session;
import org.nlt.database.Config;
import org.nlt.model.Users;

public class UserServices  implements Config
 {
	public Users validateUser(String username, String password)
	{
		Session ses=getConnection();
		ses.beginTransaction();
		Query query = ses.createQuery("from Users where email='"+username+"' and password='"+password+"' and status=1");
		List<Users> userList=query.list();
		
		ses.getTransaction().commit();
		
		if(userList.size()!=0)
		{
			Users user= userList.get(0);
			user.setPassword("");
			return user;
		}
		else
		{
			return null;
		}
		
	}

 }
