package com.Project5OC.SafetyNet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project5OC.SafetyNet.DTO.PersonDTO;
import com.Project5OC.SafetyNet.DTO.PersonListDTO;
import com.Project5OC.SafetyNet.Services.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService build;

	@PostMapping(value = "personAdd")
	public PersonListDTO addNewPerson(@RequestBody PersonDTO personDto) {
		return build.savePerson(personDto);

	}

	@PutMapping(value = "personUpdate")
	public PersonListDTO updatePersonOfList(@RequestBody PersonDTO personDto) {
		return build.updatePerson(personDto);
	}

	@DeleteMapping(value = "personDelete")
	public PersonListDTO deletePersonOfList(@RequestBody PersonDTO personDto) {
		return build.deletePerson(personDto);
	}

}
