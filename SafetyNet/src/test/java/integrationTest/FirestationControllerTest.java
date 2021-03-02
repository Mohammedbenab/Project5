package integrationTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.Project5OC.SafetyNet.Controller.FirestationController;
import com.Project5OC.SafetyNet.DTO.FirestationDTO;
import com.Project5OC.SafetyNet.model.Firestation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class FirestationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new FirestationController()).build();
	}

	@Test
	public void givenFireStationWhenSaveNewStation() throws Exception {
		FirestationDTO firestationDTO = new FirestationDTO("6 rue henri barbus", "8");
		ObjectMapper mapper = new ObjectMapper();

		this.mockMvc.perform(post("/firestationAdd")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(firestationDTO)))
				.andDo(print())
				.andExpect(status().isOk());

	}

	@Test
	public void testPostMethod() throws JsonProcessingException, Exception {
		Firestation firestation = new Firestation("rue de paix", "4");
		ObjectMapper mapper = new ObjectMapper();

		this.mockMvc.perform(post("/testPost")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(firestation)))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.address").value("rue de paix"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.station").value("4"));
	}

	@Test
	public void givenFireStationWhithUpdating() {

	}

	@Test
	public void givenFirestationItWasCorrectlyDelete() {

	}

}
