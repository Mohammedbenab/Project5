package com.Project5OC.SafetyNet.DTO;

import java.util.List;

public class MedicalRecordsListDTO {

	public List<MedicalRecordsDTO> medicalRecordsDTO;

	public MedicalRecordsListDTO() {
	}

	public MedicalRecordsListDTO(List<MedicalRecordsDTO> medicalRecordsDTO) {
		super();
		this.medicalRecordsDTO = medicalRecordsDTO;
	}

	public List<MedicalRecordsDTO> getMedicalRecordsDTO() {
		return medicalRecordsDTO;
	}

	public void setMedicalRecordsDTO(List<MedicalRecordsDTO> medicalRecordsDTO) {
		this.medicalRecordsDTO = medicalRecordsDTO;
	}

}
