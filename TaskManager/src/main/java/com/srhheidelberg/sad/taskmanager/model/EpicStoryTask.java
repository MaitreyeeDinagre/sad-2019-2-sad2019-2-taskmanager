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
@Table(name="storytask")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EpicStoryTask {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="storytaskid")
	private Integer storyTaskId;
	
	@Column(name="storytaskstory", insertable=false, updatable=false)
	private Integer storyTaskStory;
	
	@Column(name="storytasktask", insertable=false, updatable=false)
	private Integer storyTaskTask;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="storytaskstory")
	private Story story;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="storytasktask")
	private Task task;

	public Integer getStoryTaskId() {
		return storyTaskId;
	}

	public void setStoryTaskId(Integer storyTaskId) {
		this.storyTaskId = storyTaskId;
	}

	public Integer getStoryTaskStory() {
		return storyTaskStory;
	}

	public void setStoryTaskStory(Integer storyTaskStory) {
		this.storyTaskStory = storyTaskStory;
	}

	public Integer getStoryTaskTask() {
		return storyTaskTask;
	}

	public void setStoryTaskTask(Integer storyTaskTask) {
		this.storyTaskTask = storyTaskTask;
	}

	@Override
	public String toString() {
		return "StoryTask [storyTaskId=" + storyTaskId + ", storyTaskStory=" + storyTaskStory + ", storyTaskTask="
				+ storyTaskTask + "]";
	}
	
	
	

}
