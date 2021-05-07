package com.Project5OC.SafetyNet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.Project5OC.SafetyNet.Controller.SafetyNetController;
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
import com.Project5OC.SafetyNet.Services.ServiceBuild;
import com.Project5OC.SafetyNet.model.PersonAllInfo;

@WebMvcTest(controllers = SafetyNetController.class)
public class SafetyNetControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ServiceBuild serviceBuild;

	@Test
	public void testGetUrl1() throws Exception {
		List<PersonUrl1Dto> personUrl1Dto = new ArrayList<PersonUrl1Dto>();
		personUrl1Dto.add(new PersonUrl1Dto("Amine", "ben", "rue de la paix", "0660606060", "20"));
		personUrl1Dto.add(new PersonUrl1Dto("Zak", "leroux", "rue des pepliers", "0704040404", "15"));
		int nbrAdults = 1;
		int nbrChildren = 1;
		PersonsListUrl1Dto personsListUrl1Dto = new PersonsListUrl1Dto(personUrl1Dto, nbrAdults, nbrChildren);

		Mockito.when(serviceBuild.getPersonsForUrl1("1")).thenReturn(personsListUrl1Dto);

		mockMvc.perform(get("/firestation")
				.param("stationNumber", "1"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.personUrl1Dto[0].firstName").value("Amine"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.personUrl1Dto[0].lastName").value("ben"));
	}

	@Test
	public void testGetUrl2() throws Exception {

		List<PersonUrl2Dto> persons = new ArrayList<PersonUrl2Dto>();
		List<PersonAllInfo> famillyMembers1 = null;
		persons.add(new PersonUrl2Dto("Hugo", "toto", "25", famillyMembers1));
		List<PersonAllInfo> famillyMembers2 = null;
		persons.add(new PersonUrl2Dto("Raph", "lelouche", "18", famillyMembers2));
		PersonsListUrl2Dto personsListUrl2Dto = new PersonsListUrl2Dto(persons);

		Mockito.when(serviceBuild.transfertObjectToUrl2("1509 Culver St")).thenReturn(personsListUrl2Dto);

		mockMvc.perform(get("/childAlert")
				.param("address", "1509 Culver St"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].firstName").value("Hugo"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].lastName").value("toto"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].age").value("25"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].famillyMembers").value(IsNull.nullValue()));
	}

	@Test
	public void testUrl3() throws Exception {
		List<PhoneNumberDTO> phoneNumbers = new ArrayList<PhoneNumberDTO>();
		phoneNumbers.add(new PhoneNumberDTO("0667676720"));
		phoneNumbers.add(new PhoneNumberDTO("0740403030"));
		PhonesListUrl3Dto phonesListUrl3Dto = new PhonesListUrl3Dto(phoneNumbers);
		Mockito.when(serviceBuild.getPhoneList("10")).thenReturn(phonesListUrl3Dto);

		mockMvc.perform(get("/phoneAlert")
				.param("firestationNumber", "10"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumbers[0].phone").value("0667676720"));
	}

	@Test
	public void testUrl4() throws Exception {

		List<PersonUrl4Dto> persons = new ArrayList<PersonUrl4Dto>();
		persons.add(new PersonUrl4Dto("Hugo", "toto", "0748758541", "25", null, null));
		persons.add(new PersonUrl4Dto("Raph", "leloup", "0658505050", "48", null, null));
		String firestation = "4";
		PersonsListUrl4Dto personsListUrl4Dto = new PersonsListUrl4Dto(persons, firestation);

		Mockito.when(serviceBuild.getPersonsListForUrl4("rue de la gare")).thenReturn(personsListUrl4Dto);

		mockMvc.perform(get("/fire")
				.param("address", "rue de la gare"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].firstName").value("Hugo"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].lastName").value("toto"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].age").value("25"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].medications").value(IsNull.nullValue()))

				.andExpect(MockMvcResultMatchers.jsonPath("$.firestation").value("4"));

	}

	@Test
	public void testUrl5() throws Exception {

		List<PersonUrl5Dto> persons = new ArrayList<PersonUrl5Dto>();
		persons.add(new PersonUrl5Dto("Hugo", "0748758541", "25", null, null, "rue de la gare"));
		persons.add(new PersonUrl5Dto("Raph", "0658505050", "48", null, null, "rue de la paix"));
		PersonsListUrl5Dto personsListUrl5Dto = new PersonsListUrl5Dto(persons);

		List<String> firestations = new ArrayList<String>();
		firestations.add("2");
		firestations.add("4");

		Mockito.when(serviceBuild.getPersonsUrl5(firestations)).thenReturn(personsListUrl5Dto);

		mockMvc.perform(get("/flood/stations")
				.param("listStationNb", "2, 4"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].lastName").value("Hugo"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].phone").value("0748758541"));

	}

	@Test
	public void testUrl6() throws Exception {

		PersonUrl6Dto personUrl6Dto = new PersonUrl6Dto("Benabdallah", "rue du marchand", "31", "rue du marchand", null,
				null);

		Mockito.when(serviceBuild.getPersonsUrl6(Mockito.anyString(), Mockito.anyString())).thenReturn(personUrl6Dto);

		mockMvc.perform(get("/personInfo")
				.param("firstName", "Hugo")
				.param("lastName", "Raph"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Benabdallah"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.age").value("31"));

	}

	@Test
	public void testUrl7() throws Exception {

		List<AddressUrl7Dto> email = new ArrayList<AddressUrl7Dto>();
		email.add(new AddressUrl7Dto("amine.benab@email.fr"));
		email.add(new AddressUrl7Dto("raph.leloup@email.fr"));
		email.add(new AddressUrl7Dto("amelie.sfry@email.fr"));

		AddressListUrl7Dto addressListUrl7Dto = new AddressListUrl7Dto(email);

		Mockito.when(serviceBuild.getPersonCitizenList(Mockito.anyString())).thenReturn(addressListUrl7Dto);

		mockMvc.perform(get("/communityEmail")
				.param("city", "Paris"))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.email[0].email").value("amine.benab@email.fr"));
	}
}
