package com.srhheidelberg.sad.taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.Epic;

public interface EpicJPARepository extends JpaRepository<Epic, Integer> {

}
