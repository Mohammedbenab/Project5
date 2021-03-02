package com.Project5OC.SafetyNet.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Service;

import com.Project5OC.SafetyNet.DTO.FirestationDTO;
import com.Project5OC.SafetyNet.DTO.FirestationListDTO;
import com.Project5OC.SafetyNet.DTO.MedicalRecordsDTO;
import com.Project5OC.SafetyNet.DTO.MedicalRecordsListDTO;
import com.Project5OC.SafetyNet.DTO.PersonAllInfoDTO;
import com.Project5OC.SafetyNet.DTO.PersonAllInfoListDTO;
import com.Project5OC.SafetyNet.DTO.PersonDTO;
import com.Project5OC.SafetyNet.DTO.PersonListDTO;
import com.Project5OC.SafetyNet.model.Firestation;
import com.Project5OC.SafetyNet.model.FirestationsList;
import com.Project5OC.SafetyNet.model.MedicalRecords;
import com.Project5OC.SafetyNet.model.MedicalRecordsList;
import com.Project5OC.SafetyNet.model.Person;
import com.Project5OC.SafetyNet.model.PersonAllInfo;
import com.Project5OC.SafetyNet.model.PersonList;
import com.Project5OC.SafetyNet.model.PersonsAllInfoList;

@Generated(value = "org.mapstruct.ap.MappingProcessor", date = "2021-01-18T18:38:07+0100", comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)")
@Service
public class IObjectToDtoImpl implements IObjectToDto {

	@Override
	public FirestationDTO firestationToDto(Firestation firestation) {
		if (firestation == null) {
			return null;
		}

		FirestationDTO firestationDTO = new FirestationDTO();

		firestationDTO.setAddress(firestation.getAddress());
		firestationDTO.setStation(firestation.getStation());

		return firestationDTO;
	}

	@Override
	public Firestation dtoToFirestation(FirestationDTO fireStationDto) {
		if (fireStationDto == null) {
			return null;
		}

		Firestation firestation = new Firestation();

		firestation.setAddress(fireStationDto.getAddress());
		firestation.setStation(fireStationDto.getStation());

		return firestation;
	}

	@Override
	public FirestationListDTO firestationListToDtoList(FirestationsList firestationsList) {
		if (firestationsList == null) {
			return null;
		}

		FirestationListDTO firestationListDTO = new FirestationListDTO();

		firestationListDTO.setFirestationDTO(firestationListToFirestationDTOList(firestationsList.getFirestations()));

		return firestationListDTO;
	}

	@Override
	public FirestationsList dtoListToFirestationsList(FirestationListDTO firestationListDTO) {
		if (firestationListDTO == null) {
			return null;
		}

		List<Firestation> firestations = null;

		firestations = firestationDTOListToFirestationList(firestationListDTO.getFirestationDTO());

		FirestationsList firestationsList = new FirestationsList(firestations);

		return firestationsList;
	}

	@Override
	public MedicalRecordsDTO medicalRecordsToDto(MedicalRecords medicalRecord) {
		if (medicalRecord == null) {
			return null;
		}

		MedicalRecordsDTO medicalRecordsDTO = new MedicalRecordsDTO();

		medicalRecordsDTO.setFirstName(medicalRecord.getFirstName());
		medicalRecordsDTO.setLastName(medicalRecord.getLastName());
		medicalRecordsDTO.setBirthdate(medicalRecord.getBirthdate());
		List<String> list = medicalRecord.getMedications();
		if (list != null) {
			medicalRecordsDTO.setMedications(new ArrayList<String>(list));
		}
		List<String> list1 = medicalRecord.getAllergies();
		if (list1 != null) {
			medicalRecordsDTO.setAllergies(new ArrayList<String>(list1));
		}

		return medicalRecordsDTO;
	}

	@Override
	public MedicalRecords dtoToMedicalRecords(MedicalRecordsDTO medicalRecordsDto) {
		if (medicalRecordsDto == null) {
			return null;
		}

		MedicalRecords medicalRecords = new MedicalRecords();

		medicalRecords.setFirstName(medicalRecordsDto.getFirstName());
		medicalRecords.setLastName(medicalRecordsDto.getLastName());
		medicalRecords.setBirthdate(medicalRecordsDto.getBirthdate());
		List<String> list = medicalRecordsDto.getMedications();
		if (list != null) {
			medicalRecords.setMedications(new ArrayList<String>(list));
		}
		List<String> list1 = medicalRecordsDto.getAllergies();
		if (list1 != null) {
			medicalRecords.setAllergies(new ArrayList<String>(list1));
		}

		return medicalRecords;
	}

	@Override
	public MedicalRecordsListDTO medicalRecordsListToDtoList(MedicalRecordsList medicalRecordsList) {
		if (medicalRecordsList == null) {
			return null;
		}

		MedicalRecordsListDTO medicalRecordsListDTO = new MedicalRecordsListDTO();

		medicalRecordsListDTO.setMedicalRecordsDTO(
				medicalRecordsListToMedicalRecordsDTOList(medicalRecordsList.getMedicalRecords()));

		return medicalRecordsListDTO;
	}

	@Override
	public MedicalRecordsList dtoListToMedicalRecordsList(MedicalRecordsListDTO medicalRecordsListDTO) {
		if (medicalRecordsListDTO == null) {
			return null;
		}

		List<MedicalRecords> medicalRecords = null;

		medicalRecords = medicalRecordsDTOListToMedicalRecordsList(medicalRecordsListDTO.getMedicalRecordsDTO());

		MedicalRecordsList medicalRecordsList = new MedicalRecordsList(medicalRecords);

		return medicalRecordsList;
	}

	@Override
	public PersonDTO personToDto(Person person) {
		if (person == null) {
			return null;
		}

		PersonDTO personDTO = new PersonDTO();

		personDTO.setFirstName(person.getFirstName());
		personDTO.setLastName(person.getLastName());
		personDTO.setAddress(person.getAddress());
		personDTO.setCity(person.getCity());
		personDTO.setZip(person.getZip());
		personDTO.setPhone(person.getPhone());
		personDTO.setEmail(person.getEmail());

		return personDTO;
	}

	@Override
	public Person dtoToPerson(PersonDTO personDto) {
		if (personDto == null) {
			return null;
		}

		Person person = new Person();

		person.setFirstName(personDto.getFirstName());
		person.setLastName(personDto.getLastName());
		person.setAddress(personDto.getAddress());
		person.setCity(personDto.getCity());
		person.setZip(personDto.getZip());
		person.setPhone(personDto.getPhone());
		person.setEmail(personDto.getEmail());

		return person;
	}

	@Override
	public PersonListDTO personListToDtoList(PersonList personList) {
		if (personList == null) {
			return null;
		}

		PersonListDTO personListDTO = new PersonListDTO();

		personListDTO.setPersonsDTO(personListToPersonDTOList(personList.getPersons()));

		return personListDTO;
	}

	@Override
	public PersonList dtoListToPersonList(PersonListDTO personListDTO) {
		if (personListDTO == null) {
			return null;
		}

		List<Person> persons = null;

		persons = personDTOListToPersonList(personListDTO.getPersonsDTO());

		PersonList personList = new PersonList(persons);

		return personList;
	}

	@Override
	public PersonAllInfoDTO personAllInfoToPersonAllDTO(PersonAllInfo personAllInfo) {
		if (personAllInfo == null) {
			return null;
		}

		PersonAllInfoDTO personAllInfoDTO = new PersonAllInfoDTO();

		personAllInfoDTO.setPerson(personAllInfo.getPerson());
		personAllInfoDTO.setFirestation(personAllInfo.getFirestation());
		personAllInfoDTO.setMedicalRecords(personAllInfo.getMedicalRecords());

		return personAllInfoDTO;
	}

	@Override
	public PersonAllInfo personAllDtoToPersonAllInfo(PersonAllInfoDTO personAllInfoDTO) {
		if (personAllInfoDTO == null) {
			return null;
		}

		PersonAllInfo personAllInfo = new PersonAllInfo();

		personAllInfo.setPerson(personAllInfoDTO.getPerson());
		personAllInfo.setFirestation(personAllInfoDTO.getFirestation());
		personAllInfo.setMedicalRecords(personAllInfoDTO.getMedicalRecords());

		return personAllInfo;
	}

	@Override
	public PersonAllInfoListDTO allInfoListToAllInfoDtoList(PersonsAllInfoList personAllInfoList) {
		if (personAllInfoList == null) {
			return null;
		}

		PersonAllInfoListDTO personAllInfoListDTO = new PersonAllInfoListDTO();

		personAllInfoListDTO
				.setPersonAllInfoDTO(personAllInfoListToPersonAllInfoDTOList(personAllInfoList.getPersonsList()));

		return personAllInfoListDTO;
	}

	@Override
	public PersonsAllInfoList allInfoDtoListToAllInfoList(PersonAllInfoListDTO personAllInfoListDTO) {
		if (personAllInfoListDTO == null) {
			return null;
		}

		List<PersonAllInfo> personsList = null;

		personsList = personAllInfoDTOListToPersonAllInfoList(personAllInfoListDTO.getPersonAllInfoDTO());

		PersonsAllInfoList personsAllInfoList = new PersonsAllInfoList(personsList);

		return personsAllInfoList;
	}

	protected List<FirestationDTO> firestationListToFirestationDTOList(List<Firestation> list) {
		if (list == null) {
			return null;
		}

		List<FirestationDTO> list1 = new ArrayList<FirestationDTO>(list.size());
		for (Firestation firestation : list) {
			list1.add(firestationToDto(firestation));
		}

		return list1;
	}

	protected List<Firestation> firestationDTOListToFirestationList(List<FirestationDTO> list) {
		if (list == null) {
			return null;
		}

		List<Firestation> list1 = new ArrayList<Firestation>(list.size());
		for (FirestationDTO firestationDTO : list) {
			list1.add(dtoToFirestation(firestationDTO));
		}

		return list1;
	}

	protected List<MedicalRecordsDTO> medicalRecordsListToMedicalRecordsDTOList(List<MedicalRecords> list) {
		if (list == null) {
			return null;
		}

		List<MedicalRecordsDTO> list1 = new ArrayList<MedicalRecordsDTO>(list.size());
		for (MedicalRecords medicalRecords : list) {
			list1.add(medicalRecordsToDto(medicalRecords));
		}

		return list1;
	}

	protected List<MedicalRecords> medicalRecordsDTOListToMedicalRecordsList(List<MedicalRecordsDTO> list) {
		if (list == null) {
			return null;
		}

		List<MedicalRecords> list1 = new ArrayList<MedicalRecords>(list.size());
		for (MedicalRecordsDTO medicalRecordsDTO : list) {
			list1.add(dtoToMedicalRecords(medicalRecordsDTO));
		}

		return list1;
	}

	protected List<PersonDTO> personListToPersonDTOList(List<Person> list) {
		if (list == null) {
			return null;
		}

		List<PersonDTO> list1 = new ArrayList<PersonDTO>(list.size());
		for (Person person : list) {
			list1.add(personToDto(person));
		}

		return list1;
	}

	protected List<Person> personDTOListToPersonList(List<PersonDTO> list) {
		if (list == null) {
			return null;
		}

		List<Person> list1 = new ArrayList<Person>(list.size());
		for (PersonDTO personDTO : list) {
			list1.add(dtoToPerson(personDTO));
		}

		return list1;
	}

	protected List<PersonAllInfoDTO> personAllInfoListToPersonAllInfoDTOList(List<PersonAllInfo> list) {
		if (list == null) {
			return null;
		}

		List<PersonAllInfoDTO> list1 = new ArrayList<PersonAllInfoDTO>(list.size());
		for (PersonAllInfo personAllInfo : list) {
			list1.add(personAllInfoToPersonAllDTO(personAllInfo));
		}

		return list1;
	}

	protected List<PersonAllInfo> personAllInfoDTOListToPersonAllInfoList(List<PersonAllInfoDTO> list) {
		if (list == null) {
			return null;
		}

		List<PersonAllInfo> list1 = new ArrayList<PersonAllInfo>(list.size());
		for (PersonAllInfoDTO personAllInfoDTO : list) {
			list1.add(personAllDtoToPersonAllInfo(personAllInfoDTO));
		}

		return list1;
	}
}
