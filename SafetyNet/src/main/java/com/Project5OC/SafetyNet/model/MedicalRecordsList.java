package com.Project5OC.SafetyNet.model;

import java.util.List;

public class MedicalRecordsList {

	public List<MedicalRecords> medicalRecords;

	public MedicalRecordsList() {

	}

	public MedicalRecordsList(List<MedicalRecords> medicalRecords) {
		super();
		this.medicalRecords = medicalRecords;
	}

	public List<MedicalRecords> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecords> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

}
