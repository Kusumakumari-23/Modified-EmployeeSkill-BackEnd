//package com.employee.demo.StepDefinition;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import com.employee.demo.Controller.EmployeeController;
//import com.employee.demo.Services.SkillServiceImpl;
//
//import io.cucumber.java.Before;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
////@RunWith(SpringRunner.class)
////@SpringBootTest(classes=EmployeeSillsApplication.class,
////				webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
////@RunWith(SpringRunner.class)
////@SpringBootTest
//@WebMvcTest(EmployeeController.class)
//@AutoConfigureWebMvc
//public class SkillStepDef extends AbstractStepDef {
//
//	@Autowired
//	private SkillServiceImpl skillService;
//	
//	private MockMvc mockMvc;
//	
//	@Before
//	   public void setup() {
//	       this.mockMvc = MockMvcBuilders.standaloneSetup(skillService).build();
//	   }
//	
//	
//	@Given("I search for skillId")
//	public void i_search_for() throws Exception {
//	    
////		actions = mockMvc.perform(get("skills/skillsById/" + skillId)
////	               .accept(MediaType.APPLICATION_JSON));
//	}
//
//	@When("the skill should found")
//	public void the_skill_should_found() throws Throwable {
//	    
//		//actions.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
//	}
//
//	@Then("return skillname and details skillName , details")
//	public void return_skillname_and_details() throws Throwable {
//	    
////		actions.andExpect(jsonPath("$.skillName").value(skillName))
////		.andExpect(jsonPath("$.details").value(details));
//	}
//}
