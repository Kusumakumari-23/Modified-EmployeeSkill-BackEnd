package com.employee.demo.entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Entity
//@Table(name="employeeSkills")
@AllArgsConstructor
@Data
@IdClass(SkillCompositeKey.class)
//@IdClass(EmployeeCompositeKey.class)
public class EmployeeSkill {

	@Id
	private Long empSkillId;
	
	@Id
	private Long empId;
	
	@Id
	private String firstName;
	
	@Id
	private Long skillId;
	
	@Id
	private String skillName;
	
		
	@JoinColumn(name = "empId", referencedColumnName = "empId")
	@JoinColumn(name = "firstName", referencedColumnName = "firstName")
	private Employee employee;
	
		
	@JoinColumn(name = "skillId", referencedColumnName = "skillId")
	@JoinColumn(name = "skillName", referencedColumnName = "skillName")
	private Skill skills;
}
