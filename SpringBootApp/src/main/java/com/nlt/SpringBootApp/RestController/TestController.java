package com.nlt.SpringBootApp.RestController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{
	public TestController()
	{
		System.out.println("Object Created");
	}
	@RequestMapping(value ="/hello")
	public String Home() 
	{
		return "Good Morning";
	}
}
