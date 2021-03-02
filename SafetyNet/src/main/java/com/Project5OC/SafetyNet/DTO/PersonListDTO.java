package com.Project5OC.SafetyNet.DTO;

import java.util.List;

public class PersonListDTO {

	public List<PersonDTO> personsDTO;

	public PersonListDTO() {
	}

	public PersonListDTO(List<PersonDTO> personsDTO) {
		super();
		this.personsDTO = personsDTO;
	}

	public List<PersonDTO> getPersonsDTO() {
		return personsDTO;
	}

	public void setPersonsDTO(List<PersonDTO> personsDTO) {
		this.personsDTO = personsDTO;
	}

}
