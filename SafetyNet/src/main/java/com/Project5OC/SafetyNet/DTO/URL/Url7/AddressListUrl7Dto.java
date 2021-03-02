package com.Project5OC.SafetyNet.DTO.URL.Url7;

import java.util.List;

public class AddressListUrl7Dto {

	public List<AddressUrl7Dto> email;

	public AddressListUrl7Dto() {
	}

	public AddressListUrl7Dto(List<AddressUrl7Dto> email) {
		super();
		this.email = email;
	}

	public List<AddressUrl7Dto> getEmail() {
		return email;
	}

	public void setEmail(List<AddressUrl7Dto> email) {
		this.email = email;
	}

}
