package com.srhheidelberg.sad.taskmanager.controller;

//import java.util.HashSet;
//import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srhheidelberg.sad.taskmanager.message.request.LoginForm;
//import com.srhheidelberg.sad.taskmanager.message.request.SignUpForm;
import com.srhheidelberg.sad.taskmanager.message.response.JwtResponse;
//import com.srhheidelberg.sad.taskmanager.message.response.ResponseMessage;
//import com.srhheidelberg.sad.taskmanager.model.EmployeeRole;
//import com.srhheidelberg.sad.taskmanager.model.RoleName;
//import com.srhheidelberg.sad.taskmanager.model.User;
import com.srhheidelberg.sad.taskmanager.repository.EmployeeRoleJPARepository;
import com.srhheidelberg.sad.taskmanager.repository.UserJPARepository;
import com.srhheidelberg.sad.taskmanager.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserJPARepository userJPARepository;

	@Autowired
	EmployeeRoleJPARepository employeeRoleJPARepository;

	/*@Autowired
	PasswordEncoder encoder;*/

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()));
	}

	/*@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userJPARepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userJPARepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<EmployeeRole> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				EmployeeRole managerRole = EmployeeRoleJPARepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(managerRole);

				break;
			case "ta":
				EmployeeRole taRole = EmployeeRoleJPARepository.findByName(RoleName.ROLE_MANAGER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(taRole);

				break;
			default:
				EmployeeRole cdRole = EmployeeRoleJPARepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(cdRole);
			}
		});

		user.setRoles(roles);
		userJPARepository.save(user);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}*/
}