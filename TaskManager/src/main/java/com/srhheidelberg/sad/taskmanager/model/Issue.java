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
@Table(name="issue")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Issue {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="issueid")
	private Integer issueId;

	@Column(name="issuename")
	private String issueName;

	@Column(name="issuedescription")
	private String issueDescription;

	@Column(name="issuestory", insertable=false, updatable=false)
	private Integer issueStory;

	@Column(name="issuestatus", insertable=false, updatable=false)
	private Integer issueStatus;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="issuestory")
	private Story story;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="issuestatus")
	private Status status;

	public Integer getIssueId() {
		return issueId;
	}


	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}


	public String getIssueName() {
		return issueName;
	}


	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}


	public String getIssueDescription() {
		return issueDescription;
	}


	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}


	public Integer getIssueStory() {
		return issueStory;
	}


	public void setIssueStory(Integer issueStory) {
		this.issueStory = issueStory;
	}


	public Integer getIssueStatus() {
		return issueStatus;
	}


	public void setIssueStatus(Integer issueStatus) {
		this.issueStatus = issueStatus;
	}


	public Story getStory() {
		return story;
	}


	public void setStory(Story story) {
		this.story = story;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Issue [issueId=" + issueId + ", issueName=" + issueName + ", issueDescription=" + issueDescription
				+ ", issueStory=" + issueStory + ", issueStatus=" + issueStatus + ", story=" + story + ", status="
				+ status + "]";
	}

		
}
