package com.srhheidelberg.sad.taskmanager.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srhheidelberg.sad.taskmanager.model.User;
import com.srhheidelberg.sad.taskmanager.repository.UserJPARepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserJPARepository userJPARepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userJPARepository.findByUsername(username).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + username));

		return UserPrinciple.build(user);
	}
}