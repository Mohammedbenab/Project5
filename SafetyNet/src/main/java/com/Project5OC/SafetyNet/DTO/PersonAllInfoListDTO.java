package com.Project5OC.SafetyNet.DTO;

import java.util.List;

public class PersonAllInfoListDTO {

	public List<PersonAllInfoDTO> personAllInfoDTO;

	public PersonAllInfoListDTO() {
	}

	public PersonAllInfoListDTO(List<PersonAllInfoDTO> personAllInfoDTO) {
		super();
		this.personAllInfoDTO = personAllInfoDTO;
	}

	public List<PersonAllInfoDTO> getPersonAllInfoDTO() {
		return personAllInfoDTO;
	}

	public void setPersonAllInfoDTO(List<PersonAllInfoDTO> personAllInfoDTO) {
		this.personAllInfoDTO = personAllInfoDTO;
	}

}
