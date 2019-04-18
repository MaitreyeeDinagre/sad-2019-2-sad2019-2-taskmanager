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
@Table(name="story")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Story {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="storyid")
	private Integer storyId;
	
	@Column(name="storyname")
	private String storyName;
	
	@Column(name="storyestimatedgrand")
	private int storyEstimatedGrand;	
	
	@Column(name="storyactualgrand")
	private int storyActualGrand;
	
	@Column(name="isstorycurrent")
	private int isstoryCurrent;
	
	@Column(name="storyassignedto", insertable=false, updatable=false)
	private int storyAssignedTo;
	
	@Column(name="storystatus", insertable=false, updatable=false)
	private String storyStatus;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="storyassignedto")
	private Employee employee;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="storystatus")
	private Status status;

	public Integer getStoryId() {
		return storyId;
	}

	public void setStoryId(Integer storyId) {
		this.storyId = storyId;
	}

	public String getStoryName() {
		return storyName;
	}

	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}

	public int getStoryEstimatedGrand() {
		return storyEstimatedGrand;
	}

	public void setStoryEstimatedGrand(int storyEstimatedGrand) {
		this.storyEstimatedGrand = storyEstimatedGrand;
	}

	public int getStoryActualGrand() {
		return storyActualGrand;
	}

	public void setStoryActualGrand(int storyActualGrand) {
		this.storyActualGrand = storyActualGrand;
	}

	public int getIsstoryCurrent() {
		return isstoryCurrent;
	}

	public void setIsstoryCurrent(int isstoryCurrent) {
		this.isstoryCurrent = isstoryCurrent;
	}

	public int getStoryAssignedTo() {
		return storyAssignedTo;
	}

	public void setStoryAssignedTo(int storyAssignedTo) {
		this.storyAssignedTo = storyAssignedTo;
	}

	public String getStoryStatus() {
		return storyStatus;
	}

	public void setStoryStatus(String storyStatus) {
		this.storyStatus = storyStatus;
	}
	
	
	
}
