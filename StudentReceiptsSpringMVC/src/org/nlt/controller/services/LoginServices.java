package org.nlt.controller.services;

import java.util.List;

import org.hibernate.Query;
import org.nlt.main.ParentInterface;
import org.nlt.model.Users;
import org.springframework.stereotype.Service;

@Service
public class LoginServices implements ParentInterface
{
	public Users validateUser(String email, String password)
	{
		ses.beginTransaction();
		Query query=ses.createQuery("from Users where status=1 and email='"+email+"' and password='"+password+"'");
		List<Users> userList=query.list();
		ses.getTransaction().commit();
		System.out.println("DataBase Created1");
		if(userList.size()!=0)
		{System.out.println("DataBase Created2");
			Users user=userList.get(0);
			return user;
		}
		else
		{
			return null;
		}
	}
}
