package com.srhheidelberg.sad.taskmanager.enumRepository;

public enum EmployeeRole {
	
	Manager,
	Consultant,
	Developer,
	Tester,
	Architect;
	
	int value;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

}
