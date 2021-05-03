package com.Project5OC.SafetyNet.Services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project5OC.SafetyNet.DTO.PersonDTO;
import com.Project5OC.SafetyNet.DTO.PersonListDTO;
import com.Project5OC.SafetyNet.ObjectsMapper.IObjectToDtoImpl;
import com.Project5OC.SafetyNet.model.Person;
import com.Project5OC.SafetyNet.model.PersonList;

@Service
public class PersonService {

	Logger logger = LoggerFactory.getLogger(PersonService.class);

	@Autowired
	private ReadJsonFile readObject;

	@Autowired
	private IObjectToDtoImpl iObjectToDtoImpl;

	private PersonList personList;

	@PostConstruct
	private void init() {
		this.personList = readObject.readPersons();
	}

	public PersonListDTO savePerson(PersonDTO personDto) {
		Person person = iObjectToDtoImpl.dtoToPerson(personDto);
		List<Person> persons = personList.getPersons();
		int result = 0;
		for (Person personInList : persons) {
			if (personInList.getFirstName().equals(personDto.getFirstName())
					&& personInList.getLastName().equals(personDto.getLastName())) {
				result = +1;
			}
		}
		if (result == 0) {
			persons.add(person);
			logger.info("Person dos not exist in the list, she was created");
		}
		PersonList personList = new PersonList(persons);
		PersonListDTO personListDTO = iObjectToDtoImpl.personListToDtoList(personList);
		logger.trace("PersonListDTO was created");
		return personListDTO;
	}

	public PersonListDTO updatePerson(PersonDTO personDto) {
		Person person = iObjectToDtoImpl.dtoToPerson(personDto);
		List<Person> persons = personList.getPersons();
		for (Person list : persons) {
			if ((list.getFirstName().equals(person.getFirstName())
					&& list.getLastName().equals(person.getLastName()))) {
				list.setFirstName(person.getFirstName());
				list.setLastName(person.getLastName());
				list.setAddress(person.getAddress());
				list.setCity(person.getCity());
				list.setZip(person.getZip());
				list.setPhone(person.getPhone());
				list.setEmail(person.getEmail());
				logger.info("Person exist, it was updated");

			}
		}
		PersonList personList = new PersonList(persons);
		PersonListDTO personListDTO = iObjectToDtoImpl.personListToDtoList(personList);
		logger.info("PersonListDTO was updated");

		return personListDTO;
	}

	public PersonListDTO deletePerson(PersonDTO personDto) {
		Person personObj = iObjectToDtoImpl.dtoToPerson(personDto);
		List<Person> list = personList.getPersons();
		for (Person person : list) {
			if (person.getFirstName().equals(personObj.getFirstName())
					&& person.getLastName().equals(personObj.getLastName())) {
				list.remove(person);
				logger.info("Person was deleted");
			}
		}
		PersonList personListFinal = new PersonList(list);
		PersonListDTO personListDTO = iObjectToDtoImpl.personListToDtoList(personListFinal);
		logger.info("PersonListDTO was updated");

		return personListDTO;
	}

}
