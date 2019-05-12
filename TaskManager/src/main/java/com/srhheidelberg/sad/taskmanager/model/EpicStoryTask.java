package com.srhheidelberg.sad.taskmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="epicstorytask")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EpicStoryTask {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="epicstorytaskid")
	private Integer epicStoryTaskId;
	
	@Column(name="epicstorytaskepic", insertable=false, updatable=false)
	private Integer epicStoryTaskEpic;
	
	@Column(name="epicstorytaskstory", insertable=false, updatable=false)
	private Integer epicStoryTaskStory;
	
	@Column(name="epicstorytasktask", insertable=false, updatable=false)
	private Integer epicStoryTaskTask;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="epicstorytaskepic")
	private Story epic;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="epicstorytaskstory")
	private Story story;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="epicstorytasktask")
	private Task task;

	public Integer getEpicStoryTaskId() {
		return epicStoryTaskId;
	}

	public void setEpicStoryTaskId(Integer epicStoryTaskId) {
		this.epicStoryTaskId = epicStoryTaskId;
	}

	public Integer getEpicStoryTaskStory() {
		return epicStoryTaskStory;
	}

	public void setEpicStoryTaskStory(Integer epicStoryTaskStory) {
		this.epicStoryTaskStory = epicStoryTaskStory;
	}

	public Integer getEpicStoryTaskTask() {
		return epicStoryTaskTask;
	}

	public void setEpicStoryTaskTask(Integer epicStoryTaskTask) {
		this.epicStoryTaskTask = epicStoryTaskTask;
	}

	
	
	public Integer getEpicStoryTaskEpic() {
		return epicStoryTaskEpic;
	}

	public void setEpicStoryTaskEpic(Integer epicStoryTaskEpic) {
		this.epicStoryTaskEpic = epicStoryTaskEpic;
	}

	public Story getEpic() {
		return epic;
	}

	public void setEpic(Story epic) {
		this.epic = epic;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "EpicStoryTask [epicStoryTaskId=" + epicStoryTaskId + ", epicStoryTaskEpic=" + epicStoryTaskEpic
				+ ", epicStoryTaskStory=" + epicStoryTaskStory + ", epicStoryTaskTask=" + epicStoryTaskTask + ", epic="
				+ epic + ", story=" + story + ", task=" + task + "]";
	}


	
}
