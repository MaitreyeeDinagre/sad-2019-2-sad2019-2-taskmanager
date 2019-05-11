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
	private Epic epic;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="epicstorytaskstory")
	private Story story;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="epicstorytasktask")
	private Task task;

	public Integer getStoryTaskId() {
		return epicStoryTaskId;
	}

	public void setepicStoryTaskId(Integer epicStoryTaskId) {
		this.epicStoryTaskId = epicStoryTaskId;
	}

	public Integer getepicStoryTaskStory() {
		return epicStoryTaskStory;
	}

	public void setepicStoryTaskStory(Integer epicStoryTaskStory) {
		this.epicStoryTaskStory = epicStoryTaskStory;
	}

	public Integer getepicStoryTaskTask() {
		return epicStoryTaskTask;
	}

	public void setepicStoryTaskTask(Integer epicStoryTaskTask) {
		this.epicStoryTaskTask = epicStoryTaskTask;
	}

	@Override
	public String toString() {
		return "EpicStoryTask [epicStoryTaskId=" + epicStoryTaskId + ", epicStoryTaskStory=" + epicStoryTaskStory + ", epicStoryTaskTask="
				+ epicStoryTaskTask + "]";
	}
	
	
	

}
