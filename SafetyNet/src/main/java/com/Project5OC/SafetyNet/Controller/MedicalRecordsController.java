package com.Project5OC.SafetyNet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project5OC.SafetyNet.DTO.MedicalRecordsDTO;
import com.Project5OC.SafetyNet.DTO.MedicalRecordsListDTO;
import com.Project5OC.SafetyNet.Services.MedicalRecordsService;

@RestController
public class MedicalRecordsController {

	@Autowired
	private MedicalRecordsService build;

	@PostMapping(value = "medicalAdd")
	public MedicalRecordsListDTO addNewPerson(@RequestBody MedicalRecordsDTO medicalRecordsDTO) {
		return build.saveMedical(medicalRecordsDTO);

	}

	@PutMapping(value = "medicalUpdate")
	public MedicalRecordsListDTO updatePersonOfList(@RequestBody MedicalRecordsDTO medicalRecordsDTO) {
		return build.updateMedical(medicalRecordsDTO);
	}

	@DeleteMapping(value = "medicalDelete")
	public MedicalRecordsListDTO deletePersonOfList(@RequestBody MedicalRecordsDTO medicalRecordsDTO) {
		return build.deleteMedical(medicalRecordsDTO);
	}

}
