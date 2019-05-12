package com.srhheidelberg.sad.taskmanager.DAOInterface;

import java.util.List;

import com.srhheidelberg.sad.taskmanager.model.Employee;

public interface EmployeeDAOInterface {
	
	List<Employee> getAllEmployee();
	
	Employee getEmployee(Integer employeeId);
	
	Employee createEmployee(Employee employee);
	
	//List<Employee> employeesunderinitiative(Integer initiativeId);
	
	//List<Employee> employeesunderepic(Integer epicId);
	
	//List<Employee> employeesunderstory(Integer storyId);
	
	//List<Employee> employeesundertask(Integer taskId);
	
	Employee loginEmployee(String emailId, String password);

}
