package integrationTest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
public class SafetyNetControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getPersonsForUrl1Test() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/firestation")
				.param("stationNumber", "1"))
				.andDo(print()).andExpect(status().isOk());
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.personUrl1Dto[0].firstName").value("Peter"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.personUrl1Dto[0].lastName").value("Duncan"));

	}
//
//	@Test
//	public void getPersonsForUrl2Test() throws Exception {
//		this.mockMvc.perform(MockMvcRequestBuilders.get("/childAlert")
//				.param("address", "1509 Culver St"))
//				.andDo(print()).andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].firstName").value("Tenley"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].lastName").value("Boyd"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[1].firstName").value("Roger"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[1].lastName").value("Boyd"));
//	}
//
//	@Test
//	public void getPhoneListTest() throws Exception {
//		this.mockMvc.perform(MockMvcRequestBuilders.get("/phoneAlert")
//				.param("firestationNumber", "2"))
//				.andDo(print()).andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.phoneNumbers[0].phone").value("841-874-6513"));
//	}
//
//	@Test
//	public void getPersonsOfUrl4() throws Exception {
//		this.mockMvc.perform(MockMvcRequestBuilders.get("/fire")
//				.param("address", "1509 Culver St"))
//				.andDo(print()).andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].firstName").value("John"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.firestation").value("3"));
//
//	}
//
//	@Test
//	public void getPersonsOfUrl5() throws Exception {
//		this.mockMvc.perform(MockMvcRequestBuilders.get("/flood/stations")
//				.param("listStationNb", "3,4"))
//				.andDo(print()).andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].lastName").value("Cooper"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.persons[0].phone").value("841-874-6874"));
//
//	}
//
//	@Test
//	public void getPersonsOfUrl6() throws Exception {
//		this.mockMvc.perform(MockMvcRequestBuilders.get("/personInfo")
//				.param("firstName", "Foster")
//				.param("lastName", "Shepard"))
//				.andDo(print()).andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.address").value("748 Townings Dr"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.email").value("jaboyd@email.com"));
//
//	}
//
//	@Test
//	public void getListOfAddressUrl6() throws Exception {
//		this.mockMvc.perform(MockMvcRequestBuilders.get("/communityEmail")
//				.param("city", "Culver"))
//				.andDo(print()).andExpect(status().isOk())
//				.andExpect(content().contentType("application/json;charset=UTF-8"))
//				.andExpect(MockMvcResultMatchers.jsonPath("$.email[0].email").value("jaboyd@email.com"));
//
//	}

}
