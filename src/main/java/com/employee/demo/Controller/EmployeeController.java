package com.employee.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.demo.Services.EmpServiceInterface;
import com.employee.demo.Services.SkillServiceInterface;
import com.employee.demo.entity.Employee;
import com.employee.demo.entity.Skill;
import com.employee.demo.exception.ResourceNotFoundException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value="/empdata")
@Api(value= "Employee and Skills Controller")
public class EmployeeController {

	@Autowired
	private EmpServiceInterface empService;
	
	@Autowired(required=true)
	private SkillServiceInterface skillService;
	
	// *********** EMPLOYEE CONTROLLER  ****************
	
	@ApiOperation(value= "Get all employees", produces= "a list of employees", notes= "Hit this URL to retrieve all employee details" )
	@GetMapping("/emp/getemployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		
		List<Employee> emplist=empService.getAllEmployees();
		
		if(emplist==null) {
			throw new ResourceNotFoundException("No Employee Details found");
		}
		return new ResponseEntity<>(emplist,HttpStatus.OK);
		
	}
	
	
	@ApiOperation(value= "Get employee by using Id", produces= "a employee details", notes= "Hit this URL to retrieve a employee details" )
	@GetMapping("/employeeById/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long empId){
	   final String ERR_MSG = "Employee with id "+empId+" not found";
		
		Employee emp=empService.getEmployeeById(empId);
		if(emp!=null) {
			
			return new ResponseEntity<>(emp, HttpStatus.OK);
		}
		else 
        {
            throw new ResourceNotFoundException(ERR_MSG);
        }
	}
	
	/* DELETE BOTH EMPLOYEE AND SKILLS TOGETHER */
	
	@ApiOperation(value = "Delete employee and skills", consumes = "an existing employee Id", notes = "Hit this URL to delete employee and skills")
	//@RequestMapping(value="/employee/deleteById/{empId}", method=RequestMethod.DELETE)
	@DeleteMapping("/employee/deleteById/{empId}")
	public ResponseEntity<Void> deleteEmployeeDetails(@PathVariable(value= "empId") long empId) {
		
		empService.deleteEmployeeDetails(empId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	
	@ApiOperation(value = "Update a employee details", consumes = "an existing employee in JSON", notes = "Hit this URL to update employee's details")
	@PutMapping("/emp/updateEmployee")
	public ResponseEntity<Employee> updateEmployeeDetails(@RequestBody Employee employee){
		
		if(employee!=null) {
			
			empService.updateEmployeeDetails(employee);
		}
		
		return new ResponseEntity<>(employee, HttpStatus.OK);
		
	}
	
	/* BATCH INSERT-- INSERT MULTIPLE RECORDS AT A TIME -- PRACTICE*/
	
	@ApiOperation(value = "Add employee's", consumes = "A new employee in JSON", notes = "Hit this URL to insert a new employee's details")
	//@RequestMapping(value="/emp/addbatchemployee", method=RequestMethod.POST)
	@PostMapping("/emp/addbatchemployee")
	public int[] batchInsert(@RequestBody List<Employee> employees) {
			
		return empService.batchInsert(employees);
	}
	
	
	/* INSERTING BOTH EMPLOYEE AND SKILL TOGETHER */
	
	@ApiOperation(value = "Add employee and skill details together", consumes = "A new employee and skill in JSON", notes = "Hit this URL to insert a new employee and skill details")
	//@RequestMapping(value="/emp/addemployee", method=RequestMethod.POST)
	@PostMapping("/emp/addemployee")
	public void addEmployee(@RequestBody Employee employee) {
		
			empService.addEmployee(employee);
			
	}
	
	@PostMapping("/createEmp")
	public void createEmployee(@RequestBody Employee employee) {
		
		empService.createEmployee(employee);
	}
	
	
	@PutMapping("/updateEmp/{empId}")
	public Employee updateEmployee(@PathVariable long empId, @RequestBody Employee employee) {
		
		return empService.updateEmployee(empId, employee);
	}
	
	
		
	/* ********* SKILL CONTROLLER ************ */
	
	@ApiOperation(value= "Get all skills", produces= "a list of skills", notes= "Hit this URL to retrieve all skill details" )
	@GetMapping("/skills/getskills")
	public ResponseEntity<List<Skill>> getAllSkills(){
		
		List<Skill> skillist=skillService.getAllSkills();
		
		if(skillist==null) {
			throw new ResourceNotFoundException("No Skill Details found");
		}
		
		return new ResponseEntity<>(skillist,HttpStatus.OK);
	}
	

	@ApiOperation(value = "Add skill's", consumes = "A new skill in JSON", notes = "Hit this URL to insert a new skill's details")
	//@ResponseStatus(HttpStatus.OK)
	@PostMapping("/skills/addbatchskills")
	public int[] batchSkillInsert(@RequestBody List<Skill> skills) {
		
		return skillService.batchSkillInsert(skills);
	}
	
	
	// Get Skill details by SkillId
	
	@ApiOperation(value= "Get skills by using Skill Id", produces= "a skill details", notes= "Hit this URL to retrieve skill details" )
	@GetMapping("skills/skillsById/{skillId}")
	public ResponseEntity<Skill> getSkillById(@PathVariable long skillId){
		
		Skill skills= skillService.findSkillById(skillId);
		if(skills!=null) {
			
			return new ResponseEntity<>(skills, HttpStatus.OK);
		}
		else 
        {
            throw new ResourceNotFoundException("Skill with id "+skillId+" is not found");
        }
	}
	
	@ApiOperation(value = "Update a skill details", consumes = "an existing skills in JSON", notes = "Hit this URL to update skill details")
	@PutMapping("/skill/updateskills")
	public ResponseEntity<Skill> updateSkillDetails(@RequestBody Skill skill){
		
		if(skill!=null) {
			
			skillService.updateSkillDetails(skill);
		}
		
		return new ResponseEntity<>(skill, HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Delete a skill", consumes = "An existing skill id", notes = "Hit this URL to delete skill details")
	//@RequestMapping(value="/skill/deleteById/{skillId}", method=RequestMethod.DELETE)
	@DeleteMapping("/skill/deleteById/{skillId}")
	public ResponseEntity<Void> deleteSkillDetails(@PathVariable(value= "skillId") long skillId) {
		
		skillService.deleteSkillDetails(skillId);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	
	@ApiOperation(value= "Get skills by using employee Id", produces= "a skill details", notes= "Hit this URL to retrieve skill details" )
	@GetMapping("/skillsByempId/{empId}")
	public ResponseEntity<Skill> getSkillByempId(@PathVariable long empId){
		
		Skill skills= skillService.getSkillByempId(empId);
		if(skills!=null) {
			
			return new ResponseEntity<>(skills, HttpStatus.OK);
		}
		else 
        {
            throw new ResourceNotFoundException("Skill with id "+empId+" is not found");
        }
	}
	
	@PostMapping("/createSkills")
	public void createSkills(@RequestBody Skill skill) {
		
		skillService.addSkillDetails(skill);
	}
	
	@PutMapping("/updateSkill/{empId}")
	public Skill updateSkill(@PathVariable long empId, @RequestBody Skill skill) {
		return skillService.updateSkill(empId, skill);
	}

}
