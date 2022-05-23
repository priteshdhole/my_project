package org.nlt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nlt.main.ParentInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends ParentController implements ParentInterface
{
	@RequestMapping(value="/")
	public ModelAndView home(HttpServletRequest req, HttpServletResponse res)
	{
		return new ModelAndView("login");
	}
}
