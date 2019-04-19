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
@Table(name="timelog")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TimeLog {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="timelogid")
	private Integer timeLogId;
	
	@Column(name="timelogdescription")
	private String timeLogDescription;
	
	@Column(name="timelogaudit")
	private String timeLogAudit;
	
	@Column(name="timelogduration")
	private Integer timeLogDuration;
	
	@Column(name="timelogstory", insertable=false, updatable=false)
	private Integer timeLogStory;
	
	@Column(name="timelogtask", insertable=false, updatable=false)
	private Integer timeLogTask;
	
	@Column(name="timelogemployee", insertable=false, updatable=false)
	private Integer timeLogEmployee;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="timelogstory")
	private Story story;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="timelogtask")
	private Task task;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="timelogemployee")
	private Employee employee;

	public Integer getTimeLogId() {
		return timeLogId;
	}

	public void setTimeLogId(Integer timeLogId) {
		this.timeLogId = timeLogId;
	}


	public String getTimeLogDescription() {
		return timeLogDescription;
	}


	public void setTimeLogDescription(String timeLogDescription) {
		this.timeLogDescription = timeLogDescription;
	}

	public String getTimeLogAudit() {
		return timeLogAudit;
	}

	public void setTimeLogAudit(String timeLogAudit) {
		this.timeLogAudit = timeLogAudit;
	}
 

	public Integer getTimeLogDuration() {
		return timeLogDuration;
	}

	public void setTimeLogDuration(Integer timeLogDuration) {
		this.timeLogDuration = timeLogDuration;
	}

	public Integer getTimeLogStory() {
		return timeLogStory;
	}

	public void setTimeLogStory(Integer timeLogStory) {
		this.timeLogStory = timeLogStory;
	}

	public Integer getTimeLogTask() {
		return timeLogTask;
	}

	public void setTimeLogTask(Integer timeLogTask) {
		this.timeLogTask = timeLogTask;
	}

	public Integer getTimeLogEmployee() {
		return timeLogEmployee;
	}

	public void setTimeLogEmployee(Integer timeLogEmployee) {
		this.timeLogEmployee = timeLogEmployee;
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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "TimeLog [timeLogId=" + timeLogId + ", timeLogDescription=" + timeLogDescription + ", timeLogAudit="
				+ timeLogAudit + ", timeLogDuration=" + timeLogDuration + ", timeLogStory=" + timeLogStory
				+ ", timeLogTask=" + timeLogTask + ", timeLogEmployee=" + timeLogEmployee + ", story=" + story
				+ ", task=" + task + ", employee=" + employee + "]";
	}
}
