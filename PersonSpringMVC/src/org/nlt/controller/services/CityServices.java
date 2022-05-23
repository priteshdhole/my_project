package org.nlt.controller.services;

import java.util.List;

import org.hibernate.Query;
import org.nlt.main.ParentInterface;
import org.nlt.model.Cities;
import org.springframework.stereotype.Service;

@Service
public class CityServices implements ParentInterface
{
	public boolean addCity(Cities city)
	{
		ses.beginTransaction();
		ses.save(city);
		ses.getTransaction().commit();
		return true;
	}
	public List<Cities> getCityList()
	{
		ses.beginTransaction();
		Query query=ses.createQuery("from cities where status=1");
		List<Cities> cityList=query.list();
		ses.getTransaction().commit();
		return cityList;
	}
	public Cities getCity(int id)
	{
		ses.beginTransaction();
		Cities city=(Cities)ses.get(Cities.class,id);
		ses.getTransaction().commit();
		return city;
	}
	
	public Cities getCityName(String cityName)
	{
		ses.beginTransaction();
		Query query=ses.createQuery("from Cities where status=1 and name='"+cityName+"'");
		List<Cities> cityListName=query.list();
		ses.getTransaction().commit();
		if(cityListName.size()!=0)
		{
			return cityListName.get(0);
		}
		else
		{
			return null;
		}
		}
		
	}
	

