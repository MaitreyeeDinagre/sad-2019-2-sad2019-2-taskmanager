package com.srhheidelberg.sad.taskmanager.enumRepository;

public enum TaskType {
	
	Design,
	Development,
	UnitTesting,
	Review,
	Deployment,
	QualityAnalysis,
	SmokeTesting,
	IntegrationTesting,
	DataMigration,
	Release;
	
	int value;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

}
