package com.srhheidelberg.sad.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.Employee;
import com.srhheidelberg.sad.taskmanager.model.Initiative;


public interface InitiativeJPARepository extends JpaRepository<Initiative, Integer>{

}
