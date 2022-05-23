package com.nlt.SpringBootApp.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nlt.SpringBootApp.RestController.ParentInterface;
import com.nlt.SpringBootApp.RestController.model.Persons;

@Service
public class PersonServices implements ParentInterface
{
	public Persons getPerson(int id)
	{
		return personMap.get(id);
	}
	
	public void addPerson(Persons person)
	{
		personMap.put(person.getId(),person);
	}
	
	public void updatePerson(int id,Persons person)
	{
		personMap.put(id, person);
	}
}
