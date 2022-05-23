package com.nlt.SpringBootApp.RestController;

import java.util.HashMap;
import java.util.Map;

import com.nlt.SpringBootApp.RestController.model.Persons;
import com.nlt.SpringBootApp.services.PersonServices;

public interface ParentInterface 
{
	public Map<Integer, Persons> personMap= new HashMap();
	
	public PersonServices personService=null;
}
