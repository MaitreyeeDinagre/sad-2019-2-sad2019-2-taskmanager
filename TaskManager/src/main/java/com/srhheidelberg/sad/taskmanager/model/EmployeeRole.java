package com.srhheidelberg.sad.taskmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="employeerole")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="employeeroleid")
	private Integer employeeroleId;
	
	@Column(name="employeerolename")
	private String employeeroleName;
	
	@Column(name="employeeroledescription")
	private String employeeroleDescription;

	public Integer getEmployeeroleId() {
		return employeeroleId;
	}

	public void setEmployeeroleId(Integer employeeroleId) {
		this.employeeroleId = employeeroleId;
	}

	public String getEmployeeroleName() {
		return employeeroleName;
	}

	public void setEmployeeroleName(String employeeroleName) {
		this.employeeroleName = employeeroleName;
	}

	public String getEmployeeroleDescription() {
		return employeeroleDescription;
	}

	public void setEmployeeroleDescription(String employeeroleDescription) {
		this.employeeroleDescription = employeeroleDescription;
	}

	@Override
	public String toString() {
		return "employeerole [employeeroleId=" + employeeroleId + ", employeeroleName=" + employeeroleName
				+ ", employeeroleDescription=" + employeeroleDescription + "]";
	}
	
	
	
	
	

}
