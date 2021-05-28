package com.nagarro.EmployeeManagementApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nagarro.EmployeeManagementApp.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer>
{

}
