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
@Table(name="task")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="taskid")
	private Integer taskId;
	
	@Column(name="taskname")
	private String taskName;
	
	@Column(name="taskdescription")
	private String taskDescription;
	
	@Column(name="taskestimatedtime")
	private int taskEstimatedTime;
	
	@Column(name="taskactualtime")
	private int taskActualTime;
	
	@Column(name="taskassignedto", insertable=false, updatable=false)
	private int taskAssignedTo;
	
	@Column(name="taskstatus", insertable=false, updatable=false)
	private int taskStatus;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="taskassignedto")
	private Employee employee;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="taskstatus")
	private Status status;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public int getTaskEstimatedTime() {
		return taskEstimatedTime;
	}

	public void setTaskEstimatedTime(int taskEstimatedTime) {
		this.taskEstimatedTime = taskEstimatedTime;
	}

	public int getTaskActualTime() {
		return taskActualTime;
	}

	public void setTaskActualTime(int taskActualTime) {
		this.taskActualTime = taskActualTime;
	}

	public int getTaskAssignedTo() {
		return taskAssignedTo;
	}

	public void setTaskAssignedTo(int taskAssignedTo) {
		this.taskAssignedTo = taskAssignedTo;
	}

	public int getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(int taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", taskDescription=" + taskDescription
				+ ", taskEstimatedTime=" + taskEstimatedTime + ", taskActualTime=" + taskActualTime
				+ ", taskAssignedTo=" + taskAssignedTo + ", taskStatus=" + taskStatus + ", employee=" + employee
				+ ", status=" + status + "]";
	}


}
