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

import com.Project5OC.SafetyNet.DTO.FirestationDTO;
import com.Project5OC.SafetyNet.model.Firestation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerFirestationsTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void givenFireStationWhenSaveNewStation() throws Exception {
		FirestationDTO firestationDTO = new FirestationDTO("951 LoneTree Rd", "2");
		ObjectMapper mapper = new ObjectMapper();

		this.mockMvc.perform(post("/firestationAdd")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(firestationDTO)))
				.andDo(print())
				.andExpect(status().isOk());

	}

	@Test
	public void givenFireStationWhithUpdating() throws JsonProcessingException, Exception {
		Firestation firestation = new Firestation("489 Manchester St", "3");
		ObjectMapper mapper = new ObjectMapper();

		this.mockMvc.perform(put("/firestationUpdate")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(firestation)))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void givenFirestationItWasCorrectlyDelete() throws JsonProcessingException, Exception {

		Firestation firestation = new Firestation("489 Manchester St", "3");
		ObjectMapper mapper = new ObjectMapper();

		this.mockMvc.perform(delete("/firestationDelete")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(firestation)))
				.andDo(print())
				.andExpect(status().isOk());

	}

}
