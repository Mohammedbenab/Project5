package com.Project5OC.SafetyNet.DTO.URL.Url1;

import java.util.List;

public class PersonsListUrl1Dto {

	public List<PersonUrl1Dto> personUrl1Dto;
	public int nbrAdults;
	public int nbrChildren;

	public PersonsListUrl1Dto() {
	}

	public PersonsListUrl1Dto(List<PersonUrl1Dto> personUrl1Dto, int nbrAdults, int nbrChildren) {
		super();
		this.personUrl1Dto = personUrl1Dto;
		this.nbrAdults = nbrAdults;
		this.nbrChildren = nbrChildren;
	}

	public List<PersonUrl1Dto> getPersonUrl1Dto() {
		return personUrl1Dto;
	}

	public void setPersonUrl1Dto(List<PersonUrl1Dto> personUrl1Dto) {
		this.personUrl1Dto = personUrl1Dto;
	}

	public int getNbrAdults() {
		return nbrAdults;
	}

	public void setNbrAdults(int nbrAdults) {
		this.nbrAdults = nbrAdults;
	}

	public int getNbrChildren() {
		return nbrChildren;
	}

	public void setNbrChildren(int nbrChildren) {
		this.nbrChildren = nbrChildren;
	}

}
