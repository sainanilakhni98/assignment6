package com.nagarro.EmployeeManagementApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.EmployeeManagementApp.Employee;
import com.nagarro.EmployeeManagementApp.dao.EmployeeDao;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeDao dao;
	
//	@DeleteMapping("/employee/{code}")
//	public String deleteEmployee(@PathVariable int code)
//	{
//		dao.delete(dao.getOne(code));
//		
//	}
	@DeleteMapping("/employee/{code}")
	public void deleteStudent(@PathVariable int code) {
		dao.deleteById(code);
	}
	
	@PutMapping("/employee")
	public Employee saveOrUpdateEmployee(@RequestBody Employee employee)
	{
		dao.save(employee);
		return employee;
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		dao.save(employee);
		return employee;
	}
	
	@GetMapping("/employee")
	public List<Employee> getEmployee()
	{
		return dao.findAll();
	}
	
	@GetMapping("/employee/{code}")
	public Optional<Employee> getEmployee(@PathVariable("code") int code)
	{
		return dao.findById(code);
	}
	
}


