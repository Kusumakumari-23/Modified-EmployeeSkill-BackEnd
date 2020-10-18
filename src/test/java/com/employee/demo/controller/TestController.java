package com.employee.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.employee.demo.Controller.EmployeeController;
import com.employee.demo.Services.EmpServiceInterface;
import com.employee.demo.Services.SkillServiceInterface;
import com.employee.demo.entity.Employee;
import com.employee.demo.entity.Skill;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
//@WithMockUser
public class TestController {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmpServiceInterface empService;
	
	@MockBean
	private SkillServiceInterface skillService;
	
	List<Employee> employees= Arrays.asList(
			new Employee(5L, "devdev", "omkar", new Date(2019-04-11), "fdfkdnk", "mp", "56478"),
			new Employee(4L, "dev", "kumari", new Date(2020-04-11), "fdhjf", "ap", "2394ooo78"));
	
	List<Skill> skills= Arrays.asList(
			new Skill(101L,"c","Programming Language", 5L),
			new Skill(102L,"c++","oop", 4L));
	
	@Test
	public void addEmpTest() throws Exception {
		
		RequestBuilder request= MockMvcRequestBuilders.post("/empdata/emp/addemployee").accept(MediaType.APPLICATION_JSON).content(
				"{\"empId\":\"1\","
				+ "\"firstName\":\"mahadev\","
				+ "\"lastName\":\"dev\","
				+ "\"hireDate\":\"2020-05-05\","
				+ "\"email\":\"kdjhu\","
				+ "\"city\":\"ap\","
				+ "\"phoneNo\":\"54682\"}").contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request).andExpect(status().is(200)).andReturn();	
				
	}
	
	@Test
	public void getAllEmployees() throws Exception {
		
		Mockito.when(empService.getAllEmployees()).thenReturn(employees);
		
		RequestBuilder request= MockMvcRequestBuilders.get("/empdata/emp/getemployees");
		mockMvc.perform(request).andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void testUpdateEmployee() throws Exception {
		
		Employee emp=new Employee(5L, "devdev", "omkar", new Date(2019-04-11), "fdfkdnk", "mp", "56478");
		
		Mockito.when(empService.updateEmployeeDetails(emp)).thenReturn(emp);
		
		RequestBuilder request= MockMvcRequestBuilders.put("/empdata/emp/updateEmployee").accept(MediaType.APPLICATION_JSON).content(
				"{\"empId\":\"1\","
				+ "\"firstName\":\"mahadev\","
				+ "\"lastName\":\"dev\","
				+ "\"hireDate\":\"2020-05-05\","
				+ "\"email\":\"kdjhu\","
				+ "\"city\":\"ap\","
				+ "\"phoneNo\":\"54682\"}").contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request).andExpect(status().is(200)).andReturn();
	}
	
	@Test
	public void testGetEmployee() throws Exception {
		Employee employee=new Employee(5L, "devdev", "omkar", new Date(2019-04-11), "fdfkdnk", "mp", "56478");
		
		when(empService.getEmployeeById(anyLong())).thenReturn(employee);
		String uri="/empdata/employeeById/5";
		
		RequestBuilder request=MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).andExpect(status().isOk())
		.andExpect(jsonPath("$.empId",Matchers.is(5)))
		.andExpect(jsonPath("$.*",Matchers.hasSize(8)));
	}
	
	/* @@@@@@ Skill Test @@@@@@*/
	
	@Test
	public void addSkillTest() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders.post("/empdata/createSkills").accept(MediaType.APPLICATION_JSON).content(
				"{\"skillId\":\"101\", \"skillName\": \"java\", \"details\": \"pl\", \"empId\": \"1\"}")
				.contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request).andExpect(status().is(200)).andReturn();
	}
	
	@Test
	public void getAllSkills() throws Exception{
		
		Mockito.when(skillService.getAllSkills()).thenReturn(skills);
		
		RequestBuilder request=MockMvcRequestBuilders.get("/empdata/skills/getskills");
		mockMvc.perform(request).andExpect(status().isOk()).andReturn();
		
	}
	
	
	@Test
	public void testGetSkill() throws Exception {
		Skill skill = new Skill(101L,"c","Programming Language", 5L);
		
		when(skillService.findSkillById(anyLong())).thenReturn(skill);
		String uri="/empdata/skills/skillsById/101";
		
		RequestBuilder request=MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request).andExpect(status().isOk())
		.andExpect(jsonPath("$.skillId",Matchers.is(101)))
		.andExpect(jsonPath("$.*",Matchers.hasSize(4)));
	}
	
	@Test
	public void testSkillUpdate() throws Exception {
		
		Skill skill = new Skill(101L,"c","Programming Language", 5L);
		
		Mockito.when(skillService.updateSkillDetails(skill)).thenReturn(skill);
		
		RequestBuilder request = MockMvcRequestBuilders.put("/empdata/skill/updateskills").accept(MediaType.APPLICATION_JSON).content(
				"{\"skillId\":\"101\", \"skillName\": \"c\", \"details\": \"pl\", \"empId\": \"1\"}")
				.contentType(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request).andExpect(status().is(200)).andReturn();
	}
	
//	@Test
//	public void delete() throws Exception {
//	   String uri = "/empdata/skill/deleteById/101";
//	   RequestBuilder mvcResult = (RequestBuilder) ((ResultActions) MockMvcRequestBuilders.delete(uri)).andReturn();
//	   int status = ((MvcResult) mvcResult).getResponse().getStatus();
//	   assertEquals(200, status);
//	   String content = ((MvcResult) mvcResult).getResponse().getContentAsString();
//	}
	
//	@Test
//	public void deleteSkills() throws Exception {
//		long skillId = 101L;
//		Skill skill = new Skill(101L,"c","Programming Language", 5L);
//		
////		doNothing().when(skillService).deleteSkillDetails(skill.getSkillId());
//		
////		RequestBuilder request=MockMvcRequestBuilders.delete("/empdata/skill/deleteById/{skillId}", skillId)
////				.contentType(MediaType.APPLICATION_JSON)
////				.accept(MediaType.APPLICATION_JSON);
////		mockMvc.perform(request).andExpect(status().is(200))
////		.andExpect(jsonPath("$.skillId", is(skill.getSkillId())))
////		.andExpect(jsonPath("$.skillName", is(skill.getSkillName())))
////		.andExpect(jsonPath("$.details", is(skill.getDetails())))
////		.andExpect(jsonPath("$.empId", is(skill.getEmpId())));
//		
//		
////		this.mockMvc.perform(delete("/empdata/skill/deleteById/{skillId}", skill.getSkillId()))
////		.andExpect(status().isOk())
////		.andExpect(jsonPath("$.skillId", is(skill.getSkillId())))
////		.andExpect(jsonPath("$.skillName", is(skill.getSkillName())))
////		.andExpect(jsonPath("$.details", is(skill.getDetails())))
////		.andExpect(jsonPath("$.empId", is(skill.getEmpId())));
//	}
	
} 
