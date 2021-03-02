package com.Project5OC.SafetyNet.DTO.URL.Url5;

import java.util.List;

public class PersonsListUrl5Dto {

	public List<PersonUrl5Dto> persons;

	public PersonsListUrl5Dto() {
	}

	public PersonsListUrl5Dto(List<PersonUrl5Dto> persons) {
		super();
		this.persons = persons;
	}

	public List<PersonUrl5Dto> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonUrl5Dto> persons) {
		this.persons = persons;
	}

}
