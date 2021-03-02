package com.Project5OC.SafetyNet.model;

public class PersonAllInfo {

	public Person person;
	public Firestation firestation;
	public MedicalRecords medicalRecords;

	public PersonAllInfo() {
	}

	public PersonAllInfo(Person person, Firestation firestation, MedicalRecords medicalRecords) {
		super();
		this.person = person;
		this.firestation = firestation;
		this.medicalRecords = medicalRecords;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Firestation getFirestation() {
		return firestation;
	}

	public void setFirestation(Firestation firestation) {
		this.firestation = firestation;
	}

	public MedicalRecords getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(MedicalRecords medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

}
