package com.Project5OC.SafetyNet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.Project5OC.SafetyNet.DTO.MedicalRecordsDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerMedicalrecordsTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void givenNewMedicalrecord() throws JsonProcessingException, Exception {

		MedicalRecordsDTO medicalDto = new MedicalRecordsDTO("Mohamed", "Ben", "02/05/1990", null, null);
		ObjectMapper mapper = new ObjectMapper();

		this.mockMvc.perform(post("/medicalAdd")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(medicalDto)))
				.andDo(print())
				.andExpect(status().isOk());

	}

	@Test
	public void updateInformationOfMedicalrecords() throws JsonProcessingException, Exception {
		MedicalRecordsDTO medicalDto = new MedicalRecordsDTO("John", "Boyd", "03/06/1984", null, null);
		ObjectMapper mapper = new ObjectMapper();

		this.mockMvc.perform(put("/medicalUpdate")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(medicalDto)))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void deleteMedicalRecordOftheList() throws JsonProcessingException, Exception {
		MedicalRecordsDTO medicalDto = new MedicalRecordsDTO("Mohamed", "Ben", "02/05/1990", null, null);
		ObjectMapper mapper = new ObjectMapper();

		this.mockMvc.perform(delete("/medicalDelete")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(medicalDto)))
				.andDo(print())
				.andExpect(status().isOk());
	}

}
