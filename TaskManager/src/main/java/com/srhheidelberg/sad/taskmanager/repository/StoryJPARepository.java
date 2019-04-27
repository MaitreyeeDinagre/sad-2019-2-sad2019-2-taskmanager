package com.srhheidelberg.sad.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.Story;


public interface StoryJPARepository extends JpaRepository<Story, Integer>{

}
