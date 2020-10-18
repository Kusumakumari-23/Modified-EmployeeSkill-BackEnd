package com.employee.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmployeeSkillCompositeKey implements Serializable{


	private Long empSkillId;
	
	//	@Column(name="empId")
	
	private Long empId;
	
//	@Column(name="firstName")
	private String firstName;
	
//	@Column(name="skillId")
	private Long skillId;
	
//	@Column(name="skillName")
	private String skillName;
}
