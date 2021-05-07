package com.Project5OC.SafetyNet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.Project5OC.SafetyNet.Services.FirestationService;
import com.fasterxml.jackson.core.JsonProcessingException;

@WebMvcTest(controllers = FirestationService.class)
public class FirestationControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FirestationService firestationService;

	@Test
	public void getNewFirestation() throws Exception {

	}

	@Test
	public void getFirestationListUpdate() throws JsonProcessingException, Exception {

	}

	@Test
	public void getFirestationListWithoutObjectDelete() throws JsonProcessingException, Exception {

	}

}
