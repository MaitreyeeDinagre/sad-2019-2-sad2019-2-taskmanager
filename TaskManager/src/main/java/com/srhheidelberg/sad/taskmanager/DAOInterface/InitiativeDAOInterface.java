package com.srhheidelberg.sad.taskmanager.DAOInterface;

import java.util.List;

import com.srhheidelberg.sad.taskmanager.model.Initiative;

public interface InitiativeDAOInterface {
	
	List<Initiative> getAllInitiative();
	
	Initiative getInitiative(Integer intitiativeId);
	
	Initiative createInitiative(Initiative initiative);

}
