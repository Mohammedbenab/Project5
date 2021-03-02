package com.Project5OC.SafetyNet.DTO.URL.Url2;

import java.util.List;

public class PersonsListUrl2Dto {

	public List<PersonUrl2Dto> persons;

	public PersonsListUrl2Dto() {
	}

	public PersonsListUrl2Dto(List<PersonUrl2Dto> persons) {
		super();
		this.persons = persons;
	}

	public List<PersonUrl2Dto> getPersons() {
		return persons;
	}

	public void setPersons(List<PersonUrl2Dto> persons) {
		this.persons = persons;
	}

}
