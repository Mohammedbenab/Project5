package com.Project5OC.SafetyNet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project5OC.SafetyNet.DTO.FirestationDTO;
import com.Project5OC.SafetyNet.DTO.FirestationListDTO;
import com.Project5OC.SafetyNet.Services.FirestationService;
import com.Project5OC.SafetyNet.model.Firestation;

@RestController
public class FirestationController {

	@Autowired
	private FirestationService build;

	@PostMapping(value = "firestationAdd")
	public FirestationListDTO addNewPerson(@RequestBody FirestationDTO firestationDTO) {
		return build.saveFirestation(firestationDTO);

	}

	/**
	 * test function for looking for problem in my method
	 * 
	 * @param firestation
	 * @return
	 */
	@PostMapping(value = "testPost")
	public Firestation testLaMethodPost(@RequestBody Firestation firestation) {
		return firestation;
	}

	@PutMapping(value = "firestationUpdate")
	public FirestationListDTO updatePersonOfList(@RequestBody FirestationDTO firestationDTO) {
		return build.updateFirestation(firestationDTO);
	}

	@DeleteMapping(value = "firestationDelete")
	public FirestationListDTO deletePersonOfList(@RequestBody FirestationDTO firestationDTO) {
		return build.deleteFirestation(firestationDTO);
	}

}
