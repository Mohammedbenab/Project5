package com.Project5OC.SafetyNet.model;

import java.util.List;

public class PersonsAllInfoList {

	public List<PersonAllInfo> personsList;

	public PersonsAllInfoList() {

	}

	public PersonsAllInfoList(List<PersonAllInfo> personsList) {
		super();
		this.personsList = personsList;
	}

	public List<PersonAllInfo> getPersonsList() {
		return personsList;
	}

	public void setPersonsList(List<PersonAllInfo> personsList) {
		this.personsList = personsList;
	}

}
