package com.employee.demo.entity;

import java.sql.Date;

import javax.persistence.Id;
import javax.persistence.IdClass;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//@Table(name="employees",schema="employee")
//@AllArgsConstructor
//@Data
@IdClass(EmployeeCompositeKey.class)
@ApiModel(description = "This is the Employee model")
public class Employee {

	@ApiModelProperty(notes= "A unique Id value for each Employee")
	@Id
	private long empId;
	
	@ApiModelProperty(notes= "First Name of the employee", required= true, value= "kusuma")
	@Id
	private String firstName;
	
	@ApiModelProperty(notes= "Last Name of the employee", required= true, value= "kumari")
	private String lastName;
	
	@ApiModelProperty(notes= "Hire Date of the employee", required= true, value= "12-27-1990")
	private Date hireDate;
	
	@ApiModelProperty(notes= "City of the employee", required= true, value= "Banglore")
	private String city;
	
	@ApiModelProperty(notes= "Email of the employee", required= true, value= "kumari@gmail.com")
	private String email;
	
	@ApiModelProperty(notes= "Mobile Number of the employee", required= true)
	private String phoneNo;
	
//	@OneToMany
//	@JoinColumn(name="skillId")
	//@JsonProperty("collection")
	@ApiModelProperty(value= "Skill Details connected with one-to-one relation", required= true)
	private Skill skills;
	
	public Employee() {
		
	}
	
	public Employee(long empId, String firstName, String lastName, Date hireDate, String city, String email,
			String phoneNo) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hireDate = hireDate;
		this.city = city;
		this.email = email;
		this.phoneNo = phoneNo;
	}

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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Skill getSkills() {
		return skills;
	}

	public void setSkills(Skill skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", hireDate="
				+ hireDate + ", city=" + city + ", email=" + email + ", phoneNo=" + phoneNo + ", skills=" + skills
				+ "]";
	}
	
	
}
