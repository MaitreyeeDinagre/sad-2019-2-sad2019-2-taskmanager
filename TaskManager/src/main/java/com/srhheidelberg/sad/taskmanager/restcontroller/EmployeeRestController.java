package com.srhheidelberg.sad.taskmanager.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.DAOInterface.EmployeeDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	
	@Autowired
	EmployeeDAOInterface employeeDAOInterface;
	
	@PostMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public Employee createEmployee(Employee employee) {
		System.out.println(employee);
		return employeeDAOInterface.createEmployee(employee);
	}
	
	@GetMapping("/{employeeId}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Employee getEmployee(ModelMap modelMap, @PathVariable Integer employeeId) {
		return employeeDAOInterface.getEmployee(employeeId);
	}
	
	@GetMapping("/")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Employee> getAllEmployee() {
		return employeeDAOInterface.getAllEmployee();
	}

}
