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
@Table(name="epic")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Epic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="epicid")
	private Integer epicId;
	
	@Column(name="epicname")
	private Integer epicName;
	
	@Column(name="epicdescription")
	private Integer epicDescription;
	
	@Column(name="epicinitiative", insertable=false, updatable=false)
	private Integer epicInitiative;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="epicinitiative")
	private Initiative initiative;

	public Integer getEpicId() {
		return epicId;
	}

	public void setEpicId(Integer epicId) {
		this.epicId = epicId;
	}

	public Integer getEpicName() {
		return epicName;
	}

	public void setEpicName(Integer epicName) {
		this.epicName = epicName;
	}

	public Integer getEpicDescription() {
		return epicDescription;
	}

	public void setEpicDescription(Integer epicDescription) {
		this.epicDescription = epicDescription;
	}

	public Integer getEpicInitiative() {
		return epicInitiative;
	}

	public void setEpicInitiative(Integer epicInitiative) {
		this.epicInitiative = epicInitiative;
	}

	public Initiative getInitiative() {
		return initiative;
	}

	public void setInitiative(Initiative initiative) {
		this.initiative = initiative;
	}

	@Override
	public String toString() {
		return "Epic [epicId=" + epicId + ", epicName=" + epicName + ", epicDescription=" + epicDescription
				+ ", epicInitiative=" + epicInitiative + ", initiative=" + initiative + "]";
	}

	
	

}

