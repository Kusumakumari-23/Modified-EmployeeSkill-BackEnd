package com.employee.demo.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.IdClass;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//@Entity
//@Table(name="skills", schema="employee")
//@AllArgsConstructor
//@Data
@SuppressWarnings("serial")
@ApiModel(value = "This is the Skill model")
@IdClass(SkillCompositeKey.class)
public class Skill implements Serializable{
	
	@ApiModelProperty(notes= "A unique Id value for each skill", required= true, value= "101")
	@Id
	private long skillId;
	
	@ApiModelProperty(notes= "Skill Name in skills", required= true, value= "Java")
	@Id
	private String skillName;
	
//	@Column(name="details")
	@ApiModelProperty(notes= "Details of a skill", required= true, value= "Java is a Programming Language")
	private String details;
	
	@ApiModelProperty(notes= "Employee ID for skills", required= true, value= "11224")
	private long empId;
	
	public Skill() {
		
	}

	public Skill(long skillId, String skillName, String details, long empId) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.details = details;
		this.empId= empId;
	}

	public Skill(long skillId, String skillName, String details) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
		this.details = details;
	}

	public long getSkillId() {
		return skillId;
	}

	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}
	

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", details=" + details + "]";
	}
	
}
