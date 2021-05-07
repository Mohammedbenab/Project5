package com.Project5OC.SafetyNet.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	Logger logger = LoggerFactory.getLogger(ServiceBuild.class);

	@GetMapping(value = "firestation")
	public PersonsListUrl1Dto getAllPersonUrl1(@RequestParam String stationNumber) {
		if (stationNumber != null) {
			PersonsListUrl1Dto list = build.getPersonsForUrl1(stationNumber);
			if (list != null) {
				logger.info("PersonsListUrl1Dto was created");
				return list;
			} else
				logger.error("PersonsListUrl1Dto wasn't created");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;
	}

	@GetMapping(value = "childAlert")
	public PersonsListUrl2Dto getAllPersonUrl2(@RequestParam String address) {
		if (address != null) {
			PersonsListUrl2Dto list = build.transfertObjectToUrl2(address);
			if (list != null) {
				logger.info("PersonsListUrl2Dto was created");
				return list;
			} else
				logger.error("PersonsListUrl2Dto wasn't created");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;
	}

	@GetMapping(value = "phoneAlert")
	public PhonesListUrl3Dto getphoneNumberAllPersonUrl2(@RequestParam String firestationNumber) {
		if (firestationNumber != null) {
			PhonesListUrl3Dto list = build.getPhoneList(firestationNumber);
			if (list != null) {
				logger.info("PhonesListUrl3Dto was created");
				return list;
			} else
				logger.error("PhonesListUrl3Dto wasn't created");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;
	}

	@GetMapping(value = "fire")
	public PersonsListUrl4Dto getAllPersonUrl4(@RequestParam String address) {
		if (address != null) {
			PersonsListUrl4Dto list = build.getPersonsListForUrl4(address);
			if (list != null) {
				logger.info("PersonsListUrl4Dto was created");
				return list;
			} else
				logger.error("PersonsListUrl4Dto wasn't created");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;
	}

	@GetMapping(value = "flood/stations")
	public PersonsListUrl5Dto getAllPersonUrl4(@RequestParam List<String> listStationNb) {
		if (listStationNb != null) {
			PersonsListUrl5Dto list = build.getPersonsUrl5(listStationNb);
			if (list != null) {
				logger.info("PersonsListUrl5Dto was created");
				return list;
			} else
				logger.error("PersonsListUrl5Dto wasn't created");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;
	}

	@GetMapping(value = "personInfo")
	public PersonUrl6Dto getPersonForDtoUrl6(@RequestParam String firstName, String lastName) {
		if (firstName != null || lastName != null) {
			PersonUrl6Dto list = build.getPersonsUrl6(firstName, lastName);
			if (list != null) {
				logger.info("PersonUrl6Dto was created");
				return list;
			} else
				logger.error("PersonUrl6Dto wasn't created");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;
	}

	@GetMapping(value = "communityEmail")
	public AddressListUrl7Dto getEmailForCitizen(@RequestParam String city) {
		if (city != null) {
			AddressListUrl7Dto list = build.getPersonCitizenList(city);
			if (list != null) {
				logger.info("AddressListUrl7Dto was created");
				return list;
			} else
				logger.error("AddressListUrl7Dto wasn't created");
			return null;
		} else
			logger.debug("Your argument isn't correct");

		return null;
	}

}
