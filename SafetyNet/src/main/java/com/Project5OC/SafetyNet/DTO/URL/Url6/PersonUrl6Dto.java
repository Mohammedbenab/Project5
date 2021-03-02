package com.Project5OC.SafetyNet.DTO.URL.Url6;

import java.util.List;

public class PersonUrl6Dto {

	public String lastName;
	public String address;
	public String age;
	public String email;
	public List<String> medications;
	public List<String> allergies;

	public PersonUrl6Dto() {
	}

	public PersonUrl6Dto(String lastName, String address, String age, String email, List<String> medications,
			List<String> allergies) {
		super();
		this.lastName = lastName;
		this.address = address;
		this.age = age;
		this.email = email;
		this.medications = medications;
		this.allergies = allergies;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getMedications() {
		return medications;
	}

	public void setMedications(List<String> medications) {
		this.medications = medications;
	}

	public List<String> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}

}
