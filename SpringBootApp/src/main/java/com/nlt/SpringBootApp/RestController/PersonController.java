package com.nlt.SpringBootApp.RestController;

import java.util.Collection;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nlt.SpringBootApp.RestController.model.Persons;

@RestController
public class PersonController extends ParentController

{
	public PersonController()
	{
		Persons p1=new Persons(101,"Pritesh Dhole",23, 8208876197L);
		Persons p2=new Persons(102,"Prakash Dhole",24,7038131753L);
		Persons p3=new Persons(103,"Neha Dhole",20, 8208876197L);
		Persons p4=new Persons(104,"Meera Dhole",40, 8208876197L);
		
		personMap.put(p1.getId(), p1);
		personMap.put(p2.getId(), p2);
		personMap.put(p3.getId(), p3);
		personMap.put(p4.getId(), p4);
		
		
		System.out.println(personMap);
	}
	
	@RequestMapping(value = "/getPersons")
	public Collection<Persons> getPerson()
	{
		return personMap.values();
	}
	
	@RequestMapping(value = "/getPersons/{id}")
	public Persons getPerson(@PathVariable String id) 
	{
		return personService.getPerson(Integer.parseInt(id));
	}
	
	@RequestMapping(value = "/setPersons",method = RequestMethod.POST)
	public void SetPerson(@RequestBody Persons per)
	{
		personService.addPerson(per);
	}
	
	@RequestMapping(value = "/setPersons/{id}",method=RequestMethod.PUT)
	public void SetPerson(@RequestBody Persons per, @PathVariable String id)
	{
		personService.updatePerson(Integer.parseInt(id), per);
	}
}
