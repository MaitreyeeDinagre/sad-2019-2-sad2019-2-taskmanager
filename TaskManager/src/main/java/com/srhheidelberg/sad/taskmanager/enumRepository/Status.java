package com.srhheidelberg.sad.taskmanager.enumRepository;

public enum Status {

	Started,
	InProgress,
	Completed,
	Rejected,
	NotStarted;
	
	int value;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
	
}
