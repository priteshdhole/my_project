package org.nlt.controller;

import java.util.Date;
import java.util.HashMap;

import org.nlt.controller.services.PersonServices;
import org.nlt.database.DatabaseConnection;
import org.nlt.model.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PersonController 
{
	@Autowired
	private PersonServices personService;
	
	
	//DispatcherServlet
	//InternalResourceViewResolver
	public PersonController()
	{
		System.out.println("PC Object Created");
		//DatabaseConnection.getDatabaseSession();
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView home()
	{
		Map m=new HashMap();
		System.out.println("Hello NLT Show Method");
		m.put("action", "submitPerson");
		m.put("buttonValue", "SUBMIT");
		m.put("personList", personService.getPersonList());
		return new ModelAndView("index",m);
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public ModelAndView show2()
	{
		Map m=new HashMap();
		System.out.println("Hello NLT Show2 Method");
		return new ModelAndView("index",m);
	}
	
	@RequestMapping(value="submitPerson",method=RequestMethod.POST)
	public ModelAndView submitData(HttpServletRequest req,HttpServletResponse res)
	{
		Map m=new HashMap();
	
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String phone=req.getParameter("phone");
		m.put("action", "submitPerson");
		m.put("buttonValue", "SUBMIT");
		
		m.put("nameValue", name);
		m.put("ageValue", age);
		m.put("phoneValue", phone);
		
		
		if(name.isEmpty())
		{
			m.put("nameError", "Please Enter Name");
		}
		else if(age.isEmpty())
		{
			m.put("ageError", "Please Enter Age");
		}
		else if(phone.isEmpty())
		{
			m.put("phoneError", "Please Enter Phone");
		}
		else
		{
			Persons person=new Persons();
			person.setAge(Integer.parseInt(age));
			person.setCreated(new Date());
			person.setModified(new Date());
			person.setName(name);
			person.setPhone(phone);
			person.setStatus(1);
			
			if(personService.addPerson(person))
			{
				m.put("message", "Record Submitted Successfully");
			}
			else
			{
				m.put("errrorMessage", "Can Not Submit Record");
			}
		}
		
		m.put("personList", personService.getPersonList());
		return new ModelAndView("index",m);
	}
	
	
	@RequestMapping(value="getEditPerson",method=RequestMethod.GET)
	public ModelAndView getPersonDataForUpdate(HttpServletRequest req,HttpServletResponse res)
	{
		Map m=new HashMap();
		String id=req.getParameter("pid");
		
		Persons person=personService.getPerson(Integer.parseInt(id));
		m.put("nameValue", person.getName());
		m.put("ageValue", person.getAge());
		m.put("phoneValue", person.getPhone());
		m.put("idValue", person.getId());
		
		m.put("action", "updatePerson");
		m.put("buttonValue", "UPDATE");
		m.put("personList", personService.getPersonList());
		return new ModelAndView("index",m);
	}
	
	@RequestMapping(value="getDeletePerson",method=RequestMethod.GET)
	public ModelAndView getPersonDataForDelete(HttpServletRequest req,HttpServletResponse res)
	{
		Map m=new HashMap();
		String id=req.getParameter("pid");
		
		Persons person=personService.getPerson(Integer.parseInt(id));
		m.put("nameValue", person.getName());
		m.put("ageValue", person.getAge());
		m.put("phoneValue", person.getPhone());
		m.put("idValue", person.getId());
		
		m.put("action", "deletePerson");
		m.put("buttonValue", "DELETE");
		m.put("personList", personService.getPersonList());
		return new ModelAndView("index",m);
	}
	
	@RequestMapping(value="updatePerson",method=RequestMethod.POST)
	public ModelAndView updateData(HttpServletRequest req,HttpServletResponse res)
	{
		Map m=new HashMap();
	
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String phone=req.getParameter("phone");
		String id=req.getParameter("id");
		m.put("action", "updatePerson");
		m.put("buttonValue", "UPDATE");
		
		m.put("nameValue", name);
		m.put("ageValue", age);
		m.put("phoneValue", phone);
		m.put("idValue", id);
		
		
		if(name.isEmpty())
		{
			m.put("nameError", "Please Enter Name");
		}
		else if(age.isEmpty())
		{
			m.put("ageError", "Please Enter Age");
		}
		else if(phone.isEmpty())
		{
			m.put("phoneError", "Please Enter Phone");
		}
		else
		{
			Persons person=personService.getPerson(Integer.parseInt(id));
			
			person.setAge(Integer.parseInt(age));
			person.setModified(new Date());
			person.setName(name);
			person.setPhone(phone);
			
			if(personService.updatePerson(person))
			{
				m.put("message", "Record Updated Successfully");
				m.put("action", "submitPerson");
				m.put("buttonValue", "SUBMIT");
				m.put("nameValue", "");
				m.put("ageValue", "");
				m.put("phoneValue", "");
				m.put("idValue", "");
			}
			else
			{
				m.put("errrorMessage", "Can Not Submit Record");
			}
		}
		
		m.put("personList", personService.getPersonList());
		return new ModelAndView("index",m);
	}
	
	@RequestMapping(value="deletePerson",method=RequestMethod.POST)
	public ModelAndView deleteData(HttpServletRequest req,HttpServletResponse res)
	{
		Map m=new HashMap();
	
		String id=req.getParameter("id");
		m.put("action", "deletePerson");
		m.put("buttonValue", "DELETE");
		
		
		m.put("idValue", id);
		
		
		
			Persons person=personService.getPerson(Integer.parseInt(id));
			
			person.setStatus(0);
			person.setModified(new Date());
			
			if(personService.updatePerson(person))
			{
				m.put("message", "Record Deleted Successfully");
				m.put("action", "submitPerson");
				m.put("buttonValue", "SUBMIT");
				m.put("nameValue", "");
				m.put("ageValue", "");
				m.put("phoneValue", "");
				m.put("idValue", "");
			}
			else
			{
				m.put("errrorMessage", "Can Not Delete Record");
			}
		
		m.put("personList", personService.getPersonList());
		return new ModelAndView("index",m);
	}
}
