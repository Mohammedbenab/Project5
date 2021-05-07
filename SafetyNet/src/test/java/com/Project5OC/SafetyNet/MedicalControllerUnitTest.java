package com.Project5OC.SafetyNet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.Project5OC.SafetyNet.Controller.MedicalRecordsController;
import com.Project5OC.SafetyNet.Services.MedicalRecordsService;
import com.fasterxml.jackson.core.JsonProcessingException;

@WebMvcTest(controllers = MedicalRecordsController.class)
public class MedicalControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private MedicalRecordsService medicalRecordsService;

	@Test
	public void getNewMedical() throws Exception {

	}

	@Test
	public void getMedicalListUpdate() throws JsonProcessingException, Exception {

	}

	@Test
	public void getMedicalListWithoutObjectDelete() throws JsonProcessingException, Exception {

	}

}
