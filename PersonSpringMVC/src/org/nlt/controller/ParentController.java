package org.nlt.controller;

import java.util.LinkedHashMap;

import org.nlt.controller.services.CityServices;
import org.nlt.controller.services.PersonServices;
import org.nlt.model.Cities;
import org.nlt.model.Persons;
import org.springframework.beans.factory.annotation.Autowired;

public class ParentController 
{
	@Autowired
	protected PersonServices personService;
	
	@Autowired
	protected CityServices cityServices;
	
	
	LinkedHashMap<String, Persons> personMap=new LinkedHashMap<>();
	LinkedHashMap<String, Cities> cityMap=new LinkedHashMap<>();
}
