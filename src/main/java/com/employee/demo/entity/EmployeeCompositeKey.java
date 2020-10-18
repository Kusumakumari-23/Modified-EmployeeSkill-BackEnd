package com.employee.demo.entity;

import java.io.Serializable;
import javax.persistence.Id;
//@AllArgsConstructor
//@Data
//@Entity
public class EmployeeCompositeKey implements Serializable{

//	@Column(name="empId")
	@Id
	private long empId;
	
//	@Column(name="firstName")
	private String firstName;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
}
