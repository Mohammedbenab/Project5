package com.Project5OC.SafetyNet.Services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.Project5OC.SafetyNet.model.Firestation;
import com.Project5OC.SafetyNet.model.FirestationsList;
import com.Project5OC.SafetyNet.model.MedicalRecords;
import com.Project5OC.SafetyNet.model.MedicalRecordsList;
import com.Project5OC.SafetyNet.model.Person;
import com.Project5OC.SafetyNet.model.PersonList;

@Service
public class ReadJsonFile {

	public JSONObject readJsonFile() {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObject = null;
		try {
			FileReader readFile = new FileReader(
					"C:/Users/Benabdallah .LAPTOP-FF0508KR/Documents/FortmationDevJavaOC/Projets/DevJava/ProjectOC/Project05OC/SafetyNet/src/main/resources/JasonFile.json");
			Object obj = jsonParser.parse(readFile);
			jsonObject = (JSONObject) obj;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return jsonObject;

	}

	public PersonList readPersons() {
		List<Person> personsListe = new ArrayList<Person>();

		JSONArray persons = (JSONArray) this.readJsonFile().get("persons");
		for (Object infoPerson : persons) {
			JSONObject person = (JSONObject) infoPerson;
			String firstName = (String) person.get("firstName");
			String lastName = (String) person.get("lastName");
			String address = (String) person.get("address");
			String city = (String) person.get("city");
			String zip = (String) person.get("zip");
			String phone = (String) person.get("phone");
			String email = (String) person.get("email");

			Person newPerson = new Person(firstName, lastName, address, city, zip, phone, email);
			personsListe.add(newPerson);
		}
		PersonList personsList = new PersonList(personsListe);
		return personsList;
	}

	public FirestationsList readFirestation() {
		List<Firestation> firestations = new ArrayList<Firestation>();

		JSONArray firestation = (JSONArray) this.readJsonFile().get("firestations");
		for (Object infoFirestation : firestation) {
			JSONObject firestationByNumber = (JSONObject) infoFirestation;
			String address = (String) firestationByNumber.get("address");
			String station = (String) firestationByNumber.get("station");
			Firestation newFirestation = new Firestation(address, station);
			firestations.add(newFirestation);
		}
		FirestationsList allFirestation = new FirestationsList(firestations);
		return allFirestation;

	}

	public MedicalRecordsList readMedical() {
		List<MedicalRecords> medical = new ArrayList<MedicalRecords>();
		JSONArray medication = (JSONArray) this.readJsonFile().get("medicalrecords");
		for (Object infoFirestation : medication) {
			JSONObject medicalByName = (JSONObject) infoFirestation;
			String firstName = (String) medicalByName.get("firstName");
			String lastName = (String) medicalByName.get("lastName");
			String birthdate = (String) medicalByName.get("birthdate");
			List<String> medications = (List<String>) medicalByName.get("medications");
			List<String> allergies = (List<String>) medicalByName.get("allergies");
			MedicalRecords newMedical = new MedicalRecords(firstName, lastName, birthdate, medications, allergies);
			medical.add(newMedical);
		}

		MedicalRecordsList medicalRecordsList = new MedicalRecordsList(medical);
		return medicalRecordsList;

	}

}
