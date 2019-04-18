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
@Table(name="employee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="employeeid")
	private Integer employeeId;
	
	@Column(name="employeename")
	private Integer employeeName;
	
	@Column(name="employeedetails")
	private Integer employeeDetails;
	
	@Column(name="employeeprofile", insertable=false, updatable=false)
	private Integer employeeProfile;
	
	@Column(name="employeerole", insertable=false, updatable=false)
	private Integer employeerole;
	
	@Column(name="employeeinitiative", insertable=false, updatable=false)
	private Integer employeeInitiative;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="employeeinitiative")
	private Initiative initiative;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="employeeprofile")
	private EmployeeProfile profile; 
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="employeerole")
	private EmployeeRole role; 

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(Integer employeeName) {
		this.employeeName = employeeName;
	}

	public Integer getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(Integer employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	public Integer getEmployeeProfile() {
		return employeeProfile;
	}

	public void setEmployeeProfile(Integer employeeProfile) {
		this.employeeProfile = employeeProfile;
	}

	public Integer getEmployeerole() {
		return employeerole;
	}

	public void setEmployeerole(Integer employeerole) {
		this.employeerole = employeerole;
	}

	public Integer getEmployeeInitiative() {
		return employeeInitiative;
	}

	public void setEmployeeInitiative(Integer employeeInitiative) {
		this.employeeInitiative = employeeInitiative;
	}

	public Initiative getInitiative() {
		return initiative;
	}

	public void setInitiative(Initiative initiative) {
		this.initiative = initiative;
	}

	public EmployeeProfile getProfile() {
		return profile;
	}

	public void setProfile(EmployeeProfile profile) {
		this.profile = profile;
	}

	public EmployeeRole getRole() {
		return role;
	}

	public void setRole(EmployeeRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeDetails="
				+ employeeDetails + ", employeeProfile=" + employeeProfile + ", employeerole=" + employeerole
				+ ", employeeInitiative=" + employeeInitiative + ", initiative=" + initiative + ", profile=" + profile
				+ ", role=" + role + "]";
	}

	

}
