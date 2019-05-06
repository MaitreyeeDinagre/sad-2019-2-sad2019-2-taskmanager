package com.srhheidelberg.sad.taskmanager.DAOImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srhheidelberg.sad.taskmanager.DAOInterface.EpicStoryTaskDAOInterface;
import com.srhheidelberg.sad.taskmanager.model.EpicStoryTask;
import com.srhheidelberg.sad.taskmanager.repository.EpicStoryTaskJPARepository;

@Service
public class EpicStoryTaskDAOImpl implements EpicStoryTaskDAOInterface{
	
	@Autowired
	EpicStoryTaskJPARepository epicstorytaskJPARepository;

	public List<EpicStoryTask> getAllEpicStoryTask() {
		return epicstorytaskJPARepository.findAll();
	}

	public EpicStoryTask getEpicStoryTask(Integer epicstorytaskId) {
		return epicstorytaskJPARepository.getOne(epicstorytaskId);
	}

	public EpicStoryTask createStoryTask(EpicStoryTask epicstorytask) {
		return epicstorytaskJPARepository.save(epicstorytask);
	}
	
	public void deleteEpicStoryTask(Integer epicstorytaskId) {
		epicstorytaskJPARepository.deleteById(epicstorytaskId);
	}
	
	public void deleteAllEpicStoryTask(List<EpicStoryTask> epicstorytask) {
		epicstorytaskJPARepository.deleteAll(epicstorytask);
	}	

	@Override
	public EpicStoryTask updateEpicStoryTask(EpicStoryTask epicstorytask) {
		return epicstorytaskJPARepository.save(epicstorytask);
}

	@Override
	public EpicStoryTask createEpicStoryTask(EpicStoryTask epicstorytask) {
		// TODO Auto-generated method stub
		return null;
	}

}