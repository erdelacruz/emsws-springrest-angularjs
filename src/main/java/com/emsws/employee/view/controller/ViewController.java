package com.emsws.employee.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String viewHomePage(){
		return "Home";
	}
	
	@RequestMapping(value="/AddEmployee",method=RequestMethod.GET)
	public String viewAddEmployeePage(){
		return "AddEmployeePage";
	}
	
}
