package com.Project5OC.SafetyNet.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project5OC.SafetyNet.DTO.URL.Url1.PersonsListUrl1Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url2.PersonsListUrl2Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url3.PhonesListUrl3Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url4.PersonsListUrl4Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url5.PersonsListUrl5Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url6.PersonUrl6Dto;
import com.Project5OC.SafetyNet.DTO.URL.Url7.AddressListUrl7Dto;
import com.Project5OC.SafetyNet.Services.ServiceBuild;

@RestController
public class SafetyNetController {

	@Autowired
	private ServiceBuild build;

	@GetMapping(value = "firestation")
	public PersonsListUrl1Dto getAllPersonUrl1(@RequestParam String stationNumber) {
		return build.getPersonsForUrl1(stationNumber);
	}

	@GetMapping(value = "childAlert")
	public PersonsListUrl2Dto getAllPersonUrl2(@RequestParam String address) {
		return build.transfertObjectToUrl2(address);
	}

	@GetMapping(value = "phoneAlert")
	public PhonesListUrl3Dto getphoneNumberAllPersonUrl2(@RequestParam String firestationNumber) {
		return build.getPhoneList(firestationNumber);
	}

	@GetMapping(value = "fire")
	public PersonsListUrl4Dto getAllPersonUrl4(@RequestParam String address) {
		return build.getPersonsListForUrl4(address);
	}

	@GetMapping(value = "flood/stations")
	public PersonsListUrl5Dto getAllPersonUrl4(@RequestParam List<String> listStationNb) {
		return build.getPersonsUrl5(listStationNb);
	}

	@GetMapping(value = "personInfo")
	public PersonUrl6Dto getPersonForDtoUrl6(@RequestParam String firstName, String lastName) {
		return build.getPersonsUrl6(firstName, lastName);
	}

	@GetMapping(value = "communityEmail")
	public AddressListUrl7Dto getEmailForCitizen(@RequestParam String city) {
		return build.getPersonCitizenList(city);
	}

}
