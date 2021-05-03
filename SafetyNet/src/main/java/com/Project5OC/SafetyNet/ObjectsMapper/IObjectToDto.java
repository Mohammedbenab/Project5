package com.Project5OC.SafetyNet.ObjectsMapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

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

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IObjectToDto {

//	IObjectToDto INSTANCE = Mappers.getMapper(IObjectToDto.class);

	FirestationDTO firestationToDto(Firestation firestation);

	Firestation dtoToFirestation(FirestationDTO fireStationDto);

	@Mappings({
			@Mapping(target = "firestationDTO", source = "firestationsList.firestations")

	})
	FirestationListDTO firestationListToDtoList(FirestationsList firestationsList);

	@Mappings({
			@Mapping(target = "firestations", source = "firestationListDTO.firestationDTO")

	})
	FirestationsList dtoListToFirestationsList(FirestationListDTO firestationListDTO);

	MedicalRecordsDTO medicalRecordsToDto(MedicalRecords medicalRecord);

	MedicalRecords dtoToMedicalRecords(MedicalRecordsDTO medicalRecordsDto);

	@Mappings({
			@Mapping(target = "medicalRecordsDTO", source = "medicalRecordsList.medicalRecords")

	})
	MedicalRecordsListDTO medicalRecordsListToDtoList(MedicalRecordsList medicalRecordsList);

	@Mappings({
			@Mapping(target = "medicalRecords", source = "medicalRecordsListDTO.medicalRecordsDTO")

	})
	MedicalRecordsList dtoListToMedicalRecordsList(MedicalRecordsListDTO medicalRecordsListDTO);

	PersonDTO personToDto(Person person);

	Person dtoToPerson(PersonDTO personDto);

	@Mappings({
			@Mapping(target = "personsDTO", source = "personList.persons")

	})
	PersonListDTO personListToDtoList(PersonList personList);

	@Mappings({
			@Mapping(target = "persons", source = "personListDTO.personsDTO")

	})
	PersonList dtoListToPersonList(PersonListDTO personListDTO);

	PersonAllInfoDTO personAllInfoToPersonAllDTO(PersonAllInfo personAllInfo);

	PersonAllInfo personAllDtoToPersonAllInfo(PersonAllInfoDTO personAllInfoDTO);

	@Mappings({
			@Mapping(target = "personAllInfoDTO", source = "personAllInfoList.personsList")

	})
	PersonAllInfoListDTO allInfoListToAllInfoDtoList(PersonsAllInfoList personAllInfoList);

	@Mappings({
			@Mapping(target = "personsList", source = "personAllInfoListDTO.personAllInfoDTO")

	})
	PersonsAllInfoList allInfoDtoListToAllInfoList(PersonAllInfoListDTO personAllInfoListDTO);

}
