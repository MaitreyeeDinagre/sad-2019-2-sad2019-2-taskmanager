package com.srhheidelberg.sad.taskmanager.DAOInterface;

import java.util.List;


import com.srhheidelberg.sad.taskmanager.model.Epic;

public interface EpicDAOInterface {
	
	List<Epic> getAllEpic();
	
	Epic getEpic(Integer EpicId);
	
	Epic createEpic(Epic epic);

	List<Epic> getByEpicInitiative(Integer epicInitiative);
	

	

}
