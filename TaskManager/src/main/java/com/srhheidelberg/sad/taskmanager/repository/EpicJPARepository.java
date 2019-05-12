package com.srhheidelberg.sad.taskmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srhheidelberg.sad.taskmanager.model.Epic;

public interface EpicJPARepository extends JpaRepository<Epic, Integer> {

	List<Epic> getByEpicInitiative(Integer epicInitiative);

}
