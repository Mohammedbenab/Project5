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

import com.Project5OC.SafetyNet.DTO.PersonDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerPersonTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void givenListOfPersonWhenNewPersonIsAdd() throws Exception {
		PersonDTO personDto = new PersonDTO("Axel", "Biscote", "8 rue de la paix", "Spring", "212121", "0635353535",
				"axel.b@live.fr");
		ObjectMapper mapper = new ObjectMapper();

		this.mockMvc.perform(post("/personAdd")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(personDto)))
				.andDo(print())
				.andExpect(status().isOk());

	}

	@Test
	public void givenPersonsWhithUpdating() throws JsonProcessingException, Exception {
		PersonDTO personDto = new PersonDTO("John", "Boyd", "1509 Culver St", "Choisy le roi", "95200", "841-874-6512",
				"jaboyd@email.com");
		ObjectMapper mapper = new ObjectMapper();

		this.mockMvc.perform(put("/personUpdate")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(personDto)))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void givenPersonsItWasCorrectlyDelete() throws JsonProcessingException, Exception {

		PersonDTO personDto = new PersonDTO("Axel", "Biscote", "8 rue de la paix", "Spring", "212121", "0635353535",
				"axel.b@live.fr");
		ObjectMapper mapper = new ObjectMapper();

		this.mockMvc.perform(delete("/personDelete")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(personDto)))
				.andDo(print())
				.andExpect(status().isOk());

	}

}
