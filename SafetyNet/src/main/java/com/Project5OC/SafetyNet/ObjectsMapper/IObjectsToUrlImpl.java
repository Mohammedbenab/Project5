package com.Project5OC.SafetyNet.ObjectsMapper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.Project5OC.SafetyNet.DTO.URL.Url1.PersonUrl1Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url2.PersonUrl2Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url3.PhoneNumberDTO;
import com.Project5OC.SafetyNet.DTO.URL.Url4.PersonUrl4Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url5.PersonUrl5Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url6.PersonUrl6Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url7.AddressUrl7Dto;
import com.Project5OC.SafetyNet.Services.BeforeMapping;
import com.Project5OC.SafetyNet.model.MedicalRecords;
import com.Project5OC.SafetyNet.model.Person;
import com.Project5OC.SafetyNet.model.PersonAllInfo;

@Generated(value = "org.mapstruct.ap.MappingProcessor", date = "2021-04-21T18:35:11+0200", comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)")
@Component
public class IObjectsToUrlImpl implements IObjectsToUrl {

	@Override
	public PersonUrl1Dto objectsToUrl1Dto(PersonAllInfo personAllInfo, BeforeMapping convert) {
		if (personAllInfo == null && convert == null) {
			return null;
		}

		PersonUrl1Dto personUrl1Dto = new PersonUrl1Dto();

		if (personAllInfo != null) {
			personUrl1Dto.setFirstName(personAllInfoPersonFirstName(personAllInfo));
			personUrl1Dto.setLastName(personAllInfoPersonLastName(personAllInfo));
			personUrl1Dto.setAddress(personAllInfoPersonAddress(personAllInfo));
			personUrl1Dto.setPhone(personAllInfoPersonPhone(personAllInfo));
		}
		personUrl1Dto.setAge(convert.calculateAge(personAllInfo.medicalRecords.birthdate));

		return personUrl1Dto;
	}

	@Override
	public PersonUrl2Dto objectToUrl2Dto(PersonAllInfo personAllInfo, BeforeMapping convert) {
		if (personAllInfo == null && convert == null) {
			return null;
		}

		PersonUrl2Dto personUrl2Dto = new PersonUrl2Dto();

		if (personAllInfo != null) {
			personUrl2Dto.setFirstName(personAllInfoPersonFirstName(personAllInfo));
			personUrl2Dto.setLastName(personAllInfoPersonLastName(personAllInfo));
		}
		personUrl2Dto.setAge(convert.calculateAge(personAllInfo.medicalRecords.birthdate));

		return personUrl2Dto;
	}

	@Override
	public PhoneNumberDTO numbersToUrl3Dto(PersonAllInfo personAllInfo) {
		if (personAllInfo == null) {
			return null;
		}

		PhoneNumberDTO phoneNumberDTO = new PhoneNumberDTO();

		phoneNumberDTO.setPhone(personAllInfoPersonPhone(personAllInfo));

		return phoneNumberDTO;
	}

	@Override
	public PersonUrl4Dto objectToUrl4Dto(PersonAllInfo personAllInfo, BeforeMapping convert) {
		if (personAllInfo == null && convert == null) {
			return null;
		}

		PersonUrl4Dto personUrl4Dto = new PersonUrl4Dto();

		if (personAllInfo != null) {
			personUrl4Dto.setFirstName(personAllInfoPersonFirstName(personAllInfo));
			personUrl4Dto.setLastName(personAllInfoPersonLastName(personAllInfo));
			personUrl4Dto.setPhone(personAllInfoPersonPhone(personAllInfo));
			List<String> medications = personAllInfoMedicalRecordsMedications(personAllInfo);
			List<String> list = medications;
			if (list != null) {
				personUrl4Dto.setMedications(new ArrayList<String>(list));
			}
			List<String> allergies = personAllInfoMedicalRecordsAllergies(personAllInfo);
			List<String> list1 = allergies;
			if (list1 != null) {
				personUrl4Dto.setAllergies(new ArrayList<String>(list1));
			}
		}
		personUrl4Dto.setAge(convert.calculateAge(personAllInfo.medicalRecords.birthdate));

		return personUrl4Dto;
	}

	@Override
	public PersonUrl5Dto objectToUrl5Dto(PersonAllInfo personAllInfo, BeforeMapping convert) {
		if (personAllInfo == null && convert == null) {
			return null;
		}

		String lastName = null;
		String phone = null;
		String address = null;
		List<String> medications = null;
		List<String> allergies = null;
		if (personAllInfo != null) {
			lastName = personAllInfoPersonLastName(personAllInfo);
			phone = personAllInfoPersonPhone(personAllInfo);
			address = personAllInfoPersonAddress(personAllInfo);
			List<String> medications1 = personAllInfoMedicalRecordsMedications(personAllInfo);
			List<String> list = medications1;
			if (list != null) {
				medications = new ArrayList<String>(list);
			}
			List<String> allergies1 = personAllInfoMedicalRecordsAllergies(personAllInfo);
			List<String> list1 = allergies1;
			if (list1 != null) {
				allergies = new ArrayList<String>(list1);
			}
		}

		String age = convert.calculateAge(personAllInfo.medicalRecords.birthdate);

		PersonUrl5Dto personUrl5Dto = new PersonUrl5Dto(lastName, phone, age, medications, allergies, address);

		return personUrl5Dto;
	}

	@Override
	public PersonUrl6Dto objectToUrl6Dto(PersonAllInfo personAllInfo, BeforeMapping convert) {
		if (personAllInfo == null && convert == null) {
			return null;
		}

		PersonUrl6Dto personUrl6Dto = new PersonUrl6Dto();

		if (personAllInfo != null) {
			personUrl6Dto.setLastName(personAllInfoPersonLastName(personAllInfo));
			personUrl6Dto.setEmail(personAllInfoPersonEmail(personAllInfo));
			personUrl6Dto.setAddress(personAllInfoPersonAddress(personAllInfo));
			List<String> medications = personAllInfoMedicalRecordsMedications(personAllInfo);
			List<String> list = medications;
			if (list != null) {
				personUrl6Dto.setMedications(new ArrayList<String>(list));
			}
			List<String> allergies = personAllInfoMedicalRecordsAllergies(personAllInfo);
			List<String> list1 = allergies;
			if (list1 != null) {
				personUrl6Dto.setAllergies(new ArrayList<String>(list1));
			}
		}
		personUrl6Dto.setAge(convert.calculateAge(personAllInfo.medicalRecords.birthdate));

		return personUrl6Dto;
	}

	@Override
	public AddressUrl7Dto objectToUrl7Dto(PersonAllInfo personAllInfo) {
		if (personAllInfo == null) {
			return null;
		}

		AddressUrl7Dto addressUrl7Dto = new AddressUrl7Dto();

		addressUrl7Dto.setEmail(personAllInfoPersonEmail(personAllInfo));

		return addressUrl7Dto;
	}

	private String personAllInfoPersonFirstName(PersonAllInfo personAllInfo) {
		if (personAllInfo == null) {
			return null;
		}
		Person person = personAllInfo.getPerson();
		if (person == null) {
			return null;
		}
		String firstName = person.getFirstName();
		if (firstName == null) {
			return null;
		}
		return firstName;
	}

	private String personAllInfoPersonLastName(PersonAllInfo personAllInfo) {
		if (personAllInfo == null) {
			return null;
		}
		Person person = personAllInfo.getPerson();
		if (person == null) {
			return null;
		}
		String lastName = person.getLastName();
		if (lastName == null) {
			return null;
		}
		return lastName;
	}

	private String personAllInfoPersonAddress(PersonAllInfo personAllInfo) {
		if (personAllInfo == null) {
			return null;
		}
		Person person = personAllInfo.getPerson();
		if (person == null) {
			return null;
		}
		String address = person.getAddress();
		if (address == null) {
			return null;
		}
		return address;
	}

	private String personAllInfoPersonPhone(PersonAllInfo personAllInfo) {
		if (personAllInfo == null) {
			return null;
		}
		Person person = personAllInfo.getPerson();
		if (person == null) {
			return null;
		}
		String phone = person.getPhone();
		if (phone == null) {
			return null;
		}
		return phone;
	}

	private List<String> personAllInfoMedicalRecordsMedications(PersonAllInfo personAllInfo) {
		if (personAllInfo == null) {
			return null;
		}
		MedicalRecords medicalRecords = personAllInfo.getMedicalRecords();
		if (medicalRecords == null) {
			return null;
		}
		List<String> medications = medicalRecords.getMedications();
		if (medications == null) {
			return null;
		}
		return medications;
	}

	private List<String> personAllInfoMedicalRecordsAllergies(PersonAllInfo personAllInfo) {
		if (personAllInfo == null) {
			return null;
		}
		MedicalRecords medicalRecords = personAllInfo.getMedicalRecords();
		if (medicalRecords == null) {
			return null;
		}
		List<String> allergies = medicalRecords.getAllergies();
		if (allergies == null) {
			return null;
		}
		return allergies;
	}

	private String personAllInfoPersonEmail(PersonAllInfo personAllInfo) {
		if (personAllInfo == null) {
			return null;
		}
		Person person = personAllInfo.getPerson();
		if (person == null) {
			return null;
		}
		String email = person.getEmail();
		if (email == null) {
			return null;
		}
		return email;
	}
}
