package com.Project5OC.SafetyNet.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.Project5OC.SafetyNet.DTO.URL.Url1.PersonUrl1Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url2.PersonUrl2Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url3.PhoneNumberDTO;
import com.Project5OC.SafetyNet.DTO.URL.Url4.PersonUrl4Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url5.PersonUrl5Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url6.PersonUrl6Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url7.AddressUrl7Dto;
import com.Project5OC.SafetyNet.Services.BeforeMapping;
import com.Project5OC.SafetyNet.model.PersonAllInfo;

@Mapper(imports = BeforeMapping.class)
@Service
public interface IObjectsToUrl {

	IObjectsToUrl INSTANCE = Mappers.getMapper(IObjectsToUrl.class);

	@Mappings({
			@Mapping(target = "firstName", source = "personAllInfo.person.firstName"),
			@Mapping(target = "lastName", source = "personAllInfo.person.lastName"),
			@Mapping(target = "address", source = "personAllInfo.person.address"),
			@Mapping(target = "phone", source = "personAllInfo.person.phone"),
			@Mapping(target = "age", expression = "java(convert.calculateAge(personAllInfo.medicalRecords.birthdate)")
	})
	PersonUrl1Dto objectsToUrl1Dto(PersonAllInfo personAllInfo, BeforeMapping convert);

	@Mappings({
			@Mapping(target = "firstName", source = "personAllInfo.person.firstName"),
			@Mapping(target = "lastName", source = "personAllInfo.person.lastName"),
			@Mapping(target = "age", expression = "java(convert.calculateAge(personAllInfo.medicalRecords.birthdate)")

	})
	PersonUrl2Dto objectToUrl2Dto(PersonAllInfo personAllInfo, BeforeMapping convert);

	@Mappings({
			@Mapping(target = "phone", source = "personAllInfo.person.phone")
	})
	PhoneNumberDTO numbersToUrl3Dto(PersonAllInfo personAllInfo);

	@Mappings({
			@Mapping(target = "firstName", source = "personAllInfo.person.firstName"),
			@Mapping(target = "lastName", source = "personAllInfo.person.lastName"),
			@Mapping(target = "age", expression = "java(convert.calculateAge(personAllInfo.medicalRecords.birthdate)"),
			@Mapping(target = "phone", source = "personAllInfo.person.phone"),
			@Mapping(target = "medications", source = "personAllInfo.medicalRecords.medications"),
			@Mapping(target = "allergies", source = "personAllInfo.medicalRecords.allergies")

	})
	PersonUrl4Dto objectToUrl4Dto(PersonAllInfo personAllInfo, BeforeMapping convert);

	@Mappings({
			@Mapping(target = "lastName", source = "personAllInfo.person.lastName"),
			@Mapping(target = "age", expression = "java(convert.calculateAge(personAllInfo.medicalRecords.birthdate)"),
			@Mapping(target = "phone", source = "personAllInfo.person.phone"),
			@Mapping(target = "address", source = "personAllInfo.person.address"),
			@Mapping(target = "medications", source = "personAllInfo.medicalRecords.medications"),
			@Mapping(target = "allergies", source = "personAllInfo.medicalRecords.allergies")

	})
	PersonUrl5Dto objectToUrl5Dto(PersonAllInfo personAllInfo, BeforeMapping convert);

	@Mappings({
			@Mapping(target = "lastName", source = "personAllInfo.person.lastName"),
			@Mapping(target = "age", expression = "java(convert.calculateAge(personAllInfo.medicalRecords.birthdate)"),
			@Mapping(target = "email", source = "personAllInfo.person.email"),
			@Mapping(target = "address", source = "personAllInfo.person.address"),
			@Mapping(target = "medications", source = "personAllInfo.medicalRecords.medications"),
			@Mapping(target = "allergies", source = "personAllInfo.medicalRecords.allergies")

	})
	PersonUrl6Dto objectToUrl6Dto(PersonAllInfo personAllInfo, BeforeMapping convert);

	@Mappings({
			@Mapping(target = "email", source = "personAllInfo.person.email")
	})
	AddressUrl7Dto objectToUrl7Dto(PersonAllInfo personAllInfo);

}
