package com.Project5OC.SafetyNet.DTO.URL.Url4;

import java.util.List;

public class PersonsListUrl4Dto {

	public List<PersonUrl4Dto> persons;
	public String firestation;

	public PersonsListUrl4Dto() {
	}

	public PersonsListUrl4Dto(List<PersonUrl4Dto> persons, String firestation) {
		super();
		this.persons = persons;
		this.firestation = firestation;
	}

	public List<PersonUrl4Dto> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonUrl4Dto> persons) {
		this.persons = persons;
	}

	public String getFirestation() {
		return firestation;
	}

	public void setFirestation(String firestation) {
		this.firestation = firestation;
	}

}
