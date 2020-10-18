package com.employee.demo.TestService;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.transaction.annotation.Transactional;

import com.employee.demo.Repository.EmpRepositoryInterface;
import com.employee.demo.Repository.SkillRepositoryInterface;
import com.employee.demo.Services.EmpService;
import com.employee.demo.Services.SkillServiceImpl;
import com.employee.demo.entity.Employee;
import com.employee.demo.entity.Skill;

@RunWith(MockitoJUnitRunner.Silent.class)
@Transactional
public class ServiceTest {

	@Mock
	private EmpRepositoryInterface empRepo;
	
	
	@InjectMocks
	private EmpService empService;
	
	@Test
	@DisplayName("Testing Employee Insertion")
	public void addEmployeeTest() {
		
		Employee employee=new Employee(5L, "devdev", "omkar", new Date(2019-04-11), "fdfkdnk", "mp", "56478");
		
		empService.addEmployee(employee);
		verify(empRepo,times(1)).addEmployee(employee);
	}
	
	
	@Test
	public void EmployeeDetailsById() {
		Employee emp=new Employee(5L, "devdev", "omkar", new Date(2019-04-11), "fdfkdnk", "mp", "56478");
		
		Mockito.when(empRepo.getEmployeeById(5L)).thenReturn(emp);
		Assert.assertSame(5L, empService.getEmployeeById(emp.getEmpId()).getEmpId());
	}
	
	@Test
	public void EmployeeUpdate() {
		Employee emp=new Employee(5L, "devdev", "omkar", new Date(2019-04-11), "fdfkdnk", "mp", "56478");
		
		//Mockito.when(empRepo.updateEmployeeDetails(emp)).thenReturn(emp);
		Mockito.when(empRepo.updateEmployeeDetails(emp)).thenReturn(emp);
		Assert.assertSame(5L, empService.updateEmployeeDetails(emp).getEmpId());
	}
	
	@Test
	public void deleteById() {
		empService.deleteEmployeeDetails(5L);
		empService.deleteEmployeeDetails(5L);
		
		verify(empRepo,times(2)).deleteEmployeeDetails(5L);
		
	}
	
	@Test
	public void getAllEmployee() {
		List<Employee> emp = Arrays.asList(
				new Employee(5L, "devdev", "omkar", new Date(2019-04-11), "fdfkdnk", "mp", "56478"),
				new Employee(6L, "dev", "omkar", new Date(2020-04-11), "kkk@gmail.com", "mp", "56478546"));
		
		Mockito.when(empRepo.getAllEmployees()).thenReturn(emp);
		Assert.assertSame(emp, empService.getAllEmployees());
	}
	
	
	
}
	


