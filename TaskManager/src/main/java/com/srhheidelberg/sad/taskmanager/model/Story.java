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
	private Integer storyEstimatedGrand;	
	
	@Column(name="storyactualgrand")
	private Integer storyActualGrand;
	
	@Column(name="isstorycurrent")
	private Boolean isstoryCurrent;
	
	@Column(name="storyassignedto", insertable=false, updatable=false)
	private Integer storyAssignedTo;
	
	@Column(name="storystatus", insertable=false, updatable=false)
	private Integer storyStatus;
	
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

	public void setStoryActualGrand(Integer storyActualGrand) {
		this.storyActualGrand = storyActualGrand;
	}

	public Boolean getIsstoryCurrent() {
		return isstoryCurrent;
	}

	public void setIsstoryCurrent(Boolean isstoryCurrent) {
		this.isstoryCurrent = isstoryCurrent;
	}

	public Integer getStoryAssignedTo() {
		return storyAssignedTo;
	}

	public void setStoryAssignedTo(Integer storyAssignedTo) {
		this.storyAssignedTo = storyAssignedTo;
	}

	public Integer getStoryStatus() {
		return storyStatus;
	}

	public void setStoryStatus(Integer storyStatus) {
		this.storyStatus = storyStatus;
	}
	
	
	
}
