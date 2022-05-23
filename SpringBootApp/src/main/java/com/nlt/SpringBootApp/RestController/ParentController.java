package com.nlt.SpringBootApp.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import com.nlt.SpringBootApp.services.PersonServices;

public class ParentController implements ParentInterface
{
	@Autowired
	public PersonServices personService;
}
