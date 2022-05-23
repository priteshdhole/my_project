package org.nlt.controller;

import java.util.LinkedHashMap;

import org.nlt.controller.services.CourseServices;
import org.nlt.controller.services.HomeServices;
import org.nlt.controller.services.LoginServices;
import org.nlt.controller.services.ReceiptServices;
import org.nlt.controller.services.StudentServices;
import org.nlt.controller.services.UserServices;
import org.nlt.model.Courses;
import org.nlt.model.Students;
import org.nlt.model.Users;
import org.springframework.beans.factory.annotation.Autowired;

public class ParentController
{
	@Autowired
	protected  CourseServices courseService;
	
	@Autowired
	protected HomeServices homeService;
	
	@Autowired
	protected LoginServices loginService;
	
	@Autowired
	protected ReceiptServices receiptService;

	@Autowired
	protected StudentServices studentService;
	
	@Autowired
	protected UserServices userService;
	
	protected LinkedHashMap<String, Courses> courseMap=new LinkedHashMap<>();
	protected LinkedHashMap<String, Students> studentMap=new LinkedHashMap<>();
	protected LinkedHashMap<String, Users> userMap=new LinkedHashMap<>();

	protected Users loginUser=new Users();
}
