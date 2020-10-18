package com.employee.demo.TestRepository;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.employee.demo.EmployeeSillsApplication;
import com.employee.demo.Repository.EmpRepository;
import com.employee.demo.Repository.SkillRepositoryImpl;
import com.employee.demo.entity.Employee;
import com.employee.demo.entity.Skill;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest(classes=EmployeeSillsApplication.class)
public class EmpRepositoryTest {

	@Mock
	private JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	private EmpRepository empRepo;
	
	@InjectMocks
	private SkillRepositoryImpl skillRepo;
	
	List<Employee> employee = Arrays.asList(
			new Employee(5L, "devdev", "omkar", new Date(2019-04-11), "fdfkdnk", "mp", "56478"),
			new Employee(6L, "dev", "omkar", new Date(2020-04-11), "kkk@gmail.com", "mp", "56478546"));
	
	Employee emp=new Employee(5L, "devdev", "omkar", new Date(2019-04-11), "fdfkdnk", "mp", "56478");
	
	List<Skill> skills= Arrays.asList(
			new Skill(101L,"c","Programming Language"),
			new Skill(102L,"c++","oop"));
	
	Skill skill = new Skill(101L,"c","Programming Language");
	
	@Test
	public void addEmployeeTest() {
		
		empRepo.createEmployee(emp);
		//Mockito.when(jdbcTemplate.batchUpdate("insert into employees (empId, firstName, lastName, hireDate, city, email, phoneNo) values (?, ?, ?, ?, ?, ?, ?) "));
		Assert.assertNotNull(employee);
	}
	
	@Test
	public void EmployeeDetailsById() {
		
		empRepo.getEmployeeById(1L);
		Assert.assertNotNull(emp);
	}
	
	@Test
	public void employeeUpdate() {
		
		empRepo.updateEmployeeDetails(emp);
		Assert.assertNotNull(emp);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getAllEmployees() {
		Mockito.when(jdbcTemplate.queryForObject("SELECT * FROM employees", new BeanPropertyRowMapper(Employee.class))).thenReturn(employee);
		Assert.assertNotNull(employee);
	}
	
	@Test
	public void addBatchSkillsTest() {
		
		skillRepo.batchSkillInsert(skills);
		Mockito.when(jdbcTemplate.batchUpdate("insert into skills (skillId, skillName, details) values(?, ?, ?)"));
		Assert.assertNotNull(skills);
		
	}
	
	@Test
	public void addSkill() {
		 skillRepo.addSkillDetails(skill);
		 Assert.assertNotNull(skill);
		 
	}
	
	@Test
	public void skillById() {
		skillRepo.findSkillById(101L);
		Assert.assertNotNull(skill);
		
	}
	
	@Test
	public void skillUpdate() {
		skillRepo.updateSkillDetails(skill);
		Assert.assertNotNull(skill);
		
	}
	
//	@Test
//	public void deleteEmployee() {
//		empRepo.deleteEmployeeDetails(1L);
//		empRepo.deleteEmployeeDetails(101L);
//		Assert.assertNotNull(employee);
//	}
	
	
	
}
