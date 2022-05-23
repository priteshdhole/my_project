package org.nlt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nlt.main.ParentInterface;
import org.nlt.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends ParentController implements ParentInterface
{	
	
	@RequestMapping(value="login" ,method=RequestMethod.POST)
	public ModelAndView loginUser(HttpServletRequest req, HttpServletResponse res)
	{
		Map m=new HashMap<>();
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Users user=loginService.validateUser(email,password);
		System.out.println("DataBase Created3");
		if(user!=null)
		{
			m.put("buttonValue", "SUBMIT");
			m.put("action", "StudentRegistration");
			return new ModelAndView("index",m);
		}
		else
		{
			m.put("message", "Invalid Login.. Please Try again");
			return new ModelAndView("login", m);
		}
	}
}
