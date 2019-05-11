package com.srhheidelberg.sad.taskmanager.restcontroller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.DAOInterface.EmployeeDAOInterface;
import com.srhheidelberg.sad.taskmanager.email.EmailSender;
import com.srhheidelberg.sad.taskmanager.message.request.SignUpForm;
import com.srhheidelberg.sad.taskmanager.model.Employee;
import com.srhheidelberg.sad.taskmanager.model.EmployeeRole;
import com.srhheidelberg.sad.taskmanager.model.RoleName;
import com.srhheidelberg.sad.taskmanager.model.User;
import com.srhheidelberg.sad.taskmanager.repository.EmployeeRoleJPARepository;
import com.srhheidelberg.sad.taskmanager.repository.UserJPARepository;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {
	
	@Autowired
	EmployeeDAOInterface employeeDAOInterface;
	
	@Autowired
	UserJPARepository userJPARepository;
	
	@Autowired
	PasswordEncoder encoder;
	
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
	
	@PostMapping("/adduser")
	@CrossOrigin(origins = "http://localhost:4200")
	public Employee addEmployee(@Valid @RequestBody SignUpForm signUpRequest, Employee employee) {
		
		//If Employee Created Successfully
		
		User user = new User(signUpRequest.getId(), signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<EmployeeRole> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				EmployeeRole managerRole = EmployeeRoleJPARepository.findByName(RoleName.ROLE_MANAGER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(managerRole);

				break;
		
			default:
				EmployeeRole userRole = EmployeeRoleJPARepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userJPARepository.save(user);
	
		//return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
		
		//Create User Record Auto Generated (name and Password)
		
		//If User Created Successfully, Send Email
		
		EmailSender.send("SADgroup2019@gmail.com","sadgroup",
				"kaustavpo12@gmail.com","Hello from Task Manager","Lets begin?");
		
		return addEmployee(signUpRequest, employee);
	}

}
