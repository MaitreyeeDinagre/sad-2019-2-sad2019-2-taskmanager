package com.srhheidelberg.sad.taskmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="initiative")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Initiative {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="initiativeid")
	private Integer initiativeId;
	
	@Column(name="initiativename")
	private String initiativeName;
	
	@Column(name="initiativedescription")
	private String initiativeDesciption;

	public Integer getInitiativeId() {
		return initiativeId;
	}

	public void setInitiativeId(Integer initiativeId) {
		this.initiativeId = initiativeId;
	}

	public String getInitiativeName() {
		return initiativeName;
	}

	public void setInitiativeName(String initiativeName) {
		this.initiativeName = initiativeName;
	}

	public String getInitiativeDesciption() {
		return initiativeDesciption;
	}

	public void setInitiativeDesciption(String initiativeDesciption) {
		this.initiativeDesciption = initiativeDesciption;
	}

	@Override
	public String toString() {
		return "Initiative [initiativeId=" + initiativeId + ", initiativeName=" + initiativeName
				+ ", initiativeDesciption=" + initiativeDesciption + "]";
	}

	
	
	
	

}
