//package StepDefinitions;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//
//import java.util.List;
//
//import com.employee.demo.entity.Employee;
//import com.employee.demo.entity.Skill;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//
//public class StepDefinition extends SpringIntegrationTest {
//	
////	@LocalServerPort
////	private String port;
//	
//	//private RestTemplate restTemplate=new RestTemplate();
//	
//	//private String postUrl="http://localhost:8090";
//	private String skillId="";
//	int response=0;
//	
//	
//	@Given("an skill table to add skill details")
//	public void an_skill_table_to_add_skill_details() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		System.out.println("Inside Given--ready to add skill details");
//		
//		String url= PORT_URL + "/emp/addbatchskills";
//		
//		@SuppressWarnings("unchecked")
//		List<Skill> skills=restTemplate.getForObject(url, List.class);
//		System.out.println("Inside Given after --ready to add skill details");
//		assertTrue(!skills.isEmpty());
//	}
//	
////	@When("I set request header")
////	public void i_set_request_header() {
////	    // Write code here that turns the phrase above into concrete actions
////	    //throw new io.cucumber.java.PendingException();
////		
////		//headers=new HttpHeaders;
////	}
//
//	@When("^adding new skill with SkillId (.*), skillName (.*) and details (.*)$")
//	public void adding_new_skill_with_skill_id_skill_name_aws_and_details_amazon_service(Long skillId, String skillName, String details) throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	   // throw new io.cucumber.java.PendingException();
//		System.out.println("ready to add");
//		
//		String url= PORT_URL +"/emp/addbatchskills";
//		Skill skill=new Skill();
//		skill.setSkillId(skillId);
//		skill.setSkillName(skillName);
//		skill.setDetails(details);
//		
//		Skill newSkill= restTemplate.postForObject(url, PORT_URL, Skill.class);
//		skillId=newSkill.getSkillId();
//		assertNotNull(newSkill);
//	}
//
//	@Then("It should add to skills table")
//	public void it_should_add_to_skills_table() throws Throwable{
//	    // Write code here that turns the phrase above into concrete actions
//	   // throw new io.cucumber.java.PendingException();
//		System.out.println("ready to add");
//		String url= PORT_URL + "/emp/addbatchskills/"+ skillId;
//		
//		Skill newSkill=restTemplate.getForObject(url, Skill.class);
//		assertNotNull(newSkill);
//		
//		
//	}
//	
//	// For Get
//	
//	
//	@When("client calls \\/employeeById\\/{int}")
//	public void client_calls_employee_by_id(Integer int1) {
////	    // Write code here that turns the phrase above into concrete actions
////	    throw new io.cucumber.java.PendingException();
//		String url= PORT_URL;
//		//response=restTemplate.getForObject(PORT_URL + "empId", )
//	    Employee emp= restTemplate.getForObject(PORT_URL + "empId", Employee.class);
//	    
//		
//	}
//
//	@Then("Employee receives the status code of {int}")
//	public void employee_receives_the_status_code_of(Integer int1) {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		
//	}
//
//	@Then("the response should contain")
//	public void the_response_should_contain() {
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//	}
//
//}
