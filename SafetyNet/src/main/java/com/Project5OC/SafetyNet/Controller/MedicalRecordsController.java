package com.Project5OC.SafetyNet.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(MedicalRecordsService.class);

	@PostMapping(value = "medicalAdd")
	public MedicalRecordsListDTO addNewPerson(@RequestBody MedicalRecordsDTO medicalRecordsDTO) {
		if (medicalRecordsDTO != null) {
			MedicalRecordsListDTO list = build.saveMedical(medicalRecordsDTO);
			if (list != null) {
				logger.info("MedicalRecords was save in MedicalRecordsListDTO");
				return list;
			} else
				logger.error("MedicalRecords wasn't save in MedicalRecordsListDTO");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;
	}

	@PutMapping(value = "medicalUpdate")
	public MedicalRecordsListDTO updatePersonOfList(@RequestBody MedicalRecordsDTO medicalRecordsDTO) {
		if (medicalRecordsDTO != null) {
			MedicalRecordsListDTO list = build.updateMedical(medicalRecordsDTO);
			if (list != null) {
				logger.info("MedicalRecords was update in MedicalRecordsListDTO");
				return list;
			} else
				logger.error("MedicalRecords wasn't update in MedicalRecordsListDTO");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;
	}

	@DeleteMapping(value = "medicalDelete")
	public MedicalRecordsListDTO deletePersonOfList(@RequestBody MedicalRecordsDTO medicalRecordsDTO) {
		if (medicalRecordsDTO != null) {
			MedicalRecordsListDTO list = build.deleteMedical(medicalRecordsDTO);
			if (list != null) {
				logger.info("MedicalRecords was delete in MedicalRecordsListDTO");
				return list;
			} else
				logger.error("MedicalRecords wasn't delete in MedicalRecordsListDTO");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;
	}

}
