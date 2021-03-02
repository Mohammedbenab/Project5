package com.Project5OC.SafetyNet.DTO;

public class FirestationDTO {

	public String address;
	public String station;

	public FirestationDTO() {
	}

	public FirestationDTO(String address, String station) {
		super();
		this.address = address;
		this.station = station;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

}
