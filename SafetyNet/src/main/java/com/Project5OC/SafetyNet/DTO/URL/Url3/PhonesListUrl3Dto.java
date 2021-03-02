package com.Project5OC.SafetyNet.DTO.URL.Url3;

import java.util.List;

public class PhonesListUrl3Dto {

	public List<PhoneNumberDTO> phoneNumbers;

	public PhonesListUrl3Dto() {
	}

	public PhonesListUrl3Dto(List<PhoneNumberDTO> phoneNumbers) {
		super();
		this.phoneNumbers = phoneNumbers;
	}

	public List<PhoneNumberDTO> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumberDTO> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

}
