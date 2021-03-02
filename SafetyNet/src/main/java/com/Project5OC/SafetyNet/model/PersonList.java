package com.Project5OC.SafetyNet.model;

import java.util.List;

public class PersonList {

	public List<Person> persons;

	public PersonList() {

	}

	public PersonList(List<Person> persons) {
		super();
		this.persons = persons;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

}
