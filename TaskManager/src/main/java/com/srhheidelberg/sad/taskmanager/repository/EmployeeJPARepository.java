package com.srhheidelberg.sad.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.Employee;


public interface EmployeeJPARepository extends JpaRepository<Employee, Integer>{

}
