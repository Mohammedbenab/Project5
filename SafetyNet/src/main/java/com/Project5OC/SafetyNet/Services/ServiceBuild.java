package com.Project5OC.SafetyNet.Services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project5OC.SafetyNet.DTO.URL.Url1.PersonUrl1Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url1.PersonsListUrl1Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url2.PersonUrl2Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url2.PersonsListUrl2Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url3.PhoneNumberDTO;
import com.Project5OC.SafetyNet.DTO.URL.Url3.PhonesListUrl3Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url4.PersonUrl4Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url4.PersonsListUrl4Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url5.PersonUrl5Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url5.PersonsListUrl5Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url6.PersonUrl6Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url7.AddressListUrl7Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url7.AddressUrl7Dto;
import com.Project5OC.SafetyNet.mapper.IObjectsToUrl;
import com.Project5OC.SafetyNet.mapper.IObjectsToUrlImpl;
import com.Project5OC.SafetyNet.model.Firestation;
import com.Project5OC.SafetyNet.model.MedicalRecords;
import com.Project5OC.SafetyNet.model.Person;
import com.Project5OC.SafetyNet.model.PersonAllInfo;
import com.Project5OC.SafetyNet.model.PersonsAllInfoList;

@Service
public class ServiceBuild {

	Logger logger = LoggerFactory.getLogger(ServiceBuild.class);

	@Autowired
	private ReadJsonFile readObject;

	@Autowired
	private IObjectsToUrlImpl objectsToUrlImpl;

	@Autowired
	private BeforeMapping convertString;

	public PersonsAllInfoList listOfPersonsWithAllInfo() {

		List<PersonAllInfo> list = new ArrayList<PersonAllInfo>();
		for (Person person : readObject.readPersons().getPersons())
			for (Firestation firestation : readObject.readFirestation().getFirestations())
				for (MedicalRecords medicalRecords : readObject.readMedical().getMedicalRecords()) {
					if (person.getAddress().equals(firestation.getAddress())
							&& person.getFirstName().equals(medicalRecords.getFirstName())
							&& person.getLastName().equals(medicalRecords.getLastName())) {
						Person persInf = new Person(person.getFirstName(), person.getLastName(), person.getAddress(),
								person.getCity(), person.getZip(), person.getPhone(), person.getEmail());
						Firestation firestationInf = new Firestation(firestation.getAddress(),
								firestation.getStation());
						MedicalRecords medicalInf = new MedicalRecords(medicalRecords.getFirstName(),
								medicalRecords.getLastName(), medicalRecords.getBirthdate(),
								medicalRecords.getMedications(), medicalRecords.getAllergies());
						PersonAllInfo personAllInfo = new PersonAllInfo(persInf, firestationInf, medicalInf);
						list.add(personAllInfo);
					}
				}
		PersonsAllInfoList listPersonAllInfo = new PersonsAllInfoList(list);
		logger.trace("listPersonAllInfo was created");
		return listPersonAllInfo;
	}

	public PersonsListUrl1Dto getPersonsForUrl1(String station) {
		List<PersonAllInfo> personsAllInf = this.listOfPersonsWithAllInfo().getPersonsList();
		List<PersonUrl1Dto> listUrl = new ArrayList<PersonUrl1Dto>();
		int nbrAdults = 0;
		int nbrChildren = 0;
		for (PersonAllInfo allInfPerson : personsAllInf) {
			if ((allInfPerson.getFirestation().getStation()).equals(station)) {
				PersonAllInfo personAllInfo = new PersonAllInfo(allInfPerson.getPerson(), allInfPerson.getFirestation(),
						allInfPerson.getMedicalRecords());
//				PersonUrl1Dto personUrl1Dto = IObjectsToUrl.INSTANCE.objectsToUrl1Dto(personAllInfo, convertString);
				PersonUrl1Dto personUrl1Dto = objectsToUrlImpl.objectsToUrl1Dto(personAllInfo, convertString);

				listUrl.add(personUrl1Dto);
				if (Integer.valueOf(personUrl1Dto.getAge()) >= 18) {
					nbrAdults += 1;
				} else
					nbrChildren += 1;
			}
		}
		PersonsListUrl1Dto personListUrl1Dto = new PersonsListUrl1Dto(listUrl, nbrAdults, nbrChildren);
		logger.trace("personListUrl1Dto was created");
		return personListUrl1Dto;
	}

	public PersonsListUrl2Dto transfertObjectToUrl2(String address) {
		List<PersonUrl2Dto> persons = new ArrayList<PersonUrl2Dto>();
		for (PersonAllInfo allInfPerson : this.listOfPersonsWithAllInfo().getPersonsList()) {

			if (allInfPerson.getPerson().getAddress().equals(address) && Integer.valueOf(
					convertString.calculateAge(allInfPerson.getMedicalRecords().getBirthdate())) < 18) {
				List<PersonAllInfo> familly = new ArrayList<PersonAllInfo>();
				PersonAllInfo personAllInfo = new PersonAllInfo(allInfPerson.getPerson(), allInfPerson.getFirestation(),
						allInfPerson.getMedicalRecords());
				PersonUrl2Dto personUrl2Dto = IObjectsToUrl.INSTANCE.objectToUrl2Dto(personAllInfo, convertString);
				for (PersonAllInfo allInfPerson2 : this.listOfPersonsWithAllInfo().getPersonsList()) {
					if (allInfPerson2.getPerson().getLastName().equals(personUrl2Dto.getLastName())
							&& !(allInfPerson2.getPerson().getFirstName().equals(personUrl2Dto.getFirstName()))) {
						PersonAllInfo personFamilly = new PersonAllInfo(allInfPerson2.getPerson(),
								allInfPerson2.getFirestation(), allInfPerson2.getMedicalRecords());
						familly.add(personFamilly);
					}
				}
				personUrl2Dto.setFamillyMembers(familly);
				logger.trace("Familly member was updated");
				persons.add(personUrl2Dto);
			}
		}
		PersonsListUrl2Dto personsListUrl2Dto = new PersonsListUrl2Dto(persons);
		logger.trace("personsListUrl2Dto was created");
		return personsListUrl2Dto;
	}

	public PhonesListUrl3Dto getPhoneList(String firestationNumber) {
		List<PhoneNumberDTO> persons = new ArrayList<PhoneNumberDTO>();
		for (PersonAllInfo allInfPerson : this.listOfPersonsWithAllInfo().getPersonsList()) {
			if (allInfPerson.getFirestation().getStation().equals(firestationNumber)) {
				PersonAllInfo person = new PersonAllInfo(allInfPerson.getPerson(), allInfPerson.getFirestation(),
						allInfPerson.getMedicalRecords());
				PhoneNumberDTO newPhoneDto = IObjectsToUrl.INSTANCE.numbersToUrl3Dto(person);
				persons.add(newPhoneDto);
			}
		}
		PhonesListUrl3Dto list = new PhonesListUrl3Dto(persons);
		logger.trace("List of phoen numbers was created");

		return list;

	}

	public PersonsListUrl4Dto getPersonsListForUrl4(String address) {
		List<PersonUrl4Dto> persons = new ArrayList<PersonUrl4Dto>();
		String firestationNumber = null;
		for (PersonAllInfo allInfPerson : this.listOfPersonsWithAllInfo().getPersonsList()) {
			if (allInfPerson.getFirestation().getAddress().equals(address)) {
				firestationNumber = allInfPerson.getFirestation().getStation();
				PersonAllInfo person = new PersonAllInfo(allInfPerson.getPerson(), allInfPerson.getFirestation(),
						allInfPerson.getMedicalRecords());
				PersonUrl4Dto newPhoneDto = IObjectsToUrl.INSTANCE.objectToUrl4Dto(person, convertString);
				persons.add(newPhoneDto);
			}
		}
		PersonsListUrl4Dto objectForUrl4 = new PersonsListUrl4Dto(persons, firestationNumber);

		return objectForUrl4;
	}

	public PersonsListUrl5Dto getPersonsUrl5(List<String> firestations) {
		List<PersonUrl5Dto> persons = new ArrayList<PersonUrl5Dto>();
		for (String firestation : firestations)
			for (PersonAllInfo allInfPerson : this.listOfPersonsWithAllInfo().getPersonsList()) {
				if (firestation.equals(allInfPerson.getFirestation().getStation())) {
					PersonAllInfo person = new PersonAllInfo(allInfPerson.getPerson(), allInfPerson.getFirestation(),
							allInfPerson.getMedicalRecords());
					PersonUrl5Dto personUrl5Dto = IObjectsToUrl.INSTANCE.objectToUrl5Dto(person, convertString);
					persons.add(personUrl5Dto);
				}
			}
		Collections.sort(persons);
		logger.trace("The list was sorted");
		PersonsListUrl5Dto personsListUrl5Dto = new PersonsListUrl5Dto(persons);
		logger.trace("PersonsListUrl5Dto was created");
		return personsListUrl5Dto;
	}

	public PersonUrl6Dto getPersonsUrl6(String firstName, String lastName) {
		PersonUrl6Dto personUrl6Dto = new PersonUrl6Dto();
		for (PersonAllInfo allInfPerson : this.listOfPersonsWithAllInfo().getPersonsList()) {
			if (allInfPerson.getPerson().getFirstName().equals(firstName)
					&& allInfPerson.getPerson().getLastName().equals(lastName)) {
				PersonAllInfo person = new PersonAllInfo(allInfPerson.getPerson(), allInfPerson.getFirestation(),
						allInfPerson.getMedicalRecords());
				personUrl6Dto = IObjectsToUrl.INSTANCE.objectToUrl6Dto(person, convertString);
				logger.info("personUrl6Dto exist");
			}
		}
		return personUrl6Dto;
	}

	public AddressListUrl7Dto getPersonCitizenList(String city) {
		List<AddressUrl7Dto> persons = new ArrayList<AddressUrl7Dto>();
		for (PersonAllInfo allInfPerson : this.listOfPersonsWithAllInfo().getPersonsList()) {
			if (allInfPerson.getPerson().getCity().equals(city)) {
				PersonAllInfo person = new PersonAllInfo(allInfPerson.getPerson(), allInfPerson.getFirestation(),
						allInfPerson.getMedicalRecords());
				AddressUrl7Dto personEmail = IObjectsToUrl.INSTANCE.objectToUrl7Dto(person);
				persons.add(personEmail);
			}
		}
		AddressListUrl7Dto list = new AddressListUrl7Dto(persons);
		logger.trace("List of address was created");
		return list;
	}

}
