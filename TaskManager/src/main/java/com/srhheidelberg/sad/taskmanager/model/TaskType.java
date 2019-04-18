package com.srhheidelberg.sad.taskmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tasktype")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TaskType {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="tasktypeid")
	private Integer taskTypeId;
	
	@Column(name="tasktypename")
	private String taskTypeName;
	
	@Column(name="tasktypedescription")
	private String taskTypeDescription ;

	public Integer getTaskTypeId() {
		return taskTypeId;
	}

	public String getTaskTypeName() {
		return taskTypeName;
	}

	public String getTaskTypeDescription() {
		return taskTypeDescription;
	}

	public void setTaskTypeId(Integer taskTypeId) {
		this.taskTypeId = taskTypeId;
	}

	public void setTaskTypeName(String taskTypeName) {
		this.taskTypeName = taskTypeName;
	}

	public void setTaskTypeDescription(String taskTypeDescription) {
		this.taskTypeDescription = taskTypeDescription;
	}

	@Override
	public String toString() {
		return "TaskType [taskTypeId=" + taskTypeId + ", taskTypeName=" + taskTypeName + ", taskTypeDescription="
				+ taskTypeDescription + "]";
	}
	
	
	

}
