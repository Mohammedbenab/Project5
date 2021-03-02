package com.Project5OC.SafetyNet.DTO.URL.Url1;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PersonUrl1Dto {

	public String firstName;
	public String lastName;
	public String address;
	public String phone;

	@JsonIgnore
	public String age;

	public PersonUrl1Dto() {
	}

	public PersonUrl1Dto(String firstName, String lastName, String address, String phone, String age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

}
