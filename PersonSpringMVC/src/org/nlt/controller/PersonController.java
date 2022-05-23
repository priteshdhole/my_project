package org.nlt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nlt.main.ParentInterface;
import org.nlt.model.Persons;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class PersonController extends ParentController implements ParentInterface
{
	
	//DispatcherServlet
	//InternalResourceViewResolver
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home(HttpServletRequest req, HttpServletResponse res)
	{
		
		Map m=new HashMap<>();
		m.put("action", "personRegistraion");
		m.put("buttonValue", "Register");
		m.put("cityList", cityServices.getCityList());
		return new ModelAndView("person",m);
	}
	
	@RequestMapping(value="personRegistraion", method=RequestMethod.POST)
	public ModelAndView addPerson(HttpServletRequest req, HttpServletResponse res)
	{
		Map m=new HashMap<>();
		
		String name=req.getParameter("name");
		String age=req.getParameter("age");
		String phone=req.getParameter("phone");
		
		Persons person=new Persons();
		personService.addPerson(person);
		return new ModelAndView("person",m);
		
	}
}
