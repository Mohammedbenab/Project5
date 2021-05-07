package com.Project5OC.SafetyNet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.Project5OC.SafetyNet.Services.PersonService;
import com.fasterxml.jackson.core.JsonProcessingException;

@WebMvcTest(controllers = PersonService.class)
public class PersonControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PersonService personService;

	@Test
	public void getNewPerson() throws Exception {

	}

	@Test
	public void getPersonsListUpdate() throws JsonProcessingException, Exception {

	}

	@Test
	public void getPersonsListWithoutObjectDelete() throws JsonProcessingException, Exception {

	}

}
