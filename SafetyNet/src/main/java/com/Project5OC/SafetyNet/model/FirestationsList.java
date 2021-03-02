package com.Project5OC.SafetyNet.model;

import java.util.List;

public class FirestationsList {

	public List<Firestation> firestations;

	public FirestationsList() {

	}

	public FirestationsList(List<Firestation> firestations) {
		super();
		this.firestations = firestations;
	}

	public List<Firestation> getFirestations() {
		return firestations;
	}

	public void setFirestations(List<Firestation> firestations) {
		this.firestations = firestations;
	}

}
