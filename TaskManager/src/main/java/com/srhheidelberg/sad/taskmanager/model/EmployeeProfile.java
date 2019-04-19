package com.srhheidelberg.sad.taskmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="employeeprofile")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class EmployeeProfile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="employeeprofileid")
	private Integer employeeProfileId;
	
	@Column(name="employeeprofilename")
	private String employeeProfileName;
	
	@Column(name="employeeprofiledescription")
	private String employeeProfileDescription;

	public Integer getEmployeeProfileId() {
		return employeeProfileId;
	}

	public String getEmployeeProfileName() {
		return employeeProfileName;
	}

	public String getEmployeeProfileDescription() {
		return employeeProfileDescription;
	}

	public void setEmployeeProfileId(Integer employeeProfileId) {
		this.employeeProfileId = employeeProfileId;
	}

	public void setEmployeeProfileName(String employeeProfileName) {
		this.employeeProfileName = employeeProfileName;
	}

	public void setEmployeeProfileDescription(String employeeProfileDescription) {
		this.employeeProfileDescription = employeeProfileDescription;
	}

	@Override
	public String toString() {
		return "EmployeeProfile [employeeProfileId=" + employeeProfileId + ", employeeProfileName="
				+ employeeProfileName + ", employeeProfileDescription=" + employeeProfileDescription + "]";
	}
}
