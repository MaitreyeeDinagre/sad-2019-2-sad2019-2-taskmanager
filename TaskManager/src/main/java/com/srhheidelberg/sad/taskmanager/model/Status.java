package com.srhheidelberg.sad.taskmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="status")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Status {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="statusid")
	private Integer statusId;
	
	@Column(name="statusname")
	private Integer statusName;
	
	@Column(name="statusdescription")
	private Integer statusDescription;

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getStatusName() {
		return statusName;
	}

	public void setStatusName(Integer statusName) {
		this.statusName = statusName;
	}

	public Integer getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(Integer statusDescription) {
		this.statusDescription = statusDescription;
	}

	@Override
	public String toString() {
		return "status [statusId=" + statusId + ", statusName=" + statusName + ", statusDescription="
				+ statusDescription + "]";
	}

	
}
