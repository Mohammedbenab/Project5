package com.Project5OC.SafetyNet.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project5OC.SafetyNet.DTO.FirestationDTO;
import com.Project5OC.SafetyNet.DTO.FirestationListDTO;
import com.Project5OC.SafetyNet.Services.FirestationService;

@RestController
public class FirestationController {

	@Autowired
	private FirestationService build;

	Logger logger = LoggerFactory.getLogger(FirestationService.class);

	@PostMapping(value = "firestationAdd")
	public FirestationListDTO addNewPerson(@RequestBody FirestationDTO firestationDTO) {
		if (firestationDTO != null) {
			FirestationListDTO list = build.saveFirestation(firestationDTO);
			if (list != null) {
				logger.info("Firestation was save in FirestationListDTO");
				return list;
			} else
				logger.error("Firestation wasn't save in FirestationListDTO");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;

	}

	@PutMapping(value = "firestationUpdate")
	public FirestationListDTO updatePersonOfList(@RequestBody FirestationDTO firestationDTO) {
		if (firestationDTO != null) {
			FirestationListDTO list = build.updateFirestation(firestationDTO);
			if (list != null) {
				logger.info("Firestation was update in PersonListDTO");
				return list;
			} else
				logger.error("Firestation wasn't update in PersonListDTO");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;
	}

	@DeleteMapping(value = "firestationDelete")
	public FirestationListDTO deletePersonOfList(@RequestBody FirestationDTO firestationDTO) {
		if (firestationDTO != null) {
			FirestationListDTO list = build.deleteFirestation(firestationDTO);
			if (list != null) {
				logger.info("Firestation was delete in PersonListDTO");
				return list;
			} else
				logger.error("Firestation wasn't delete in PersonListDTO");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;
	}

}
