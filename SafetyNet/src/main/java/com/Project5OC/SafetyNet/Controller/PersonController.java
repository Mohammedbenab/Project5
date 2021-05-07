package com.Project5OC.SafetyNet.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(PersonService.class);

	@PostMapping(value = "personAdd")
	public PersonListDTO addNewPerson(@RequestBody PersonDTO personDto) {
		if (personDto != null) {
			PersonListDTO list = build.savePerson(personDto);
			if (list != null) {
				logger.info("Person was save in PersonListDTO");
				return list;
			} else
				logger.error("Person wasn't save in PersonListDTO");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;

	}

	@PutMapping(value = "personUpdate")
	public PersonListDTO updatePersonOfList(@RequestBody PersonDTO personDto) {
		if (personDto != null) {
			PersonListDTO list = build.updatePerson(personDto);
			if (list != null) {
				logger.info("Person was update in PersonListDTO");
				return list;
			} else
				logger.error("Person wasn't update in PersonListDTO");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;
	}

	@DeleteMapping(value = "personDelete")
	public PersonListDTO deletePersonOfList(@RequestBody PersonDTO personDto) {
		if (personDto != null) {
			PersonListDTO list = build.deletePerson(personDto);
			if (list != null) {
				logger.info("Person was delete in PersonListDTO");
				return list;
			} else
				logger.error("Person wasn't delete in PersonListDTO");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;
	}

}
