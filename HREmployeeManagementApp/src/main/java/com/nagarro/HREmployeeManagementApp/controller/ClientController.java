package com.nagarro.HREmployeeManagementApp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.HREmployeeManagementApp.dao.HRDao;
import com.nagarro.HREmployeeManagementApp.entity.Employee;
import com.nagarro.HREmployeeManagementApp.entity.HRDetail;

@RestController
public class ClientController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired 
	HRDao dao;

	@RequestMapping(value="/employee",method = RequestMethod.GET)
	public ModelAndView getemployee(HttpEntity<Object> requestEntity) {
		ResponseEntity<List> responseEntity = restTemplate.exchange("http://localhost:8888/employee", HttpMethod.GET,
				requestEntity, List.class);
		List user = (List) responseEntity.getBody();
		System.out.println(user);
		ModelAndView mv = new ModelAndView();
		mv.addObject("allEmployee", user);
		mv.setViewName("welcome");
		return mv;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public ModelAndView createProducts(Employee employee) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);
		
		restTemplate.exchange("http://localhost:8888/employee", HttpMethod.POST, entity, String.class).getBody();
		ModelAndView mv = new ModelAndView("uploaded");
		
		return mv;
	}

//	 @RequestMapping(value = "/employee/{code}", method = RequestMethod.DELETE)
//	   public String deleteProduct(@RequestParam("code") String id) {
//	      HttpHeaders headers = new HttpHeaders();
//	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//	      HttpEntity<Employee> entity = new HttpEntity<Employee>(headers);
//	      
//	      return restTemplate.exchange(
//	         "http://localhost:8080/Employee/"+id, HttpMethod.DELETE, entity, String.class).getBody();
//	   }
//	
}
