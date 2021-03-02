package com.Project5OC.SafetyNet.DTO;

import java.util.List;

public class FirestationListDTO {

	public List<FirestationDTO> firestationDTO;

	public FirestationListDTO() {
	}

	public FirestationListDTO(List<FirestationDTO> firestationDTO) {
		super();
		this.firestationDTO = firestationDTO;
	}

	public List<FirestationDTO> getFirestationDTO() {
		return firestationDTO;
	}

	public void setFirestationDTO(List<FirestationDTO> firestationDTO) {
		this.firestationDTO = firestationDTO;
	}

}
