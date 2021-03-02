package com.Project5OC.SafetyNet.DTO.URL.Url5;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PersonUrl5Dto implements Comparable<PersonUrl5Dto> {

	public String lastName;
	public String phone;
	public String age;
	public List<String> medications;
	public List<String> allergies;
	@JsonIgnore
	public String address;

//	public PersonUrl5Dto() {
//	}

	public PersonUrl5Dto(String lastName, String phone, String age, List<String> medications, List<String> allergies,
			String address) {
		super();
		this.lastName = lastName;
		this.phone = phone;
		this.age = age;
		this.medications = medications;
		this.allergies = allergies;
		this.address = address;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int compareTo(PersonUrl5Dto u) {
		if (getAddress() == null || u.getAddress() == null) {
			return 0;
		}
		return getAddress().compareTo(u.getAddress());
	}

}
