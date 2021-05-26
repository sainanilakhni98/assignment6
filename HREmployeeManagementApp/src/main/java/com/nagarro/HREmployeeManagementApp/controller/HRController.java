package com.nagarro.HREmployeeManagementApp.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.HREmployeeManagementApp.dao.HRDao;
import com.nagarro.HREmployeeManagementApp.entity.HRDetail;


@Controller
public class HRController {
	
	@Autowired
	HRDao dao;
	
	@RequestMapping("/")
	public String home()
	{
		return "Home";
	}
	@RequestMapping("/welcome")
	public String welcome()
	{
		return "welcome";
	}
	@RequestMapping("/uploadEmployee")
	public String uploadEmployee()
	{
		return "uploadEmployee";
	}
	@RequestMapping("Home")
	public String login()
	{
		return "Home";
	}
	@RequestMapping("validate")
	public String validate(HttpSession session,@RequestParam String userid,@RequestParam String password)
	{
	    System.out.println(userid+" "+password);//just for check
		List<HRDetail> hrs=dao.findAll();
		for(HRDetail hr:hrs)
		{
			if((hr.getUserid().equals(userid)) &&(hr.getPassword().equals(password)))
			{
				session.setAttribute("name",userid);
				return "redirect:/welcome";
			}
		 }
		 session.setAttribute("message", "Wrong user-id password!");
	     return "Home";
	}
	
}
