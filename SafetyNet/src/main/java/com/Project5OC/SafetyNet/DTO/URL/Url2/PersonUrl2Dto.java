package com.Project5OC.SafetyNet.DTO.URL.Url2;

import java.util.List;

import com.Project5OC.SafetyNet.model.PersonAllInfo;

public class PersonUrl2Dto {

	public String firstName;
	public String lastName;
	public String age;
	public List<PersonAllInfo> famillyMembers;

	public PersonUrl2Dto() {
	}

	public PersonUrl2Dto(String firstName, String lastName, String age, List<PersonAllInfo> famillyMembers) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.famillyMembers = famillyMembers;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public List<PersonAllInfo> getFamillyMembers() {
		return famillyMembers;
	}

	public void setFamillyMembers(List<PersonAllInfo> famillyMembers) {
		this.famillyMembers = famillyMembers;
	}

}
