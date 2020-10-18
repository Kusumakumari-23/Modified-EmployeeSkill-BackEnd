package com.employee.demo.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
//@Entity
public class SkillCompositeKey implements Serializable{
 
//	@Column(name="skillId")
	private long skillId;
	
//	@Column(name="skillName")
	private String skillName;
	
}
