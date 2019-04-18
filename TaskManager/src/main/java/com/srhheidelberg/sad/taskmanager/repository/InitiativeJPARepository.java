package com.srhheidelberg.sad.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.Initiative;


public interface InitiativeJPARepository extends JpaRepository<Initiative, Integer>{

}
